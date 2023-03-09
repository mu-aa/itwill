<%@page import="xyz.itwill.dto.UserinfoDTO"%>
<%@page import="xyz.itwill.dao.UserinfoModelOneDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 아이디를 전달받아 USERINFO 테이블에 저장된 해당 아이디의 회원정보를 검색하여 입력태그의 초기값으로 
설정하고 변경할 회원정보를 사용자로부터 입력받기 위한 JSP 문서 - 관리자만 요청 가능한 페이지 --%>
<%-- ㄴ [수정] 태그를 클릭한 경우 회원정보 변경페이지(user_modify_action.jsp)로 이동 - 입력값 전달 --%>
<%-- ㄴ [목록] 태그를 클릭한 경우 회원목록 출력페이지(user_list.jsp)로 이동 --%>
<%
	UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
	if(loginUserinfo==null || loginUserinfo.getStatus()!=9){
		response.sendRedirect("user_error.jsp");
		return;
	}

	if(request.getParameter("userid")==null) {
		response.sendRedirect("user_error.jsp");
		return;
	}
	
	String userid=request.getParameter("userid");
	
	UserinfoModelOneDAO.getDAO().deleteUserinfo(userid);
	
	//로그인 사용자의 아이디와 삭제된 사용자의 아이디가 같은 경우
	if(loginUserinfo.getUserid().equals(userid)) { //관리자가 자신의 계정을 삭제한 경우
		response.sendRedirect("user_logout_action.jsp");
	} else {
		response.sendRedirect("user_list.jsp");
	}
%>