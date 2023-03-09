<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@page import="xyz.itwill.dto.BoardDTO"%>
<%@page import="xyz.itwill.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 글번호를 전달받아 BOARD 테이블에 저장된 해당 글번호의 게시글을 검색하여 클라이언트에게 전달하는 JSP 문서 --%>
<%-- ㄴ [글변경]을 클릭한 경우 게시글 입력페이지(board_modify.jsp)로 이동 - 글번호, [페이지번호, 검색대상, 검색단어]-연속성유지목적 전달 --%>
<%-- ㄴ [글삭제]를 클릭한 경우 게시글 삭제페이지(board_remove_action.jsp)로 이동 - 글번호 전달 --%>
<%-- ㄴ [답글쓰기]를 클릭한 경우 게시글 입력페이지(board_write.jsp)로 이동 - 그룹번호(ref), 답글순서(reStep), 답글깊이(reLevel), 페이지번호 전달 --%>
<%-- ㄴ [글목록]을 클릭한 경우 게시글목록 출력페이지(board_list.jsp)로 이동 - [페이지번호, 검색대상, 검색단어]-연속성유지목적 전달 --%>
<%-- ㄴ [글변경]과 [글삭제]는 관리자 또는 게시글 작성자에게만 링크를 제공하고 [답글쓰기]는 로그인 사용자에게만 링크 제공 --%>
<%
	//비정상적인 요청에 대한 응답 처리
	if(request.getParameter("num")==null) {
		out.print("<script type='text/javascript'>");
		out.print("location.href='"+request.getContextPath()+"/index.jsp?workgroup=error&work=error_400'");
		out.print("</script>");
		return;
	}

	//전달값을 반환받아 저장
	int num=Integer.parseInt(request.getParameter("num"));  //  ┐
	String pageNum=request.getParameter("pageNum");			//  │ board_list 페이지의 연속성을
	String search=request.getParameter("search");			//  │ 유지하기 위해 필요한 변수값
	String keyword=request.getParameter("keyword");			//  ┘
	
	//글번호를 전달받아 BOARD 테이블에 저장된 해당 글번호의 게시글을 검색하여 반환하는 DAO 클래스 메소드 호출
	BoardDTO board=BoardDAO.getDAO().selectBoard(num);
	
	//검색된 게시글이 없거나 삭제 게시글인 경우 - 비정상적인 요청
	if(board==null || board.getStatus()==0) { 
		out.print("<script type='text/javascript'>");
		out.print("location.href='"+request.getContextPath()+"/index.jsp?workgroup=error&work=error_400'");
		out.print("</script>");
		return;
	}
	
	//세션에 저장된 권한 관련 정보(회원정보)를 반환받아 저장
	MemberDTO loginMember=(MemberDTO)session.getAttribute("loginMember");
	
	if(board.getStatus()==2) { //비밀 게시글인 경우
		//비로그인 사용자이거나 로그인 사용자가 게시글 작성자 또는 관리자가 아닌 경우
		//ㄴ 권한이 없는 사용자가 JSP 문서를 요청한 경우 - 비정상적인 요청
		if(loginMember==null || !loginMember.getId().equals(board.getId()) && loginMember.getStatus()==9) {
			out.print("<script type='text/javascript'>");
			out.print("location.href='"+request.getContextPath()+"/index.jsp?workgroup=error&work=error_400'");
			out.print("</script>");
			return;
		}
	}
	
	//글번호를 전달받아 BOARD 테이블에 저장된 해당 글번호의 게시글 조회수를 1 증가시키는 DAO 클래스의 메소드 호출
	BoardDAO.getDAO().updateReadCount(num);
%>
<style type="text/css">
#board_detail {
	width: 500px;
	margin: 0 auto;
}

talbe {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	border: 1px solid black;
	padding: 5px;
}

th {
	width: 100px;
	background-color: black;
	color: white;
}

td {
	width: 400px;
}

.subject, .content {
	text-align: left;
}

.content {
	height: 100px;
	vertical-align: middle;
}

#board_menu {
	text-align: right;
	margin: 5px;
}
</style>
<div id="board_detail">
	<h2>게시글</h2>
	<table>
		<tr>
			<th>작성자</th>
			<td>
				<%=board.getWriter()%>
				<% if(loginMember!=null && loginMember.getStatus()==9) { //관리자인 경우 %>
					[<%=board.getIp() %>]
				<% } %>
			</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>
				<%=board.getRegDate() %>
			</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>
				<%=board.getReadCount()+1 %>
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td class="subject">
				<% if(board.getStatus()==2) { //비밀글인 경우 %>
					[비밀글]
				<% } %>
				<%=board.getSubject() %>
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td class="content">
				<%=board.getContent().replace("\n", "<br>") %>
			</td>
		</tr>
	</table>
	
	<div id="board_menu">
		<%-- 로그인 사용자 중 게시글 작성자이거나 관리자인 경우에만 태그를 이용하여 링크 제공 --%>
		<% if(loginMember!=null && (loginMember.getId().equals(board.getId()) || loginMember.getStatus()==9)) { %>
			<button type="button" id="modifyBtn">글변경</button>
			<button type="button" id="removeBtn">글삭제</button>
		<% } %>
		<%-- 로그인 사용자인 경우에만 태그를 이용하여 링크 제공 --%>
		<% if(loginMember!=null) { %>
			<button type="button" id="replyBtn">답글쓰기</button>
		<% } %>
		<button type="button" id="listBtn">글목록</button>
	</div>

<%-- 요청 페이지에 값을 전달하기 위한 form 태그 --%>
	<form action="<%=request.getContextPath()%>/index.jsp" method="get" id="menuForm">
		<input type="hidden" name="workgroup" value="board">
		<input type="hidden" name="work" id="work">
	
		<%-- [글변경] 및 [글삭제]를 클릭한 경우 전달되는 값 --%>
		<input type="hidden" name="num" value="<%=board.getNum()%>">
		
		<%-- [글변경] 및 [글목록]를 클릭한 경우 전달되는 값 --%>
		<input type="hidden" name="pageNum" value="<%=pageNum%>">
		<input type="hidden" name="search" value="<%=search%>">
		<input type="hidden" name="keyword" value="<%=keyword%>">
		
		<%-- [답글쓰기]를 클릭한 경우 전달되는 값 --%>
		<input type="hidden" name="ref" value="<%=board.getRef()%>">
		<input type="hidden" name="reStep" value="<%=board.getReStep()%>">
		<input type="hidden" name="reLevel" value="<%=board.getReLevel()%>">
	</form>
</div>

<script type="text/javascript">
$("#modifyBtn").click(function() {
	$("#work").val("board_modify");
	$("#menuForm").submit();
});
$("#removeBtn").click(function() {
	if(confirm("게시글을 삭제 하시겠습니까?")) {
		$("#work").val("board_remove_action");
		$("#menuForm").submit();
	}
});
$("#replyBtn").click(function() {
	$("#work").val("board_write");
	$("#menuForm").submit();
});
$("#listBtn").click(function() {
	$("#work").val("board_list");
	$("#menuForm").submit();
});
</script>