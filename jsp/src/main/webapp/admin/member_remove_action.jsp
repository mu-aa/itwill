<%@page import="xyz.itwill.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 아이디 목록을 전달받아 MEMBER 테이블에 저장된 해당 아이디의 회원정보를 삭제하고
회원정보 관리페이지(member_manager.jsp)로 이동하는 URL 주소를 클라이언트에게 전달하는 JSP 문서 --%>
<%-- ㄴ 관리자만 요청 가능한 JSP 문서 --%>
<%@include file="/security/admin_check.jspf" %>
<%
	//비정상적인 요청에 대한 응답 처리
	if(request.getMethod().equals("GET")) {
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/index.jsp?workgroup=error&work=error_400';");
		out.println("</script>");
		return;
	}

	//체크박스로 선택되어 전달된 모든 회원의 ID를 반환받아 저장
	//ㄴ 동일한 이름으로 다수의 값이 전달되므로 request.getParameterValues() 메소드 호출
	String[] checkId=request.getParameterValues("checkId");
	
	//배열의 요소를 차례대로 제공받아 반복 처리
	for(String id:checkId) {
		//아이디를 전달받아 MEMBER 테이블에 저장된 해당 아이디의 회원정보를 삭제하는 DAO 클래스
		MemberDAO.getDAO().deleteMember(id);
	}
	
	//페이지 이동
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/index.jsp?workgroup=admin&work=member_manager';");
		out.println("</script>");
%>