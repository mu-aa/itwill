<%@page import="xyz.itwill.dto.StudentDTO"%>
<%@page import="xyz.itwill.dao.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 입력페이지(insertFormStudent.jsp)에서 전달된 학생정보를 반환받아 STUDENT 테이블에 삽입하고
학생목록 출력페이지(displayStudent.jsp)로 이동하기 위한 URL 주소를 전달하는 JSP 문서 --%>    
<%
    //비정상적인 요청에 대한 응답처리
    	if(request.getMethod().equals("GET")) {
    		session.setAttribute("message", "비정상적인 방법으로 페이지를 요청 하였습니다.");
    		response.sendRedirect("insertFormStudent.jsp");//입력페이지의 URL 주소 전달
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
    	
    	//StudentDTO 객체를 생성하고 전달값으로 객체의 필드값 변경 - DAO 클래스의 메소드 호출에 사용
    	StudentDTO student=new StudentDTO();
    	student.setNo(no);
    	student.setName(name);
    	student.setPhone(phone);
    	student.setAddress(address);
    	student.setBirthday(birthday);
    	
    	//사용자로부터 입력되어 전달된 학생번호가 STUDENT 테이블에 저장된 기존 학생정보의 학생번호와
    	//중복될 경우 입력페이지(insertFormStudent.jsp)로 이동하기 위한 URL 주소 전달
    	//학생전달을 전달받아 STUDENT 테이블에 저장된 해당 학생번호의 학생정보를 검색하여 반환하는
    	//DAO 클래스의 메소드 호출 
    	// => null 반환 : 학생정보 미검색 - 전달된 학생번호 미중복
    	// => StudentDTO 객체 반환 : 학생정보 검색 - 전달된 학생번호 중복
    	if(StudentDAO.getDAO().selectStudent(no)!=null) {//검색된 학생정보가 있는 경우
    		session.setAttribute("message", "이미 사용중인 학생번호를 입력 하였습니다. 다시 입력해 주세요."); //메세지 전달
    		session.setAttribute("student", student); //사용자 입력값 전달
    		response.sendRedirect("insertFormStudent.jsp");
    		return;
    	}
    	
    	//학생정보를 전달받아 STUDENT 테이블에 삽입하는 DAO 클래스의 메소드 호출
    	StudentDAO.getDAO().insertStudent(student);
    	
    	//학생목록 출력페이지의 URL 주소를 전달하여 응답 처리
    	response.sendRedirect("displayStudent.jsp");
    %>