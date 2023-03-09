<%@page import="xyz.itwill.dao.UserinfoModelOneDAO"%>
<%@page import="xyz.itwill.dto.UserinfoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 로그인정보를 입력받아 USERINFO 테이블에 저장된 회원정보와 비교하여 인증 처리 후
로그인정보 입력페이지(user_login.jsp)로 이동을 위한 URL 주소를 전달하는 JSP 문서 --%>
<%-- ㄴ 인증 성공한 경우 세션에 권한 관련 정보를 속성값으로 저장 --%>
<%
	if(request.getMethod().equals("GET")) {
		response.sendRedirect("user_error.jsp");
		return;
	}

	String userid=request.getParameter("userid");
	String password=request.getParameter("password");
	
	UserinfoDTO userinfo=UserinfoModelOneDAO.getDAO().selectUserinfo(userid);
	if(userinfo==null || !userinfo.getPassword().equals(password)) { //아이디 또는 비밀번호 인증 실패
		session.setAttribute("message", "입력된 아이디가 잘못 되었거나 비밀번호가 맞지 않습니다.");
		response.sendRedirect("user_login.jsp");
		return;
	}
	
	//인증 성공 - 세션에 권한 관련 정보를 속성값으로 저장
	session.setAttribute("loginUserinfo", userinfo);
	
	response.sendRedirect("user_login.jsp");
%>