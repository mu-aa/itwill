<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 입력페이지(join_form.jsp)에서 전달된 회원정보를 반환받아 클라이언트에게 전달하는 JSP 문서 --%>
<%
	//비정상적인 요청에 대한 처리 - 클라이언트에게 에러코드 또는 에러페이지(입력페이지)로
	//이동하기 위한 URL 주소 전달
	//request.getMethod() : 클라이언트의 요청방식(GET/POST)을 반환하는 메소드
	if(request.getMethod().equals("GET")) { //JSP 문서를 [GET] 방식으로 요청한 경우 - 비정상적인 요청
		//response.sendError(int sc) : 클라이언트에게 에러코드(4XX OR 5XX)를 전달하는 메소드
		//ㄴ 응답 관련 상태코드는 HttpServletResponse 인터페이스의 상수(Constant)로 제공
		//response.sendError(400);
		/*
		response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED); //405
		return;
		*/
		
		//response.sendRedirect(String location) : 클라이언트에게 요청 URL 주소를 전달하는 메소드
		//ㄴ 클라이언트는 요청 URL 주소를 전달받아 브라우저의 URL 주소를 변경하고 웹프로그램을
		//요청하여 결과를 응답받아 출력 - 리다이렉트(Redirect) 이동
		//ㄴ Redirect 이동의 URL 주소는 서버의 최상위 디렉토리를 기준으로 절대경로로 표현 가능
		//response.sendRedirect("/jsp/error/error_400.jsp"); //에러페이지 이동
		//return;
		
		//response.sendRedirect("join_form.jsp"); //입력페이지 이동
		//return;
		
		/*
		out.println("<script type='text/javascript'>");
		out.println("alert('비정상적인 방법으로 요청했습니다.');");
		out.println("location.href='join_form.jsp';");
		out.println("</script>");
		return;
		*/
		
		//QueryString을 이용하여 요청 JSP 문서에 값 전달 가능
		//ㄴ 질의문자열을 이용하여 전달할 수 있는 값은 영문자, 숫자, 일부 특수문자로만 구성된 값만 가능
		//문제점) 영문자, 숫자, 일부 특수문자를 제외한 문자는 전달 불가능
		//해결법) 영문자, 숫자, 일부 특수문자를 제외한 문자는 부호화 처리하여 전달
		//URLEncoder.encode(String s, String charset) : 문자열을 전달받아 원하는 문자형태의
		//문자열로 부호화 처리하여 반환하는 메소드 - JavaScript의 encodeURIComponent 함수와 동일
		/*
		String message=URLEncoder.encode("비정상적인 방법으로 요청했습니다.", "utf-8");
		response.sendRedirect("join_form.jsp?message="+message); //입력페이지 이동 - 값 전달
		return;
		*/
		
		//session 내장객체에 에러메세지를 속성값으로 저장
		//ㄴ 같은 클라이언트의 모든 JSP 문서에서 속성값을 반환받아 사용 가능
		session.setAttribute("message", "비정상적인 방법으로 요청했습니다.");
		response.sendRedirect("join_form.jsp");
		return;
	}

	//[POST] 방식으로 요청하여 전달된 값에 대한 Charset 변경
	//request.setCharacterEncoding(String encoding) : 리퀘스트 메세지 Body에 저장된 값에 대한
	//문자형태(CharacterSet)을 변경하는 메소드 - 기본값 : ISO-8850-1
	request.setCharacterEncoding("utf-8");
	
	//전달값을 반환받아 저장
	//request.getParameter(String name) : 전달값을 문자열(String 객체)로 반환하는 메소드
	//ㄴ 입력태그의 name 속성값 또는 QueryString의 이름으로 전달값 구분
	String id=request.getParameter("id");
	String pass=request.getParameter("pass");
	String name=request.getParameter("name");
	String addr=request.getParameter("addr");
	String gender=request.getParameter("gender");
	String job=request.getParameter("job");
	//getParameterValues(String name) : 같은 이름으로 전달되는 모든 값을 문자열(String 객체) 배열로 반환하는 메소드
	String[] hobby=request.getParameterValues("hobby");
	String profile=request.getParameter("profile");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>회원정보확인</h1>
	<hr>
	<p>아이디 = <%=id %></p>
	<p>비밀번호 = <%=pass %></p>
	<p>이름 = <%=name %></p>
	<p>주소 = <%=addr %></p>
	<p>성별 = <%=gender %></p>
	<p>직업 = <%=job %></p>
	<% if(hobby==null) { %>
		<p>취미 = 미선택</p>
	<% } else { %>
		<p>취미 =
		<% for(String temp:hobby) { %>
			<%=temp %>&nbsp;
		<% } %>
	<% } %>
	<%-- Enter를 br 태그로 변환하여 출력 처리 --%>
	<p>자기소개 = <%=profile.replace("\n", "<br>") %></p>
</body>
</html>