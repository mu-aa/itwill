<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="simple" uri="http://www.itwill.xyz/mvc/custom" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Custom Tag - AnyAttribute And NoBody</h1>
	<hr>
	<%-- 커스텀 태그의 속성을 생략한 경우 태그 클래스의 생성자에서 설정한
	 기본값을 속성값으로 사용 --%>
	<%-- ㄴ 커스텀 태그의 속성이 필수로 설정(required : true)된 경우 속성을 생략하면 에러 발생 --%>
	<%-- <simple:helloMessage/> --%>
	
	<%-- 커스텀 태그의 속성이 필수로 설정된 경우 태그 자동 완성 사용 시 속성 또한 자동 완성 --%>
	<simple:helloMessage name="홍길동"/>
	
	<%-- 커스텀 태그의 속성을 사용하여 속성값을 설정한 경우 태그 클래스의 필드에 대한
	 Setter 메소드를 자동 호출하여 속성값을 전달받아 필드명 변경 --%>
	<%-- ㄴ 태그 클래스의 필드에 대한 Setter 메소드가 없는 경우 500 에러 발생 --%>
	<simple:helloMessage name="임꺽정"/>
</body>
</html>