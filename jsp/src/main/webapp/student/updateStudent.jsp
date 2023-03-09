<%@page import="xyz.itwill.dao.StudentDAO"%>
<%@page import="xyz.itwill.dto.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 입력페이지(updateFormStudent.jsp)에서 전달된 학생정보를 반환받아 STUDENT 테이블에 저장된 학생정보를
변경하고 학생목록 출력페이지(displayStudent.jsp)로 이동하기 위한 URL 주소를 전달하는 JSP 문서 --%>        
<%
        //비정상적인 요청에 대한 응답처리
        	if(request.getMethod().equals("GET")) {
        		response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        		return;
        	}

        	//POST 방식으로 요청하여 전달된 값에 대한 캐릭터셋 변경
        	request.setCharacterEncoding("utf-8");
        	
        	//전달값을 반환받아 저장
        	int no=Integer.parseInt(request.getParameter("no"));
        	String name=request.getParameter("name");
        	String phone=request.getParameter("phone");
        	String address=request.getParameter("address");
        	String birthday=request.getParameter("birthday");
        	
        	//StudentDTO 객체를 생성하고 전달값을 이용하여 필드값 변경
        	StudentDTO student=new StudentDTO();
        	student.setNo(no);
        	student.setName(name);
        	student.setPhone(phone);
        	student.setAddress(address);
        	student.setBirthday(birthday);
        	
        	//학생정보를 전달받아 STUDENT 테이블에 저장된 해당 학생정보를 변경하는 DAO 클래스의 메소드 호출
        	StudentDAO.getDAO().updateStudent(student);
        	
        	//클라이언트에게 URL 주소 전달
        	response.sendRedirect("displayStudent.jsp");
        %>