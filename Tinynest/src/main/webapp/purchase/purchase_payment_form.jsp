<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/security/login_check.jspf" %>
<%
	if (request.getMethod().equals("GET")) {
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/error/error_400.jsp';");
		out.println("</script>");
		return;
	}

	request.setCharacterEncoding("utf-8");
	int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
	
	String items = request.getParameter("items");
	String name = request.getParameter("destinationName");
	String zipcode = request.getParameter("destinationZipcode");
	String address1 = request.getParameter("destinationAddress1");
	String address2 = request.getParameter("destinationAddress2");
	String phone1 = request.getParameter("destinationPhone1");
	String phone2 = request.getParameter("destinationPhone2");
	String phone3 = request.getParameter("destinationPhone3");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tinynest</title>
<style>
#paymentContainer {
	margin: 0 auto;
	width: 450px;
	height: 170px;
	padding: 50px 30px;
	background-color: #87CEEB;
}

#paymentForm {
	margin: 0 auto;
	width: 100%;
}

#paymentTable {
	width: 100%;
}

#paymentTable tr {
	height: 35px;
}

.cardInfo th {
	width: 120px;
	text-align: center;
}

.cardInfo:nth-child(2) td, .cardInfo:nth-child(3) td{
	padding-top: 12px;
}

#totalPriceDiv {
	margin: 0 auto;
	padding: 10px;
}

#totalPriceDiv ul {
	list-style-type: none;
}

#totalPriceDiv ul li {
	margin: 10px;
	font-size: 1.5em;
	font-weight: bold;
}

.errorDiv {
	position: relative;
	top: 3px;
	height: 8px;
}

.error {
	color: red;
	position: absolute;
	visibility: hidden;
	font-size: 0.8em;
}

</style>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
<div id="paymentContainer" align="center">
	<form id="paymentForm" action="<%=request.getContextPath()%>/purchase/purchase_action.jsp" method="post">
		<input type="hidden" name="items" value="<%=items%>">
		<input type="hidden" name="destinationName" value="<%=name%>">
		<input type="hidden" name="destinationZipcode" value="<%=zipcode%>">
		<input type="hidden" name="destinationAddress1" value="<%=address1%>">
		<input type="hidden" name="destinationAddress2" value="<%=address2%>">
		<input type="hidden" name="destinationPhone1" value="<%=phone1%>">
		<input type="hidden" name="destinationPhone2" value="<%=phone2%>">
		<input type="hidden" name="destinationPhone3" value="<%=phone3%>">
		<table id="paymentTable">
			<tr class="cardInfo">
				<th>?????? ??????</th>
				<td>
					<select>
						<option selected="selected">----------</option>
						<option value="KB">KB????????????</option>
						<option value="ShinHan">????????????</option>
						<option value="Samsung">????????????</option>
						<option value="Lotte">????????????</option>
					</select>
				</td>
			</tr>
			<tr class="cardInfo">
				<th>?????? ??????</th>
				<td>
					<input type="text" class="cardNumber" size="4" maxlength="4"> -
					<input type="text" class="cardNumber" size="4" maxlength="4"> -
					<input type="password" class="cardNumber" size="4" maxlength="4"> -
					<input type="password" class="cardNumber" size="4" maxlength="4">
					<div class="errorDiv">
						<div id="cardNumErr" class="error">??????????????? ??????????????????.</div>
						<div id="cardNumRegErr" class="error">??????????????? ????????? ?????? ???????????????.</div>
					</div>
				</td>
			</tr>
			<tr class="cardInfo">
				<th>?????? ????????????</th>
				<td>
					<input type="password" id="cardPassword" size="4" maxlength="4">
					<div class="errorDiv">
						<div id="cardPwErr" class="error">?????? ???????????? 4????????? ??????????????????.</div>
						<div id="cardPwRegErr" class="error">?????? ??????????????? ????????? ?????? ???????????????.</div>
					</div>
				</td>
			</tr>
			<tr class="cardInfo">
				<td colspan="2" align="right">
					<button id="paymentBtn" type="button">????????????</button>
				</td>
			</tr>
		</table>
	</form>
</div>
<div id="totalPriceDiv" align="right">
	<ul id="totalPrice">
		<li>????????????</li>
		<li><%=DecimalFormat.getCurrencyInstance().format(totalPrice)%></li>
	</ul>
</div>

<script type="text/javascript">
//[????????????] ?????? ?????? ??? ???????????? ??? ?????????????????? ?????? ?????? ??? submit
$("#paymentBtn").click(function() {
	let result = true;
	
	$(".error").css("visibility", "hidden");
	
	//???????????? ?????? ??????
	const cardNumReg = /^\d{4}$/;
	$(".cardNumber").each(function(i, element) {		
		if ($(element).val() == "") {
			$("#cardNumErr").css("visibility", "visible");
			$(element).focus();
			result = false;
			return false;
		} else if (!cardNumReg.test($(element).val())) {
			$("#cardNumRegErr").css("visibility", "visible");
			$(element).focus();
			result = false;
			return false;
		}
	});
	
	//?????? ???????????? ?????? ??????
	const cardPwReg = /^\d{4}$/;
	if ($("#cardPassword").val() == "") {
		$("#cardPwErr").css("visibility", "visible");
		result = false;
	} else if (!cardPwReg.test($("#cardPassword").val())) {
		$("#cardPwRegErr").css("visibility", "visible");
		result = false;
	}
	
	if (!confirm("?????????????????????????")) {
		result = false;
	}
	
	if (result) {
		$("<input type='hidden' name='pay' value='OK'>").prependTo($("#paymentForm"));
		$("#paymentForm").submit();
	}
	
	return result;
});
</script>
</body>
</html>