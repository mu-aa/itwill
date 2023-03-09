<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//hashMap 객체(Map 객체)를 생성하여 저장
	Map<String, String> carMap=new HashMap<String, String>();

	//HashMap 객체(Map 객체)에 Entry(Key와 Value를 하나로 묶어 표현한 요소)를 추가하여 저장
	carMap.put("modelName", "싼타페");
	carMap.put("carColor", "하얀색");
	
	//pageContext 내장객체의 속성값으로 HashMap 객체(Map 객체) 저장
	pageContext.setAttribute("carMap", carMap);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL(Expression Language)</h1>
	<hr>
	<h2>EL 미사용</h2>
	<%
		//pageContext 내장객체에 저장된 속성값을 객체로 반환받아 저장
		//@SuppressWarnings : 프로그램 소스에서 발생되는 경고를 제거하는 Annotation
		//ㄴ Value 속성값으로 경고의 종류를 설정해야함 - 다른 속성이 없는 경우 value 속성값만 설정 가능
		@SuppressWarnings(/* value= */"unchecked") //unchecked 경고 무시
		Map<String, String> car=(Map<String, String>)pageContext.getAttribute("carMap");
	%>
	<p>자동차 = <%=car %></p>
	<%-- Map 객체에 저장된 Entry에서 Key를 이용하여 Value를 반환받아 출력 --%>
	<p>자동차 모델명 = <%=car.get("modelName") %></p>
	<p>자동차 색상 = <%=car.get("carColor")  %></p>
	<hr>
	<h2>EL 사용</h2>
	<p>자동차 = ${carMap }</p>
	<%-- scope 속성값이 Map 객체인 경우 ${속성명.맵키 } 형식의 표현식을 사용하여 Map 객체에 저장된
	 Entry의 Map 값을 제공받아 출력 가능 --%>
	<%-- ㄴ EL 표현식에서 맵키를 사용하면 get() 메소드 자동 호출 --%>
	<p>자동차 모델명 = ${carMap.modelName }</p>
	<p>자동차 색상 = ${carMap.carColor }</p>
</body>
</html>