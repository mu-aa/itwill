<%@page import="xyz.itwill.dao.MyHewonDAO"%>
<%@page import="xyz.itwill.dto.MyHewon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MyHewon hewon=new MyHewon();
	hewon.setId("xxx");
	hewon.setName("홍경래");
	
	MyHewonDAO.getDAO().updateDynamicHewon(hewon);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYBATIS</title>
</head>
<body>
	<h1>회원정보변경</h1>
	<hr>
	<h3>회원정보를 성공적으로 변경했습니다.</h3>
</body>
</html>