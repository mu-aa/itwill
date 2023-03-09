<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- TilesView 관련 기능을 태그로 제공받기 위해 tag-tiles 태그 라이브러리를 JSP 문서에 포함 --%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
<style type="text/css">
#header {border: 1px solid red; height: 150px; margin: 10px; padding: 10px; text-align: center;}
#content {border: 2px solid green; min-height: 550px; margin: 10px; padding: 10px; text-align: center;}
</style>
</head>
<body>
	<div id="header">
		<tiles:insertAttribute name="header" />
	</div>
	<div id="content">
		<tiles:insertAttribute name="content" />
	</div>
</body>
</html>