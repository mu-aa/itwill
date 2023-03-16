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
<style type="text/css">
.calendarTable{
	 margin-left:auto; 
    margin-right:auto;
}
.number {
	text-align: right;
}

.table-class {
  border-collapse: collapse;
  width: 70%;
  font-size: 14px;
  font-family: Arial, sans-serif;
   margin-left:auto; 
    margin-right:auto;
}

.table-class th,
.table-class td {
  padding: 8px;
  text-align: center;
  border: 1px solid #ddd;
}

.table-class th {
  background-color: #f2f2f2;
  color: #333;
}

</style>
</head>
<body>

<form action="${pageContext.request.contextPath }/calendar/popup?date=${exDate}" method="post">
<table class="table-class">
<c:if test="${expensesList != null }">
<tr>
<th>
<button type="button" onclick="location.href='${pageContext.request.contextPath }/calendar/popup?date=${exDate}&select=income'">수입</button>
/
<button type="button" onclick="location.href='${pageContext.request.contextPath }/calendar/popup?date=${exDate}&select=expenses'">지출</button>
</th>
<th colspan="4">
<input type="hidden" name="exDate" value="${exDate}">
${exDate } [${exId }]님의 지출내역
</th>
</tr>

<tr>
<th>지출내역</th>
<th>현금</th>
<th>카드</th>
<th>출금통장</th>
<th>분류</th>
</tr>
<c:set var="i" value="0"/>
<c:forEach var="expenses" items="${expensesList }">
<tr>
<!-- 사용내역/현금/카드 -->
<td>
<input type="hidden" name="expensesList[${i}].exDate" value="${expenses.exDate}">
<input type="hidden" name="expensesList[${i}].exId" value="${expenses.exId}">
<input type="hidden" name="expensesList[${i}].exNo" value="${expenses.exNo}">
<input type="text" name="expensesList[${i}].exMemo" value="${expenses.exMemo }">
</td>
<td><input class="number" type="text" name="expensesList[${i}].exCash" value="${expenses.exCash }"></td>
<td><input class="number" type="text" name="expensesList[${i}].exCard" value="${expenses.exCard }"></td>

<!-- 사용 카드 -->
<%--  
<td>
<select name="expensesList[${i}].exUseCard">
<c:if test="${expenses.Usercard != null }">
<option selected="selected" value="${expenses.Usercard }">${expenses.Usecard }</option>
</c:if>
<c:forEach var="card" items="${cardList }">
<option value="${card.cdName }">
${card.cdName }/${card.cdCompany}
</option>
</c:forEach>
</select> 
</td>
--%>
<!-- 계좌 -->
<td>
<select name="expensesList[${i}].exAcname">
<c:forEach var="account" items="${accountList }">
<option value="${account.acName }" <c:if test="${expenses.exAcname == account.acName }">selected="selected"</c:if> >${account.acName }/${account.acBank}</option>
</c:forEach>
</select>
</td>





<!-- 분류 -->
<td>
<select name="expensesList[${i}].exCate">
<option value="식비"  <c:if test="${expenses.exCate == '식비'}">selected</c:if>>식비</option>
<option value="주거/통신"  <c:if test="${expenses.exCate == '주거/통신'}">selected</c:if>>주거/통신</option>
<option value="생활용품"  <c:if test="${expenses.exCate == '생활용품'}">selected</c:if>>생활용품</option>
<option value="의복/미용"  <c:if test="${expenses.exCate == '의복/미용'}">selected</c:if>>의복/미용</option>
<option value="건강/문화"  <c:if test="${expenses.exCate == '건강/문화'}">selected</c:if>>건강/문화</option>
<option value="교육/육아"  <c:if test="${expenses.exCate == '교육/육아'}">selected</c:if>>교육/육아</option>
<option value="교통/차량"  <c:if test="${expenses.exCate == '교통/차량'}">selected</c:if>>교통/차량</option>
<option value="경조사/회비" <c:if test="${expenses.exCate == '경조사/회비'}">selected</c:if>>경조사/회비</option>
<option value="세금/이자"  <c:if test="${expenses.exCate == '세금/이자'}">selected</c:if>>세금/이자</option>
<option value="용돈/기타" <c:if test="${expenses.exCate == '용돈/기타'}">selected</c:if>>용돈/기타</option>
<option value="미분류"  <c:if test="${expenses.exCate == '미분류'}">selected</c:if>>미분류</option>
</select>
</td>
</tr>
<c:set var="i" value="${i+1 }"/>
</c:forEach>
<!-- 반복문 끝 -->
<tr>
<!-- 사용내역/현금/카드 -->
<td>
<input type="hidden" name="expensesList[${i}].exDate" value="${exDate}">
<input type="hidden" name="expensesList[${i}].exId" value="${exId}">
<input type="hidden" name="expensesList[${i}].exNo" value="0">
<input type="text" name="expensesList[${i}].exMemo" value="">
</td>
<td><input class="number" type="text" name="expensesList[${i}].exCash" value="0"></td>
<td><input class="number" type="text" name="expensesList[${i}].exCard" value="0"></td>

<!-- 사용 카드 -->
<%--   
<td>
<select name="expensesList[${i+1}].exUseCard">
<c:forEach var="card" items="${cardList }">
<option value="${card.cdName }">${card.cdName }</option>
</c:forEach>
</select>
</td>
--%>
<!-- 계좌 -->
<td>
<select name="expensesList[${i}].exAcname">
<option></option>
<c:forEach var="account" items="${accountList }">
<option value="${account.acName }">${account.acName }/${account.acBank}</option>
</c:forEach>
</select>
</td>

<!-- 분류 -->
<td>
<select name="expensesList[${i}].exCate">
<option selected="selected" value="미분류"></option>
<option value="식비">식비</option>
<option value="주거/통신">주거/통신</option>
<option value="생활용품">생활용품</option>
<option value="의복/미용">의복/미용</option>
<option value="건강/문화">건강/문화</option>
<option value="교육/육아">교육/육아</option>
<option value="교통/차량">교통/차량</option>
<option value="경조사/회비">경조사/회비</option>
<option value="세금/이자">세금/이자</option>
<option value="용돈/기타">용돈/기타</option>
<option value="이체/대체">이체/대체</option>
<option value="미분류">미분류</option>
</select>
</td>
</tr>
<!-- 합산 -->
<tr>
<th></th>
<th>현금 합계</th>
<th>카드 합계</th>
<th></th>
<th></th>
</tr>
<tr>
<c:forEach var="j" begin="0" end="${i }" step="1">
<c:set var="totCash" value="${totCash + expensesList[j].exCash }" />
<c:set var="totCard" value="${totCard + expensesList[j].exCard }" />
</c:forEach>
<td></td>
<td><input readonly="readonly" class="number" type="text" value="${totCash }"></td>
<td><input readonly="readonly" class="number" type="text" value="${totCard }"></td>
<td></td>
<td><button type="submit">저장</button></td>
</tr>

</c:if>


<!-- income -->
<c:if test="${incomeList != null }">
<tr>
<th>
<button type="button" onclick="location.href='${pageContext.request.contextPath }/calendar/popup?date=${exDate}&select=income'">수입</button>
/
<button type="button" onclick="location.href='${pageContext.request.contextPath }/calendar/popup?date=${exDate}&select=expenses'">지출</button>
</th>
<th colspan="4">
<input type="hidden" name="exDate" value="${exDate}">
${exDate } [${exId }]님의 수입내역
</th>
</tr>

<tr>
<th>수입내역</th>
<th>금액</th>
<th>입금통장</th>
<th>분류</th>
</tr>
<c:set var="i" value="0"/>
<c:forEach var="income" items="${incomeList }">
<tr>
<!-- 수입내역/현금/카드 -->

<td>
<input type="hidden" name="incomeList[${i}].inDate" value="${income.inDate}">
<input type="hidden" name="incomeList[${i}].inId" value="${income.inId}">
<input type="hidden" name="incomeList[${i}].inNo" value="${income.inNo}">
<input type="text" name="incomeList[${i}].inMemo" value="${income.inMemo }">
</td>
<td><input class="number" type="text" name="incomeList[${i}].inAmount" value="${income.inAmount }"></td>


<!-- 사용 카드 -->
<%--  
<td>
<select name="expensesList[${i}].exUseCard">
<c:if test="${expenses.Usercard != null }">
<option selected="selected" value="${expenses.Usercard }">${expenses.Usecard }</option>
</c:if>
<c:forEach var="card" items="${cardList }">
<option value="${card.cdName }">
${card.cdName }/${card.cdCompany}
</option>
</c:forEach>
</select>
</td>
--%>
<!-- 계좌 -->
<td>
<select name="incomeList[${i}].inAcname">

<c:forEach var="account" items="${accountList }">
<option value="${account.acName }" <c:if test="${income.inAcname == account.acName }">selected="selected"</c:if>>${account.acName }/${account.acBank}</option>
</c:forEach>
</select>
</td>

<!-- 분류 -->
<td>
<select name="incomeList[${i}].inCate">
<option value="주수입" <c:if test="${income.inCate == '주수입' }">selected="selected"</c:if> >주수입</option>
<option value="부수입" <c:if test="${income.inCate == '부수입' }">selected="selected"</c:if> >부수입</option>
<option value="전월이월" <c:if test="${income.inCate == '전월이월' }">selected="selected"</c:if> >전월이월</option>
<option value="저축/보험" <c:if test="${income.inCate == '저축/보험' }">selected="selected"</c:if> >저축/보험</option>
<option value="미분류" <c:if test="${income.inCate == '미분류' }">selected="selected"</c:if> >미분류</option>
</select>
</td>
</tr>
<c:set var="i" value="${i+1 }"/>
</c:forEach>
<!-- 반복문 끝 -->
<tr>
<!-- 사용내역/현금/카드 -->
<td>
<input type="hidden" name="incomeList[${i}].inDate" value="${exDate}">
<input type="hidden" name="incomeList[${i}].inId" value="${exId }">
<input type="hidden" name="incomeList[${i}].inNo" value="0">
<input type="text" name="incomeList[${i}].inMemo" value="">
</td>
<td><input class="number" type="text" name="incomeList[${i}].inAmount" value="0"></td>


<!-- 사용 카드 -->
<%--  
<td>
<select name="expensesList[${i}].exUseCard">
<c:if test="${expenses.Usercard != null }">
<option selected="selected" value="${expenses.Usercard }">${expenses.Usecard }</option>
</c:if>
<c:forEach var="card" items="${cardList }">
<option value="${card.cdName }">
${card.cdName }/${card.cdCompany}
</option>
</c:forEach>
</select>
</td>
--%>
<!-- 계좌 -->
<td>
<select name="incomeList[${i}].inAcname">
<option></option>
<c:forEach var="account" items="${accountList }">
<option value="${account.acName }">${account.acName }/${account.acBank}</option>
</c:forEach>
</select>
</td>

<!-- 분류 -->
<td>
<select name="incomeList[${i}].inCate">
<option selected="selected" value="미분류"></option>
<option value="주수입">주수입</option>
<option value="부수입">부수입</option>
<option value="전월이월">전월이월</option>
<option value="저축/보험">저축/보험</option>
<option value="미분류">미분류</option>
</select>
</td>
</tr>
<!-- 합산 -->
<tr>
<th></th>
<th>수입 합계</th>
<th></th>
<th></th>
</tr>
<tr>
<c:forEach var="j" begin="0" end="${i }" step="1">
<c:set var="tot" value="${tot + incomeList[j].inAmount }" />
</c:forEach>
<td></td>
<td><input readonly="readonly" class="number" type="text" value="${tot }"></td>
<td></td>
<td><button type="submit">저장</button></td>
</tr>

</c:if>

</table>

</form>
</body>
</html>