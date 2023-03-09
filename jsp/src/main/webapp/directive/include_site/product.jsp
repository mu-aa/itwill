<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<%--
div {
	margin: 5px;
	padding: 5px;
}

#header {
	height: 200px;
	border: 1px solid red;
}

#header h1 {
	text-align: center;
}

#menu {
	font-size: 1.5em;
	text-align: right;
}

#menu a, #menu a:visited {
	text-decoration: none;
	color: black;
}

#menu a:hover {
	color: orange;
}

#content {
	min-height: 500px;
	border: 1px solid green;
	text-align: center;
}

#footer {
	height: 150px;
	border: 1px solid blue;
	text-align: center;
	font-size: 1.2em;
}
--%>
<link href="style.css" type="text/css" rel="stylesheet">
</head>
<body>
	<%-- Header 영역 : 로고, 메뉴 등 출력하기 위한 영역 - 링크 --%>
	<%-- <div id="header">
		<h1><a href="index.jsp">쇼핑몰</a></h1>
		<div id="menu">
			<a href="company.jsp">회사소개</a>&nbsp;&nbsp;
			<a href="product.jsp">제품소개</a>&nbsp;&nbsp;
			<a href="review.jsp">사용후기</a>&nbsp;&nbsp;
			<a href="event.jsp">이벤트</a>&nbsp;&nbsp;
		</div>
	</div> --%>
	
	<%@include file="header.jspf"%>
	
	<%-- Content 영역 : 요청에 대한 처리결과를 출력하기 위한 영역 - 제품 정보 --%>
	<div id="content">
		<h2>제품소개 페이지</h2>
	</div>
	
	<%-- Footer 영역 : 저작권, 약관, 개인정보 보호정책 등을 출력하기 위한 영역 - 링크 --%>
	<%-- <div id="footer">
		<p>Copyright ⓒitwill Corp. All rights reserved.</p>
	</div> --%>
	
	<%@include file="footer.jspf" %>
</body>
</html>