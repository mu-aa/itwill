<?xml version="1.0" encoding="utf-8"?>
<%@page import="xyz.itwill.dto.AjaxMemberDTO"%>
<%@page import="xyz.itwill.dao.AjaxMemberDAO"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 이름과 이메일을 전달받아 AJAX_MEMBER 테이블에 저장된 해당 이름과 이메일을 사용하는
회원의 아이디를 검색하여 XML 데이터를 응답하는 JSP 문서 --%>
<%
	if(request.getMethod().equals("GET")) { //비정상적인 요청 처리
		response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		return;
	}

	request.setCharacterEncoding("utf-8"); //한글로 Charset 설정

	String name=request.getParameter("name"); //전달값 저장
	String email=request.getParameter("email"); //전달값 저장
	
	//이름과 이메일을 입력해 AJAX_MEMBER 테이블에서 일치하는 id를 반환하는 DAO 클래스의 메소드 호출
	//String id=AjaxMemberDAO.getDAO().selectAjaxMemberId(name, email);

	AjaxMemberDTO ajaxMember=new AjaxMemberDTO();
	ajaxMember.setName(name);
	ajaxMember.setEmail(email);
	String id=AjaxMemberDAO.getDAO().selectAjaxMemberId(ajaxMember); //이게 더 좋음(전달값 하나로 처리)
%>
<result>
	<% if(id!=null) { //검색된 아이디가 있는 경우 %>
		<code>ok</code>
		<id><%=id %></id>
	<% } else { //검색된 아이디가 없는 경우%>
		<code>empty</code>
	<% } %>
</result>