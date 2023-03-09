<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 사용자로부터 제품정보를 입력받기 위한 JSP 문서 --%>
<%-- ㄴ [제품등록]을 클릭한 경우 제품정보 삽입페이지(product_add_action.jsp)로 이동 - 입력값 전달 --%>
<%-- ㄴ 관리자만 요청 가능한 JSP 문서 --%>
<%@include file="/security/admin_check.jspf" %>
<style type="text/css">
#product {
	width: 800px;
	margin: 0 auto;
}

table {
	margin: 0 auto;
}

td {
	text-align: left;
}
</style>

<div id="product">
	<h2>제품등록</h2>
	
	<%-- 사용자로부터 파일을 입력받아 요청 페이지로 전달하기 위해서는 **반드시 form 태그의 enctype 속성을
	[multipart/form-data]로 설정, method는 post** --%>
	<form action="<%=request.getContextPath()%>/index.jsp?workgroup=admin&work=product_add_action"
		method="post" enctype="multipart/form-data" id="productForm">
		<table>
			<tr>
				<td>카테고리</td>
				<td>
					<select name="category">
						<option value="CPU">중앙처리장치(CPU)</option>
						<option value="MAINBOARD">메인보드(MAINBOARD)</option>
						<option value="MEMORY">메모리(MEMORY)</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>제품명</td>	
				<td>
					<input type="text" name="name" id="name">
				</td>
			</tr>
			<tr>
				<td>대표이미지</td>	
				<td>
					<input type="file" name="imageMain" id="imageMain">
				</td>
			</tr>
			<tr>
				<td>상세이미지</td>	
				<td>
					<input type="file" name="imageDetail" id="imageDetail">
				</td>
			</tr>
			<tr>
				<td>제품수량</td>	
				<td>
					<input type="text" name="qty" id="qty">
				</td>
			</tr>
			<tr>
				<td>제품가격</td>	
				<td>
					<input type="text" name="price" id="price">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit">제품등록</button>
				</td>
			</tr>
		</table>
	</form>
	
	<div id="message" style="color: red;"></div>
</div>

<script type="text/javascript">
$("#productForm").submit(function(){
	if($("#name").val()=="") {
		$("#message").text("제품명을 입력해주세요.");
		$("#name").focus();
		return false;
	}
$("#imageMain").submit(function(){
	if($("#name").val()=="") {
		$("#message").text("대표이미지를 입력해주세요.");
		$("#name").focus();
		return false;
	}
$("#imageDetail").submit(function(){
	if($("#name").val()=="") {
		$("#message").text("상세이미지를 입력해주세요.");
		$("#name").focus();
		return false;
	}
$("#qty").submit(function(){
	if($("#name").val()=="") {
		$("#message").text("제품수량을 입력해주세요.");
		$("#name").focus();
		return false;
	}
$("#price").submit(function(){
	if($("#name").val()=="") {
		$("#message").text("제품가격을 입력해주세요.");
		$("#name").focus();
		return false;
	}
});
</script>