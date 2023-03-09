<%@page import="xyz.itwill.el.Member"%>
<%@page import="xyz.itwill.el.Car"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- Member 객체를 생성하여 Request Scope 속성값으로 저장하고 다른 웹프로그램(JSP)로
Forward 이동하는 JSP 문서 - 요청을 처리하는 웹프로그램(Model) --%>
<%
	Member member=new Member("홍길동", new Car("싼타페", "하얀색"));

	//request 내장객체에 Member 객체를 속성값으로 저장 - Request Scope
	//Request Scope : scope 속성값을 저장한 웹프로그램과 스레드가 이동된 웹프로그램에서만
	//속성값을 객체로 반환받아 사용 가능 
	request.setAttribute("member", member);
	
	//Forward 이동 : 현재 웹프로그램의 명령을 실행하는 Thread를 다른 웹프로그램으로 이동시켜
	//명령을 실행하도록 제공하는 기능
	//ㄴ Thread가 이동되는 웹프로그램에서는 실행중인 현재 웹프로그램의 request, response 객체를 전달받아 사용
	//request.getRequestDispatcher("member_non_el.jsp").forward(request, response);
	request.getRequestDispatcher("member_el.jsp").forward(request, response);
%>