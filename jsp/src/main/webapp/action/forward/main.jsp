<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>메인페이지</h1>
	<hr>
	<%-- 
	<a href="company.jsp">회사연혁</a>&nbsp;&nbsp;
	<a href="product.jsp">제품소개</a>&nbsp;&nbsp;
	<a href="order.jsp">주문내역</a>&nbsp;&nbsp;
	<a href="review.jsp">사용후기</a>&nbsp;&nbsp;
	--%>
	
	<a href="controller.jsp?category=company">회사연혁</a>&nbsp;&nbsp;
	<a href="controller.jsp?category=product">제품소개</a>&nbsp;&nbsp;
	<a href="controller.jsp?category=order">주문내역</a>&nbsp;&nbsp;
	<a href="controller.jsp?category=review">사용후기</a>&nbsp;&nbsp;
</body>
</html>