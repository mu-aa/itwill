<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/calendar/popup" method="post">
<table>

<c:forEach var="expenses" items="${expensesList } }">
<c:set var="i" value="${i+1 }"/>
<tr>
<!-- 사용내역/현금/카드 -->

<td>
<input type="hidden" name="expensesList[${i}].exDate" value="${expenses.exDate}">
<input type="hidden" name="expensesList[${i}].exId" value="${expenses.exId}">
<input type="text" name="expensesList[${i}].exMemo" value="${expenses.exMemo }">
</td>
<td><input type="text" name="expensesList[${i}].exCash" value="${expenses.exCash }"></td>
<td><input type="text" name="expensesList[${i}].exCard" value="${expenses.exCard }"></td>

<!-- 사용 카드 -->
<!-- 
<td>
<select name="expensesList[${i}].exUseCard">
<c:if test="${expenses.Usercard != null }">
<option selected="selected" value="${expenses.Usercard }">${expenses.Usecard }</option>
</c:if>
<c:forEach var="card" items="${cardList }">
<option value="${card.cdName }">${card.cdName }</option>
</c:forEach>
</select>
</td>
 -->
<!-- 계좌 -->
<td>
<select name="expensesList[${i}].exAcname">
<c:if test="${expenses.exAcname != null }">
<option selected="selected" value="${expenses.exAcname }">${expenses.exAcname }</option>
</c:if>
<c:forEach var="account" items="${accountList }">
<option value="${account.acName }">${account.acName }</option>
</c:forEach>
</select>
</td>

<!-- 분류 -->
<td>
<select name="expensesList[${i}].exCate">
<option selected="selected" value="${expenses.exCate }">${expenses.exCate }</option>
<option value="식비">식비</option>
<option value="주거/통신">주거/통신</option>
<option value="생활용품"></option>
<option value="의복/미용"></option>
<option value="건강/문화">건강/문화</option>
<option value="교육/육아">교육/육아</option>
<option value="교통/차량">교통/차량</option>
<option value="경조사/회비">경조사/회비</option>
<option value="세금/이자">세금/이자</option>
<option value="용돈/기타">용돈/기타</option>
<option value="이체/대체">이체/대체</option>
<option value="카드대금">카드대금</option>
</select>
</td>
</tr>
</c:forEach>
<!-- 반복문 끝 -->
<tr>
<!-- 사용내역/현금/카드 -->
<td>
<input type="hidden" name="expensesList[${i+1}].exDate" value="${exDate}">
<input type="hidden" name="expensesList[${i+1}].exId" value="${exId}">
<input type="text" name="expensesList[${i+1}].exMemo" value="">
</td>
<td><input type="text" name="expensesList[${i+1}].exCash" value=""></td>
<td><input type="text" name="expensesList[${i+1}].exCard" value=""></td>

<!-- 사용 카드 -->
<!--  
<td>
<select name="expensesList[${i+1}].exUseCard">
<c:forEach var="card" items="${cardList }">
<option value="${card.cdName }">${card.cdName }</option>
</c:forEach>
</select>
</td>
 -->
<!-- 계좌 -->
<td>
<select name="expensesList[${i+1}].exAcname">
<c:forEach var="account" items="${accountList }">
<option value="${account.acName }">${account.acName }</option>
</c:forEach>
</select>
</td>

<!-- 분류 -->
<td>
<select name="expensesList[${i+1}].exCate">
<option value="식비">식비</option>
<option value="주거/통신">주거/통신</option>
<option value="생활용품"></option>
<option value="의복/미용"></option>
<option value="건강/문화">건강/문화</option>
<option value="교육/육아">교육/육아</option>
<option value="교통/차량">교통/차량</option>
<option value="경조사/회비">경조사/회비</option>
<option value="세금/이자">세금/이자</option>
<option value="용돈/기타">용돈/기타</option>
<option value="이체/대체">이체/대체</option>
<option value="카드대금">카드대금</option>
</select>
</td>
</tr>

</table>
</form>
</body>
</html>