<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//요청 JSP 문서 및 스레드가 이동된 JSP 문서에 적용
	request.setCharacterEncoding("utf-8");

	//전달값을 반환받아 저장
	String category=request.getParameter("category");
	if(category==null) { //JSP 문서 요청 시 전달된 값이 없는 경우
		category="main";
	}
	
	String headFileName="header.jsp";
	String masterName="";
	
	//전달값을 비교하여 Header 영역에 포함될 JSP 문서의 파일명 및 관리자명 저장
	if(category.equals("main")) {
		headFileName="header_main.jsp";
		masterName="홍길동(hong@itwill.xyz)";
	} else if (category.equals("blog")) {
		headFileName="header_blog.jsp";
		masterName="임꺽정(hong@itwill.xyz)";
	} else if (category.equals("cafe")) {
		headFileName="header_cafe.jsp";
		masterName="전우치(hong@itwill.xyz)";
	} else {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<%-- Header 영역 --%>
	<%-- <h1>메인페이지</h1>
	<a href="index.jsp?category=main">메인</a>&nbsp;&nbsp;
	<a href="index.jsp?category=blog">블로그</a>&nbsp;&nbsp;
	<a href="index.jsp?category=cafe">카페</a>&nbsp;&nbsp;
	<hr> --%>
	
	<%-- include Directive : 외부파일(JSPF)을 읽어 소스코드(CSL 및 SSL)를 JSP 문서에 포함 --%>
	<%-- ㄴ file 속성값으로 설정된 외부파일의 소스코드를 포함하여 실행한 후 실행결과를 전달하여 응답 --%>
	<%-- ㄴ 외부파일의 내용이 변경될 경우 JSP 문서가 변경된 것과 동일하므로 JSP 문서에 대한 재해석 필요 --%>
	<%-- ㄴ file 속성값으로 JSP의 표현식(Expression) 사용 불가능 - 속성값으로 설정된 외부파일의 소스코드만 포함(정적포함) --%>
	<%-- <%@include file="header.jspf" %> --%>
	
	<%-- include ActionTag : 스레드가 이동된 JSP 문서의 실행결과(CSL)를 제공받아 JSP 문서에 포함 --%>
	<%-- 형식) <jsp:include page="JSP"></jsp:include> 또는 <jsp:include page="JSP"/> --%>
	<%-- ㄴ page 속성값으로 설정된 JSP 문서가 없는 경우 에러 발생 - 5XX --%>
	<%-- ㄴ page 속성값으로 설정된 JSP 문서로 스레드를 이동하여 실행한 후 실행결과를 제공받아 포함하고
	요청 JSP 문서의 실행결과를 클라이언트에게 전달하여 응답 --%>
	<%-- ㄴ 스레드가 이동될 JSP 문서의 내용이 변경될 경우 해당 JSP 문서만 변경된 것이므로 
	요청 JSP 문서에 대한 재해석 불필요 --%>
	<%-- ㄴ PAGE 속성값으로 JSP의 표현식(Expression) 사용 가능 - 표현식에서 사용된 변수값에 따라 
	서로 다른 JSP 문서의 응답결과를 포함(동적포함) --%>
	<%-- <jsp:include page="header.jsp"/> --%>
	<jsp:include page="<%=headFileName %>"/>

	<%-- Content 영역 --%>
	<p>요청에 의해 응답되는 아주 중요한 내용입니다.</p>
	<p>요청에 의해 응답되는 아주 중요한 내용입니다.</p>
	<p>요청에 의해 응답되는 아주 중요한 내용입니다.</p>
	<p>요청에 의해 응답되는 아주 중요한 내용입니다.</p>
	<p>요청에 의해 응답되는 아주 중요한 내용입니다.</p>
	
	<%-- Footer 영역 --%>
	<%-- <p>Copyright ⓒitwill Corp. All rights reserved.</p>
	<p>관리자 : <%=masterName %></p> --%>
	
	<%-- param ActionTag : 스레드가 이동된 JSP 문서로 값을 전달하는 태그
	<%--ㄴ 리퀘스트 메세지(request 객체)의 Body에 값을 저장하여 스레드가 이동된 JSP 문서로 전달 --%>
	<%--ㄴ include 태그 또는 forward 태그의 자식태그로만 사용 가능 --%>
	<%-- 주의) include 태그 또는 forward 태그에 자식태그로 param 태그를 제외한 코드가 존재할 경우
	에러 발생 - JSP 주석문은 예외 --%>
	<jsp:include page="footer.jsp">
		<jsp:param value="<%=masterName %>>" name="masterName"/>
	</jsp:include>
</body>
</html>