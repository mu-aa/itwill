<%@page import="xyz.itwill.dao.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 학생목록 출력페이지(displayStudent.jsp)에서 전달받은 학생번호를 반환받아 STUDENT 테이블에 저장된 해당 학생번호의 학생정보를 삭제하고
학생목록 출력페이지로 이동하는 URL 주소를 전달하는 JSP 문서 - 처리페이지 --%>
<%
	//비정상적인 요청에 대한 응답 처리
	if(request.getParameter("no")==null) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}

	//전달값을 정수값으로 반환받아 저장
	int no=Integer.parseInt(request.getParameter("no"));
	
	//학생번호를 전달받아 STUDENT 테이블에 저장된 해당 학생번호의 학생정보를 삭제하는 DAO 클래스 메소드 호출
	int rows=StudentDAO.getDAO().deleteStudent(no);
	
	if(rows>0){ //삭제된 학생정보가 있는 경우 - 정상적인 요청
		//클라이언트에게 URL 주소 전달
		response.sendRedirect("displayStudent.jsp");
	} else { //삭제된 학생정보가 없는 경우 - 비정상적인 요청
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	}
%>