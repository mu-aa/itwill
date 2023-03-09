<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 비로그인 사용자 : 사용자로부터 로그인정보(아이디와 비밀번호)를 입력받기 위한 JSP 문서 --%>    
<%-- => [로그인]을 클릭한 경우 form 태그를 실행하여 로그인 처리페이지(login_action.jsp)를
[post] 방식으로 요청하여 이동 - 인증정보 전달 --%>
<%-- 로그인 사용자 : 클라이언트에게 환영메세지를 전달하는 JSP 문서 --%>
<%
	//session 내장객체에 저장된 권한 관련 속성값(아이디)을 반환받아 저장
	String loginId=(String)session.getAttribute("loginId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<% if(loginId==null) {  //비로그인 사용자가 JSP 문서를 요청한 경우 } %>
	//session 내장객체에 저장된 속성값(에러메세지)을 반환받아 저장
<%	String message=(String)session.getAttribute("message");
	if(message==null) {
		message="";
	} else {
		//다른 JSP 문서에서 session 내장객체에 저장된 속성값(에러메세지)을 사용하지 못하도록 속성값 삭제
		session.removeAttribute("message");
	}
	
	//session 내장객체에 저장된 권한 관련 속성값(아이디)을 반환받아 저장
	String id=(String)session.getAttribute("id");
	if(id==null) {
		id="";
	} else {
		session.removeAttribute("id");
	}
%>
	<h1>로그인</h1>
	<hr>
	<form action="login_action.jsp" method="post" name="loginForm">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" value="<%=id%>"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="passwd"></td>
		</tr>
		<tr>
			<td colspan="2"><button type="button" id="loginBtn">로그인</button></td>
		</tr>
	</table>
	</form>
	<p id="message" style="color: red;"><%=message %></p>
	
	<script type="text/javascript">
	loginForm.id.focus();
	
	document.getElementById("loginBtn").onclick=function() {
		if(loginForm.id.value=="") {
			document.getElementById("message").innerHTML="아이디를 입력해 주세요.";
			loginForm.id.focus();
			return;
		}
		
		if(loginForm.passwd.value=="") {
			document.getElementById("message").innerHTML="비밀번호를 입력해 주세요.";
			loginForm.passwd.focus();
			return;
		}
		
		loginForm.submit();
	}
	</script>
<% } else {//로그인 사용자가 JSP 문서를 요청한 경우 %>
	<h1>메인페이지</h1>
	<hr>
	<p><%=loginId %>님, 환영합니다.&nbsp;&nbsp;
	<a href="logout_action.jsp">[로그아웃]</a>&nbsp;&nbsp;
	<a href="login_user.jsp">[마이페이지]</a>
<% } %>
</body>
</html>