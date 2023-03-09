<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL Operator</h1>
	<hr>
	<%-- EL 연산자 : EL 표현식에서 사용하는 연산자 - 산술, 관계, 논리연산자 등 --%>
	<% request.setAttribute("first", 20); %>
	<% request.setAttribute("second", 10); %>
	<div>first = ${first }</div>
	<div>second = ${second }</div>
	<hr>
	<div>first * second = ${first * second }</div>
	<div>first / second = ${first / second }</div>
	<div>first div second = ${first div second }</div>
	<div>first % second = ${first % second }</div>
	<div>first mod second = ${first mod second }</div>
	<div>first + second = ${first + second }</div>
	<div>first - second = ${first - second }</div>
	<hr>
	<div>first &gt; second = ${first > second }</div>
	<div>first >= second = ${first >= second }</div>
	<div>first gt second = ${first gt second }</div>
	<div>first ge second = ${first ge second }</div>
	<div>first &lt; second = ${first < second }</div>
	<div>first <= second = ${first <= second }</div>
	<div>first lt second = ${first lt second }</div>
	<div>first le second = ${first le second }</div>
	<div>first == second = ${first == second }</div>
	<div>first eq second = ${first eq second }</div>
	<div>first != second = ${first != second }</div>
	<div>first ne second = ${first ne second }</div>
	<hr>
	<% request.setAttribute("num", 15); %>
	<div>num = ${num }</div>
	<hr>
	<div>first &gt; num && second &lt; num = ${first > num && second < num }</div>
	<div>first gt num and second lt num = ${first gt num and second lt num }</div>
	<div>first &lt; num || second &gt; num = ${first < num || second > num }</div>
	<div>first lt num or second gt num = ${first lt num or second gt num }</div>
	<hr>
	<%
		Object object=null;
		request.setAttribute("objest", object);
		
		String string="";
		request.setAttribute("string", string);
		
		String[] array={};
		request.setAttribute("array", array);
		
		List<String> list=new ArrayList<String>();
		request.setAttribute("list", list);
	%>
	<%-- empty 연산자 : EL 표현식으로 제공되는 속성값이 없거나,Java 객체 또는 Map 객체인 경우 저장값이 없으면
	[true]를 제공하고 속성값이 있거나, Java 객체 또는 Map 객체에 저장값이 있으면 [false]를 제공하는 연산자 --%>
	<div>object Empty = ${empty(object) }</div>
	<div>string Empty = ${empty(string) }</div>
	<div>array Empty = ${empty(array) }</div>
	<div>list Empty = ${empty(list) }</div>
</body>
</html>