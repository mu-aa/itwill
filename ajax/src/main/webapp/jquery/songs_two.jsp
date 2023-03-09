<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 현재 날짜와 시간 및 음원차트를 JSON 형식의 데이터로 전달하는 JSP 문서 --%>
<%
	String now=new SimpleDateFormat("yyyy년 MM월 dd일 HH시").format(new Date());
%>
{
	"now":"<%=now %>", "songs":[
		{"title":"Ditto", "singer":"NewJeans"}
		,{"title":"OMG", "singer":"NewJeans"}
		,{"title":"Hype boy", "singer":"NewJeans"}
		,{"title":"사건의 지평선", "singer":"윤하 (YOUNHA)"}
		,{"title":"ANTIFRAGILE", "singer":"LE SSERAFIM (르세라핌)"}
	]
}