<%@page import="xyz.itwill.dto.MyHewon"%>
<%@page import="xyz.itwill.dao.MyHewonDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MyHewonDAO.getDAO().insertHewon(new MyHewon("aaa", "홍길동", "010-1234-5678", "aaa@itwill.xyz", 1));
	MyHewonDAO.getDAO().insertHewon(new MyHewon("bbb", "임꺽정", "010-2134-5678", "bbb@itwill.xyz", 2));
	MyHewonDAO.getDAO().insertHewon(new MyHewon("ccc", "전우치", "010-1324-5678", "ccc@itwill.xyz", 3));
	MyHewonDAO.getDAO().insertHewon(new MyHewon("ddd", "일지매", "010-2314-5678", "ddd@itwill.xyz", 4));
	MyHewonDAO.getDAO().insertHewon(new MyHewon("eee", "장길산", "010-1432-5678", "eee@itwill.xyz", 3));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYBATIS</title>
</head>
<body>
	<h1>회원등록</h1>
	<hr>
	<h3>회원정보가 성공적으로 삽입되었습니다.</h3>
</body>
</html>