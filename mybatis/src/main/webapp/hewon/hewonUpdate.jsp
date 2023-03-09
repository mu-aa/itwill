<%@page import="xyz.itwill.dao.MyHewonDAO"%>
<%@page import="xyz.itwill.dto.MyHewon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//MYHEWON 테이블에서 아이디가 [xxx]인 회원의 이름을 [로빈훗]으로 변경
	//기본생성자에 의해 생성된 객체의 필드에는 기본값(false/0/null) 저장
	/* MyHewon hewon=new MyHewon();
	hewon.setId("xxx");
	hewon.setName("로빈훗"); */
	
	//DAO 클래스 메소드의 매개변수에는 아이디와 이름만 저장된 회원정보 전달
	//ㄴ 아이디와 이름을 제외한 필드에는 기본값 저장
	//문제점) MYHEWON 테이블에 저장된 회원정보가 비정상적으로 변경 처리
	//MyHewonDAO.getDAO().updateHewon(hewon);
	
	//해결법) DAO 클래스 메소드의 매개변수에 모든 회원정보르 저장하여 전달
	//ㄴ 회원정보를 변경하지 않는 컬럼에는 기존 회원정보가 저장되도록 설정
	MyHewon hewon=new MyHewon();
	hewon.setId("xxx");
	hewon.setName("로빈훗");
	hewon.setPhone("010-5467-3487");
	hewon.setEmail("xxx@itwill.xyz");
	hewon.setState(4);
	
	MyHewonDAO.getDAO().updateHewon(hewon);
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