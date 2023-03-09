<%@page import="xyz.itwill.dto.StudentDTO"%>
<%@page import="java.util.List"%>
<%@page import="xyz.itwill.dao.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- STUDENT 테이블에 저장된 모든 학생정보를 검색하여 클라이언트에게 전달하는 JSP 문서 --%>
<%-- => [학생추가]를 클릭한 경우 학생정보 입력페이지(insertFormStudent.jsp)로 이동 --%>
<%-- => 출력된 학생정보의 [삭제]를 클릭한 경우 학생정보 삭제페이지(deleteStudent.jsp)로 이동 - 학번 전달 --%>
<%-- => 출력된 학생정보의 [변경]를 클릭한 경우 학생정보 입력페이지(updateFormStudent.jsp)로 이동 - 학번 전달 --%>
<%
//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 반환하는 DAO 클래스의 메소드를 호출하여
	//검색결과를 반환받아 저장
	List<StudentDTO> studentList=StudentDAO.getDAO().selectStudentList();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP</title>
</head>
<body>
	<h1 align="center">학생목록</h1>
	<table align="center" cellspacing="0" cellpadding="1" width="800">
		<tr align="right">
			<td>
				<input type="button" value="학생추가" onclick="location.href='insertFormStudent.jsp';">
			</td>
		</tr>
	</table>
	<table align="center" border="1" cellspacing="0" cellpadding="1" width="800">
		<tr bgcolor="yellow">
			<th width="100">학생번호</th>
			<th width="100">이름</th>
			<th width="150">전화번호</th>
			<th width="250">주소</th>
			<th width="100">생년월일</th>
			<th width="50">삭제</th>
			<th width="50">변경</th>
		</tr>
		
		<%
				if(studentList.isEmpty()) {//List 객체에 저장된 요소가 없는 경우
				%>
		<tr align="center">
			<td colspan="7">검색된 학생정보가 없습니다.</td>
		</tr>		
		<%
				} else {//List 객체에 저장된 요소가 있는 경우
				%>
			<%-- List 객체에 저장된 요소를 차례대로 제공받아 응답하도록 반복 처리 --%>
			<%-- => 반복문에서는 요소(학생정보 - StudentDTO 객체)의 필드값을 반환받아 클라이언트에게 전달 --%>
			<%
			for(StudentDTO student:studentList) {
			%>
			<tr align="center">
				<td width="100"><%=student.getNo() %></td>				
				<td width="100"><%=student.getName() %></td>				
				<td width="150"><%=student.getPhone() %></td>				
				<td width="250"><%=student.getAddress() %></td>				
				<td width="100"><%=student.getBirthday().substring(0, 10) %></td>				
				<td width="50"><input type="button" value="삭제" onclick="location.href='deleteStudent.jsp?no=<%=student.getNo()%>';"></td>				
				<td width="50"><input type="button" value="변경" onclick="location.href='updateFormStudent.jsp?no=<%=student.getNo()%>';"></td>				
			</tr>	
			<% } %>
		<% } %>
	</table>
</body>
</html>