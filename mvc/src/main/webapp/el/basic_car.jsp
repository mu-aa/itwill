<%@page import="xyz.itwill.el.Car"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//pageContext 내장객체에 Car 객체를 속성값으로 저장
	pageContext.setAttribute("car", new Car("싼타페", "하얀색"));
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
		//pageContext 내장객체에 저장된 속성값을 Car 객체로 반환받아 저장
		//Car car=(Car)pageContext.getAttribute("car");
	
		//전달받은 속성명에 대한 속성값이 없는 경우 [null] 반환
		//ㄴ 참조변수에 [null]이 저장된 상태에서 메소드 호출 시 NullPointerException 발생
		Car car=(Car)pageContext.getAttribute("car");
	
		//객체의 필드값을 반환받아 저장
		//String modelName=car.getModelName();
		//String carColor=car.getCarColor();
	%>
	<p>자동차 = <%=car %></p>
	<p>자동차 모델명 = <%=car.getModelName() %></p>
	<p>자동차 색상 = <%=car.getCarColor() %></p>
	
	<h2>EL 사용</h2>
	<p>자동차 = ${car }</p>
	<%-- EL 표현식으로 제공받은 객체의 메소드 호출 가능 --%>
	<%-- <p>자동차 모델명 = ${car.getModelName() }</p> --%>
	<%-- 스코프 속성값이 객체인 경우 ${속성명.필드명 } 형식의 표현식을 사용하여
	객체의 필드값을 제공받아 출력 가능 - EL 표현식으로 필드명을 사용하면 Getter 메소드 자동 호출 --%>
	<%-- ㄴ Getter 메소드 작성규칙에 맞지 않게 선언된 경우 또는 Getter 메소드가 없는 경우 에러 발생 --%>
	<p>자동차 모델명 = ${car.modelName }</p>
	<p>자동차 색상 = ${car.carColor }</p>
	
	<%-- EL 표현식의 속성명으로 제공되는 속성값이 없는 경우 EL 미실행 - NullPointerException 미발생 --%>
	<p>자동차 모델명 = ${pageCar.modelName }</p>
</body>
</html>