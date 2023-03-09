<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@page import="xyz.itwill.dto.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="xyz.itwill.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- BOARD 테이블에 저장된 게시글을 검색하여 게시글 목록을 클라이언트에게 전달하는 JSP 문서 --%>
<%-- ㄴ 게시글 목록을 페이지로 구분 검색하여 응답 처리 - 페이징 처리 --%>    
<%-- ㄴ [페이지 번호]를 클릭한 경우 게시글목록 출력페이지(board_list.jsp)로 이동 - 페이지 번호, 검색대상(컬럼명), 검색단어 전달 --%>
<%-- ㄴ [검색]을 클릭한 경우 게시글목록 출력페이지(board_list.jsp)로 이동 - 검색대상(컬럼명), 검색단어 전달  --%>
<%-- ㄴ [글쓰기]를 클릭한 경우 게시글 입력페이지(board_write.jsp)로 이동 - 로그인 사용자에게만 링크 제공 --%>
<%-- ㄴ [게시글 제목]을 클릭한 경우 게시글 출력페이지(board_detail.jsp)로 이동 - 글 --%>
<%
	//검색대상과 검색단어를 반환받아 저장
	String search=request.getParameter("search");
	if(search==null) {
		search="";
	}
	
	String keyword=request.getParameter("keyword");
	if(keyword==null) {
		keyword="";
	}
	
	//페이징 처리 관련 전달값(요청 페이지 번호)를 반환받아 저장
	// => 요청 페이지 번호에 대한 전달값이 없는 경우 첫번째 페이지의 게시글 목록을 검색하여 응답
	int pageNum=1;
	if(request.getParameter("pageNum")!=null) {//전달값이 있는 경우
		pageNum=Integer.parseInt(request.getParameter("pageNum"));
	}
	
	//하나의 페이지에 검색되어 출력될 게시글의 갯수 설정 - 전달값을 반환받아 저장 가능
	int pageSize=10;
	
	//BOARD 테이블에 저장된 전체 게시글의 갯수를 검색하여 반환하는 DAO 클래스의 메소드 호출
	// => 검색 기능 미구현시 호출하는 메소드 => 동적 SQL을 사용해 하나의 메소드로 처리 ┐
	//int totalBoard=BoardDAO.getDAO().selectBoardCount();							   ↓
	  
	//검색 관련 정보를 전달받아 BOARD 테이블에 저장된 특정 게시글의 갯수를 검색하여 반환하는 DAO 클래스의 메소드 호출
	int totalBoard=BoardDAO.getDAO().selectBoardCount(search, keyword);
	
	//전체 페이지의 갯수를 계산하여 저장
	//int totalPage=totalBoard/pageSize+totalBoard%pageSize==0?0:1;
	int totalPage=(int)Math.ceil((double)totalBoard/pageSize);
	  
	//요청 페이지 번호에 대한 검증
	if(pageNum<=0 || pageNum>totalPage) {//비정상적인 요청 페이지 번호인 경우
		pageNum=1;//첫번째 페이지의 게시글 목록이 검색되어 응답되도록 요청 페이지 번호 변경
	}
	
	//요청 페이지 번호에 대한 시작 게시글의 행번호를 계산하여 저장
	//ex) 1Page : 1, 2Page : 11, 3Page : 21, 4Page : 31, ...
	int startRow=(pageNum-1)*pageSize+1;
                     
	//요청 페이지 번호에 대한 종료 게시글의 행번호를 계산하여 저장
	//ex) 1Page : 10, 2Page : 20, 3Page : 30, 4Page : 40, ...
	int endRow=pageNum*pageSize;
	
	//마지막 페이지에 대한 종료 게시글의 행번호를 검색 게시글의 갯수로 변경
	if(endRow>totalBoard) {
		endRow=totalBoard;
	}
	
	//요청 페이지에 대한 시작 게시글의 행번호와 종료 게시글의 행번호를 전달받아 BOARD 테이블에
	//저장된 게시글에서 해당 범위의 게시글만을 검색하여 반환하는 DAO 클래스의 메소드 호출
	// => 검색 기능 미구현시 호출하는 메소드 => 동적 SQL로 처리
	//List<BoardDTO> boardList=BoardDAO.getDAO().selectBoardList(startRow, endRow);
	
	//검색 관련 정보 및 요청 페이지에 대한 시작 게시글의 행번호와 종료 게시글의 행번호를 전달받아 BOARD 테이블에
	//저장된 특정 게시글에서 해당 범위의 게시글만을 검색하여 반환하는 DAO 클래스의 메소드 호출
	List<BoardDTO> boardList=BoardDAO.getDAO().selectBoardList(startRow, endRow, search, keyword);
	
	//세션에 저장된 권한 관련 정보를 반환받아 저장
	// => 로그인 사용자에게만 글쓰기 권한 제공
	// => 비밀 게시글인 경우 로그인 사용자가 게시글 작성자이거나 관리자인 경우에만 접근 권한 제공
	MemberDTO loginMember=(MemberDTO)session.getAttribute("loginMember");
	
	//서버 시스템의 현재 날짜를 반환받아 저장
	// => 게시글의 작성날짜를 현재 날짜와 비교하여 구분 출력
	String currentDate=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	
	//요청 페이지에 검색되어 출력될 게시글의 출력번호에 대한 시작값을 계산하여 저장
	//ex)전체 게시글의 갯수 : 91 >> 1Page : 91~82, 2Page : 81~72, 3Page : 71~62,...
	int pritnNum=totalBoard-(pageNum-1)*pageSize;
%>                      
<style type="text/css">
#board_list {
	width: 1000px;
	margin: 0 auto;
	text-align: center;
}

#board_title {
	font-size: 1.2em;
	font-weight: bold;
}

table {
	margin: 5px auto;
	border: 1px solid black;
	border-collapse: collapse;
}

th {
	border: 1px solid black;
	background-color: black;
	color: white;
}

td {
	border: 1px solid black;
	text-align: center;
}

.subject {
	text-align: left;
	padding: 5px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}

#board_list a:hover {
	text-decoration: none;
	color: red;
	font-weight: bold;
}

.secret, .remove {
	background-color: black;
	color: white;
	font-size: 14px;
	border: 1px solid black;
	border-radius: 4px;
}
</style>

<div id="board_list">
	<div id="board_title">게시글 목록(게시글 갯수 : <%=totalBoard %>)</div>

	<% if(loginMember!=null) {//로그인 사용자가 JSP 문서를 요청한 경우 %>
	<div style="text-align: right;">
		<button type="button" onclick="location.href='<%=request.getContextPath()%>/index.jsp?workgroup=board&work=board_write';">글쓰기</button>
	</div>	
	<% } %>

	<%-- 게시글 목록 출력 --%>
	<table>
		<tr>
			<th width="100">번호</th>
			<th width="500">제목</th>
			<th width="100">작성자</th>
			<th width="100">조회수</th>
			<th width="200">작성일</th>
		</tr>
	
		<% if(totalBoard==0) { %>
		<tr>
			<td colspan="5">검색된 게시글이 없습니다.</td>
		</tr>	
		<% } else { %>
			<%-- List 객체에서 요소(BoardDTO 객체)를 하나씩 제공받아 반복 처리 --%>
			<% for(BoardDTO board:boardList) { %>
			<tr>
				<%-- 일련번호 : BOARD 테이블에 저장된 게시글의 글번호가 아닌 일련번호로 응답 --%>
				<td><%=pritnNum %></td>
				<% pritnNum--; %><%-- 일련번호를 1씩 감소시켜 저장  --%> 

				<%-- 제목 --%>
				<td class="subject">
					<%-- 게시글이 답글인 경우에 대한 응답 처리 --%>
					<% if(board.getReStep()!=0) {//게시글이 답글인 경우 %>
						<%-- 게시글의 깊이에 의해 왼쪽 여백을 다르게 설정하여 응답되도록 처리 --%>
						<span style="margin-left: <%=board.getReLevel()*20%>px;">└[답글]</span>
					<% } %>
					
					<%-- 게시글 상태를 구분하여 제목과 링크를 다르게 설정하여 응답되도록 처리 --%>
					<% if(board.getStatus()==1) {//일반 게시글인 경우 %>
						<a href="<%=request.getContextPath()%>/index.jsp?workgroup=board&work=board_detail&num=<%=board.getNum() %>&pageNum=<%=pageNum%>&search=<%=search%>&keyword=<%=keyword%>">
							<%=board.getSubject() %>
						</a>
					<% } else if(board.getStatus()==2) {//비밀 게시글인 경우 %>
						<span class="secret">비밀글</span>
						<%-- 로그인 사용자가 작성자이거나 관리자인 경우 --%>
						<% if(loginMember!=null && (loginMember.getId().equals(board.getId()) 
								|| loginMember.getStatus()==9)) { %>
							<a href="<%=request.getContextPath()%>/index.jsp?workgroup=board&work=board_detail&num=<%=board.getNum() %>&pageNum=<%=pageNum%>&search=<%=search%>&keyword=<%=keyword%>">
								<%=board.getSubject() %>
							</a>		
						<% } else { %>
							작성자 또는 관리자만 확인 가능합니다.
						<% } %>		
					<% } else if(board.getStatus()==0) {//삭제 게시글인 경우 %>
						<span class="remove">삭제글</span>
						작성자 또는 관리자에 의해 삭제된 게시글입니다.	
					<% } %>
				</td>
				
				<% if(board.getStatus()!=0) {//삭제 게시글이 아닌 경우 %>
				<%-- 작성자 --%>
				<td><%=board.getWriter() %></td>
				
				<%-- 조회수 --%>
				<td><%=board.getReadCount() %></td>
				
				<%-- 작성일 : 오늘 작성된 게시글은 시간만 출력하고 오늘 작성된 게시글이
				아닌 게시글은 날짜와 시간 출력 --%>
				<td>
					<% if(currentDate.equals(board.getRegDate().substring(0,10))) {//오늘 작성된 게시글인 경우 %>
						<%=board.getRegDate().substring(11) %>
					<% } else {//오늘 작성된 게시글이 아닌 경우 %>
						<%=board.getRegDate() %>
					<% } %>
				</td>
				<% } else {//삭제 게시글인 경우 %>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<% } %>
			</tr>
			<% } %>	
		<% } %>
	</table>
	
	<%-- 페이지 번호 출력 및 링크 설정 --%>
	<%
		//하나의 페이지 블럭에 출력될 페이지 번호의 갯수를 설정
		int blockSize=5;
		
		//페이지 블럭에 출력될 시작 페이지 번호를 계산하여 저장
		//1Block: 1, 2Block: 6, 3Block: 11, 4Block: 16 ...
		int startPage=(pageNum-1)/blockSize*blockSize+1;
	
		//페이지 블럭에 출력될 시작 페이지 번호를 계산하여 저장
		//1Block: 5, 2Block: 10, 3Block: 15, 4Block: 20 ...
		int endPage=startPage+blockSize-1;
		
		//마지막 페이지 블럭의 종료 페이지 번호 변경
		if(endPage>totalPage) {
			endPage=totalPage;
		}
	%>
	<% if(startPage>blockSize) { //첫번째 페이지 블럭이 아닌 경우 - 링크 제공(활성화) %>
		<a href="<%=request.getContextPath() %>/index.jsp?workgroup=board&work=board_list&pageNum=<%=startPage-blockSize%>&search=<%=search%>&keyword=<%=keyword%>">◀</a>
	<% } %>
	
	<% for(int i=startPage;i<=endPage;i++) { %>
		<% if(pageNum!=i) { //요청 페이지 번호와 이벤트 페이지 번호가 다른 경우 - 링크 제공(활성화) %>
			<a href="<%=request.getContextPath() %>/index.jsp?workgroup=board&work=board_list&pageNum=<%=i%>&search=<%=search%>&keyword=<%=keyword%>">[<%=i %>]</a>
		<% } else { //요청 페이지 번호와 이벤트 페이지 번호가 같은 경우 - 링크 미제공(비활성화) %>
			<a style="color: gray">[<%=i %>]</a>
		<% } %>
	<% } %>

	<% if(endPage!=totalPage) { //마지막 페이지 블럭이 아닌 경우 - 링크 제공(활성화) %>
		<a href="<%=request.getContextPath() %>/index.jsp?workgroup=board&work=board_list&pageNum=<%=startPage+blockSize%>&search=<%=search%>&keyword=<%=keyword%>">▶</a>
	<% } %>
	
	<%-- 사용자로부터 검색어를 입력받아 게시글 검색 기능 구현 --%>
	<form action="<%=request.getContextPath() %>/index.jsp?workgroup=board&work=board_list" method="post">
		<%-- select 태그에 의해 전달되는 값은 반드시 검색단어를 비교하기 위해 컬럼명과 같은 이름으로 전달되도록 설정 --%>
		<select name="search">
			<option value="name" selected="selected">&nbsp;작성자&nbsp;</option>
			<option value="subject">&nbsp;제목&nbsp;</option>
			<option value="content">&nbsp;내용&nbsp;</option>
		</select>
		<input type="text" name="keyword">
		<button type="submit">검색</button>
	</form>
</div>