<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 입력페이지(useBean_form.jsp)에서 전달된 값을 반환받아 내장객체의 속성값으로 저장하고 
출력페이지(useBean_display.jsp)로 forward 이동 처리하는 JSP 문서 --%>
<%
	//비정상적인 요청 처리
	if(request.getMethod().equals("GET")) {
		response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		return;
	}

	//POST 방식으로 요청하여 전달된 값에 대한 Charset 변경
	request.setCharacterEncoding("utf-8");
%>
<%-- useBean AcrtionTag : JSP 문서에 객체를 제공하기 위한 태그 --%>
<%-- 형식) <jsp:useBean id="식별자" class="클래스" scope="사용범위"/> --%>
<%-- ㄴ 내장객체에 저장된 속성값을 객체로 반환받아 제공하거나 속성값이 없으면 객체를 생성하여 
내장객체의 속성값으로 저장 후 제공 - 있으면 사용, 없으면 만들어서 사용 --%>
<%-- id 속성(필수) : useBean 태그로 제공될 객체를 구분하기 위한 식별자를 속성값으로 설정 --%>
<%-- ㄴ 내장객체에 저장된 속성값을 구분하기 위한 속성명을 표현하여 속성값을 제공받아 사용 --%>
<%-- class 속성(필수) : useBean 태그로 제공될 객체의 자료형을 속성값으로 설정 --%>
<%-- scope 속성(선택) : useBean 태그로 제공될 객체의 사용범위를 속성값으로 설정 --%>
<%-- ㄴ page(default), request, session, application 중 하나를 속성값으로 설정 --%>
<jsp:useBean id="user" class="xyz.itwill.bean.User" scope="request"/>
<%--
	==
	User user=new User();
	request.setAttribute("user", user);
 --%>
 
<%-- setProperty ActionTag : useBean 태그로 제공된 객체의 필드값을 변경하기 위한 태그 --%>
<%-- ㄴ 객체 필드의 Setter 메소드를 호출하여 객체의 필드값 변경 --%>
<%-- 형식) <jsp:setProperty name="식별자" property="필드명" value="값"/> --%>
<%-- name 속성(필수) : useBean 태그로 제공된 객체의 식별자(id 속성값)를 속성값으로 설정 --%>
<%-- property(필수) : 값을 변경할 필드명을 속성값으로 설정 --%>
<%-- ㄴ 필드명을 기반으로 작성된 Setter 메소드 자동 호출 - 작성된 Setter 메소드가 없는 경우 에러 발생 --%>
<%-- value(선택) : 필드에 저장될 변경값을 속성값으로 설정 --%>
<%-- ㄴ value 속성을 생략하면 JSP 문서 요청 시 전달된 값을 반환받아 필드값 변경 --%>
<%-- <jsp:setProperty name="user" property="name"  value="홍길동" /> --%> <%-- == user.setName("홍길동"); --%>

<%-- 주의) JSP 문서 요청 시 전달된 값의 이름과 setProperty 태그의 property 속성(객체의 필드명)이 
반드시 동일해야만 전달값을 반환받아 필드값으로 변경 가능 --%>
<%-- 
	<jsp:setProperty name="user" property="name"/> 
	<jsp:setProperty name="user" property="phone"/>
	<jsp:setProperty name="user" property="address"/>
--%>
<%-- property 속성값을 [*]로 설정한 경우 모든 전달값을 반환받아 객체의 필드값 변경 --%>
<%-- ㄴ 전달값의 이름과 필드명이 동일한 경우에만 전달값을 반환받아 필드값 변경 --%>
<jsp:setProperty name="user" property="*"/>

<%-- ==
	 user.setName(request.getParameter("name")); 
	 user.setPhone(request.getParameter("phone")); 
	 user.setAddress(request.getParameter("address")); 
 --%>
 
 <jsp:forward page="useBean_display.jsp"/>
 <%-- ==
 	request.getRequestDispatcher("non_useBean_display.jsp").forward(request, response);
 --%>