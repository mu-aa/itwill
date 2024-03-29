<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#footer-table {
	display: flex;
	position: fixed;
	width: 95%; height: 60px;
	margin-left: 10%;
	bottom: 0; left: 0;
	background-color: white;
	flex-direction: row;
	box-shadow: -1px -1px 4px #AAAFB5;
	z-index: 1;
}
#footer-table td {
	width: 150px; height: 10px;
	border: none;
	font-size: 15px;
}

#footer-table button { 
	-webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
    background-color: white;
    border:none;
    border-style: none;
}
#add-selected-rows-btn { 
	border-radius: 2px;
    border: 1px solid #d9d9d9;
    background-color: #fff;
    font-size: 11px;
    font-weight: 900;
    line-height: 16px;
}
button:hover {
	cursor: pointer;
}
#expenses-total {color: #03C75A;}
#income-total {color: #3e7aff;}
</style>

</head>


<body>
<%-- <link rel=stylesheet href="<c:url value="/resources/css/footer.css"/>" type="text/css"> --%>
	<table id="footer-table">
		<tfoot>
			<tr>
				<!-- 선택항목삭제 버튼 -->
				<td style="text-align: right;"><button id="delete-selected-rows-btn" type="submit" onclick="remove();"><img src="resources/images/delete.png"></button></td>
				<td><button id="add-selected-rows-btn"><img src="resources/images/add.png"></button></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td style="text-align: right;">지출 합계
					<p id="expenses-total">
						<c:choose><c:when test="${not empty expensesSumAll }">${expensesSumAll }</c:when><c:otherwise>0</c:otherwise></c:choose>
					</p>
				</td>
				<td></td>
				<td style="text-align: right;">수입 합계
					<p id="income-total">
						<c:choose><c:when test="${not empty incomeSumAll }">${incomeSumAll }</c:when><c:otherwise>0</c:otherwise></c:choose>
					</p>
				</td>
				<td></td>
				<!-- 저장하기 버튼 -->
				<td><button type="submit" onclick="submit();"><img src="resources/images/save.png"></button></td>
			</tr>
		</tfoot>
	</table>
	

<script type="text/javascript">
//선택된 항목 DB삭제 - 지출
function remove() {
	var pathname = $(location).attr('pathname');
	if(pathname==="/acnt/") {
		var exNoList = new Array();
		var cnt = 0;
		var chkbox = $(".checkSelect");
	
		for(i=0;i<chkbox.length;i++) {
		    if (chkbox[i].checked == true){
		    	exNoList[cnt] = chkbox[i].value;
		        cnt++;
		    }
		}
		
	     //ajax 호출
	     $.ajax({
	         type : "post",
	         url : "${pageContext.request.contextPath}/remove",
	         traditional: true,
	         data : {"exNoList" : exNoList},
	         dataType : "json",
	         success : function(result){
	            	 console.log(result);
	         },
			error : function(xhr){
				console.log("AJAX_ERROR = "+xhr.status);
			}
		});
	    
	     setTimeout(function() {
	 		location.href="${pageContext.request.contextPath}/";
	     }, 500);
	} else if(pathname==="/acnt/income") { //선택된 항목 DB삭제 - 수입
		var inNoList = new Array();
		var cnt = 0;
		var chkbox = $(".checkSelect");
	
		for(i=0;i<chkbox.length;i++) {
		    if (chkbox[i].checked == true){
		    	inNoList[cnt] = chkbox[i].value;
		        cnt++;
		    }
		}
	
	     //ajax 호출
	     $.ajax({
	         type : "post",
	         url : "${pageContext.request.contextPath}/income_remove",
	         traditional: true,
	         data : {"inNoList" : inNoList},
	         dataType : "json",
	         success : function(result){
	            	 console.log(result);
	         },
			error : function(xhr){
				console.log("AJAX_ERROR = "+xhr.status);
			}
		});
	    
	   setTimeout(function() {
			location.href="${pageContext.request.contextPath}/income";
	    }, 500);
	}
}

//항목 추가 - 지출
const addExpensesBtn = document.querySelector('#add-selected-rows-btn');
const tableExpensesBody = document.querySelector('#expenses-table tbody');

addExpensesBtn.addEventListener('click', function() {
      const newExpensesRow = document.createElement('tr');

      newExpensesRow.innerHTML = `
      	<td class="checkbox"><input type="checkbox" class="checkSelect" value="${ex.exNo }"><input type="hidden" value="${ex.exNo }" class="ex"></td>
	<td class="date"><input type="date" name="exDate" value="${ex.exDate }"></td>
  		<td class="cash">
  			<input type="number" min="0" max="999999999" name="exCash" value="${ex.exCash }" id="exCash_${ex.exNo }">
  		</td>
	<td class="card">
		<input type="number" min="0" max="999999999" name="exCard" value="${ex.exCard }" id="exCard_${ex.exNo }">
	</td>
	<td class="acname">
		<select name="exAcname" class="selectbox" value="${ex.exAcname }">
		    <option value="1" class="lang-option" <c:if test="${ex.exAcname == '1'}">selected</c:if>>1</option>
		    <option value="2" class="lang-option" <c:if test="${ex.exAcname == '2'}">selected</c:if>>2</option>
		    <option value="미지정" class="lang-option" <c:if test="${ex.exAcname == '미지정' or empty ex.exAcname}">selected</c:if>>미지정</option>
		</select>
	</td>
	<td class="category">
		<select name="exCate" class="selectbox" id="exCate_${ex.exNo }">
		    <option value="식비" class="lang-option" <c:if test="${ex.exCate == '식비'}">selected</c:if>>식비</option>
		    <option value="주거/통신" class="lang-option" <c:if test="${ex.exCate == '주거/통신'}">selected</c:if>>주거/통신</option>
		    <option value="생활용품" class="lang-option" <c:if test="${ex.exCate == '생활용품'}">selected</c:if>>생활용품</option>
		    <option value="의복/미용" class="lang-option" <c:if test="${ex.exCate == '의복/미용'}">selected</c:if>>의복/미용</option>
		    <option value="건강/문화" class="lang-option" <c:if test="${ex.exCate == '건강/문화'}">selected</c:if>>건강/문화</option>
		    <option value="교육/육아" class="lang-option" <c:if test="${ex.exCate == '교육/육아'}">selected</c:if>>교육/육아</option>
		    <option value="교통/차량" class="lang-option" <c:if test="${ex.exCate == '교통/차량'}">selected</c:if>>교통/차량</option>
		    <option value="경조사/회비" class="lang-option" <c:if test="${ex.exCate == '경조사/회비'}">selected</c:if>>경조사/회비</option>
		    <option value="세금/이자" class="lang-option" <c:if test="${ex.exCate == '세금/이자'}">selected</c:if>>세금/이자</option>
		    <option value="용돈/기타" class="lang-option" <c:if test="${ex.exCate == '용돈/기타'}">selected</c:if>>용돈/기타</option>
		    <option value="미분류" class="lang-option" <c:if test="${empty ex.exCate or ex.exCate == '미분류'}">selected</c:if>>미분류</option>
		</select>
	</td>
	<td class="memo"><input type="text" name="exMemo" value="${ex.exMemo }"></td>
  `   ;

      tableExpensesBody.appendChild(newExpensesRow);
  });
		
//항목 추가 - 수입
const addIncomeBtn = document.querySelector('#add-selected-rows-btn');
const tableIncomeBody = document.querySelector('#income-table tbody');

addIncomeBtn.addEventListener('click', function() {
      const newIncomeRow = document.createElement('tr');

      newIncomeRow.innerHTML = `
      	<td class="checkbox"><input type="checkbox" class="checkSelect" value="${in.inNo }"><input type="hidden" value="${in.inNo }" class="in"></td>
	<td class="date"><input type="date" name="inDate" value="${in.inDate }"></td>
  		<td class="amount">
		<input type="number" min="0" max="999999999" name="inAmount" value="${in.inAmount }" id="inAmount_${in.inNo }">
	</td>
	<td class="acname">
		<select name="inAcname" class="selectbox" value="${in.inAcname }">
		    <option value="1" class="lang-option" <c:if test="${in.inAcname == '1'}">selected</c:if>>1</option>
		    <option value="2" class="lang-option" <c:if test="${in.inAcname == '2'}">selected</c:if>>2</option>
		    <option value="미지정" class="lang-option" <c:if test="${in.inAcname == '미지정' or empty in.inAcname}">selected</c:if>>미지정</option>
		</select>
	</td>
	<td class="category">
		<select name="inCate" class="selectbox" id="inCate_${in.inNo }">
			<option value="식비" class="lang-option" <c:if test="${in.inCate == '식비'}">selected</c:if>>식비</option>
			<option value="주거/통신" class="lang-option" <c:if test="${in.inCate == '주거/통신'}">selected</c:if>>주거/통신</option>
			<option value="생활용품" class="lang-option" <c:if test="${in.inCate == '생활용품'}">selected</c:if>>생활용품</option>
			<option value="의복/미용" class="lang-option" <c:if test="${in.inCate == '의복/미용'}">selected</c:if>>의복/미용</option>
			<option value="건강/문화" class="lang-option" <c:if test="${in.inCate == '건강/문화'}">selected</c:if>>건강/문화</option>
			<option value="교육/육아" class="lang-option" <c:if test="${in.inCate == '교육/육아'}">selected</c:if>>교육/육아</option>
			<option value="교통/차량" class="lang-option" <c:if test="${in.inCate == '교통/차량'}">selected</c:if>>교통/차량</option>
			<option value="경조사/회비" class="lang-option" <c:if test="${in.inCate == '경조사/회비'}">selected</c:if>>경조사/회비</option>
			<option value="세금/이자" class="lang-option" <c:if test="${in.inCate == '세금/이자'}">selected</c:if>>세금/이자</option>
			<option value="용돈/기타" class="lang-option" <c:if test="${in.inCate == '용돈/기타'}">selected</c:if>>용돈/기타</option>
			<option value="미분류" class="lang-option" <c:if test="${in.inCate == '미분류' or empty in.inCate}">selected</c:if>>미분류</option>
		</select>
	</td>
	<td class="memo"><input type="text" name="inMemo" value="${in.inMemo }"></td>
  `   ;

      tableIncomeBody.appendChild(newIncomeRow);
  });
</script>


</body>
</html>