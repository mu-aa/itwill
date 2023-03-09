<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 로그인 사용자의 정보를 클라이언트에게 전달하는 JSP 문서 --%>
<%-- ㄴ 로그인 사용자만 요청 가능한 JSP 문서 --%>
<%-- ㄴ [회원정보변경]을 클릭한 경우 비밀번호 입력페이지(password_confirm.jsp)로 이동 - 페이지 이동 관련 정보 전달 --%>
<%-- ㄴ [회원탈퇴]를 클릭한 경우 비밀번호 입력페이지(password_confirm.jsp)로 이동 -  --%>
<%--
	//세션에 저장된 권한 관련 정보를 반환받아 저장
	MemberDTO loginMember=(MemberDTO)session.getAttribute("loginMember");

	//비로그인 사용자가 JSP 문서를 요청한 경우 - 비정상적인 요청
	if(loginMember==null) {
		out.print("<script type='text/javascript'>");
		out.print("location.href='"+request.getContextPath()+"/index.jsp?workgroup=error&work=error_404';");
		out.print("</script>");
		return;
	}
--%>
<%-- 권한 관련 중복코드를 JSPF 파일로 작성하여 include 디렉티브로 포함 --%>
<%-- ㄴ 코드의 중복을 최소화 하여 생산성을 높이고 유지보수 효율성 증가 --%>
<%@include file="/security/login_check.jspf" %>
<style type="text/css">
#detail {
	width: 500px;
	margin: 0 auto;
	text-align: left;
}
#link {
	font-size: 1.1em;
}
#link a:hover {
	color: orange;
}
</style>
<h1>내정보</h1>
<div id="detail">
	<p>아이디 = <%=loginMember.getId() %></p>
	<p>이름 = <%=loginMember.getName() %></p>
	<p>이메일 = <%=loginMember.getEmail() %></p>
	<p>전화번호 = <%=loginMember.getMobile() %></p>
	<p>주소 = [<%=loginMember.getZipcode() %>] <%=loginMember.getAddress1() %> <%=loginMember.getAddress2() %></p>
	<p>회원가입 날짜 = <%=loginMember.getJoinDate() %></p>
	<p>마지막 로그인 날짜 = <%=loginMember.getLastLogin() %></p>
</div>

<div id="link">
	<a href="<%=request.getContextPath() %>/index.jsp?workgroup=member&work=password_confirm&action=modify">[회원정보변경]</a>&nbsp;&nbsp;
	<a href="<%=request.getContextPath() %>/index.jsp?workgroup=member&work=password_confirm&action=remove">[회원탈퇴]</a>&nbsp;&nbsp;
</div>