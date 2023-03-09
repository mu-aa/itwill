<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//request.getProtocol() : 요청 웹프로그램에서 사용하는 Protocol을 반환하는 메소드
	String protocol=request.getProtocol();

	//요청에 대한 응답결과를 브라우저 캐싱 기능에 의해 사용되지 않도록 설정
	if(protocol.equals("HTTP/1.0")) {
		response.setDateHeader("Expires", -1); //캐싱 만료기간 설정
		response.setHeader("Pragma", "no-cache"); //캐싱 기능 비활성화
	} else if(protocol.equals("HTTP/1.1")) {
		response.setHeader("Cache-control", "no-cache"); //★(최신버전)캐싱 기능 비활성화
	}

	Date now=new Date();
	SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
	String displayTime=simpleDateFormat.format(now);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Expires" content="-1"> <%-- 위의 if(protocol.equals("...")과 같은 기능 --%>
<meta http-equiv="Pragma" content="no-Cache">
<meta http-equiv="Cache-control" content="no-cache">
<title>AJAX</title>
</head>
<body>
	<%=displayTime %>
</body>
</html>