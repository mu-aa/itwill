<%@page import="xyz.itwill.dao.UserinfoModelOneDAO"%>
<%@page import="xyz.itwill.dto.UserinfoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 회원정보를 전달받아 USERINFO 테이블에 저장된 해당 회원정보를 변경하고 회원정보 출력페이지(user_view.jsp)로 
이동하는 URL 주소를 전달하는 JSP 문서 - 아이디 전달 --%>
<%
	if(request.getMethod().equals("GET")) {
		response.sendRedirect("user_error.jsp");
		return;
	}

	request.setCharacterEncoding("utf-8");

	String userid=request.getParameter("userid");
	String password=request.getParameter("password");
	String name=request.getParameter("name");
	String email=request.getParameter("email");
	int status=Integer.parseInt(request.getParameter("status"));
	
	UserinfoDTO userinfo=new UserinfoDTO();
	userinfo.setUserid(userid);
	if(password==null || password.equals("")) { //비밀번호 전달값이 없는 경우
		//기존 회원의 비밀번호로 필드값 변경
		userinfo.setPassword(UserinfoModelOneDAO.getDAO().selectUserinfo(userid).getPassword());
	} else { //비밀번호 전달값이 있는 경우 - 전달값으로 필드값 변경
		userinfo.setPassword(password);
	}
	userinfo.setName(name);
	userinfo.setEmail(email);
	userinfo.setStatus(status);
	
	UserinfoModelOneDAO.getDAO().updateUserinfo(userinfo);
	
	response.sendRedirect("user_view.jsp?userid="+userid);
%>