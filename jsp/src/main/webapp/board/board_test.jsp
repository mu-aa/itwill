<%@page import="xyz.itwill.dao.BoardDAO"%>
<%@page import="xyz.itwill.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- BOARD 테이블에 게시글(새 글)을 500개 저장하는 JSP 문서 - 테스트 프로그램 --%>
<%
	BoardDTO board=new BoardDTO();
	for(int i=1;i<=500;i++) {
		int num=BoardDAO.getDAO().selectNextNum();
		board.setNum(num);
		board.setId("alswo92345");
		board.setSubject("test-"+i);
		board.setRef(num);
		board.setContent("게시글 테스트-"+i);
		board.setIp("192.168.13.31");
		board.setStatus(1);
		BoardDAO.getDAO().insertBoard(board);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>500개의 테스트 게시글이 삽입 되었습니다.</h1>
</body>
</html>