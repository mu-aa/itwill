<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 사용자로부터 게시글(새글 또는 답글)을 입력받기 위한 JSP 문서 --%>
<%-- ㄴ 로그인 사용자만 요청 가능한 JSP 문서 --%>
<%-- ㄴ [글저장]을 클릭한 경우 게시글 삽입페이지(board_write_action.jsp)로 이동 - 입력값 전달 --%>

<%-- 비로그인 사용자가 JSP 문서를 요청한 경우 에러페이지로 이동되도록 응답 처리 --%>
<%-- ㄴ 비정상적인 요청에 대한 응답 처리 --%>
<%@include file="/security/login_check.jspf" %>

<%-- 새글 : board_list.jsp 문서에 의해 요청한 경우 - 전달값 : X --%>
<%-- 답글 : board_detail.jsp 문서에 의해 요청한 경우 - 전달값 : O(부모글 관련 정보 전달) --%>
<%-- ㄴ 부모글 관련 정보 : ref, reStep, reLevel, pageNum --%>
<%
	//전달값을 반환받아 저장 - 전달값이 없는 경우(새글인 경우) 초기값 저장
	String ref="0", reStep="0", reLevel="0", pageNum="1";
	if(request.getParameter("ref")!=null) { //전달값이 있는(답글) 경우
		ref=request.getParameter("ref");
		reStep=request.getParameter("reStep");
		reLevel=request.getParameter("reLevel");
		pageNum=request.getParameter("pageNum");
	}
%>
<style type="text/css">
table {
	margin: 0 auto;
}

th {
	width: 70px;
	font-weight: normal;
}

td {
	text-align: left;
}
</style>
<% if(ref.equals("0")) { //새글인 경우 %>
	<h2>새글쓰기</h2>
<% } else { //답글인 경우 %>
	<h2>답글쓰기</h2>
<% } %>

<form action="<%=request.getContextPath()%>/index.jsp?workgroup=board&work=board_write_action"
	method="post" id="boardForm">
	<input type="hidden" name="ref" value="<%=ref %>">
	<input type="hidden" name="reStep" value="<%=reStep %>">
	<input type="hidden" name="reLevel" value="<%=reLevel %>">
	<input type="hidden" name="pageNum" value="<%=pageNum %>">
	<table>
		<tr>
			<th>제목</th>
			<td>
				<input type="text" name="subject" id="subject" size="40">
				<input type="checkbox" name="secret" value="2">비밀글
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea rows="7" cols="60" name="content" id="board_content"></textarea>
			</td>
		</tr>
		<tr>
			<th colspan="2">
				<button type="submit">글저장</button>
				<button type="reset" id="resetBtn">다시쓰기</button>
			</th>
		</tr>
	</table>
</form>

<div id="message" style="color: red;"></div>

<script type="text/javascript">
$("#subject").focus();

$("#boardForm").submit(function() {
	if($("#subject").val()=="") {
		$("#message").text("제목을 입력해주세요.");
		$("#subject").focus();
		return false;
	}

	if($("#board_content").val()=="") {
		$("#message").text("내용을 입력해주세요.");
		$("#content").focus();
		return false;
	}
});

$("#resetBtn").click(function() {
	$("#subject").focus();
	$("#message").text("");
});
</script>