<%@page import="xyz.itwill.dao.ProductDAO"%>
<%@page import="xyz.itwill.dto.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 제품번호를 전달받아 PRODUCT 테이블에 저장된 해당 제품번호의 제품정보를 검색하여
입력태그의 초기값으로 설정하고 사용자로부터 변경값을 입력받기 위한 JSP 문서 --%>
<%-- => 관리자만 요청 가능한 JSP 문서 --%>
<%-- ㄴ [제품변경]을 클릭한 경우 제품정보 변경페이지(product_modify_action.jsp)로 이동 - 입력값 전달 --%>
<%@include file="/security/admin_check.jspf" %>
<%
	//비정상적인 요청에 대한 응답 처리
	if(request.getParameter("num")==null) {
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/index.jsp?workgroup=error&work=error_400';");
		out.println("</script>");
		return;
	}

	//전달값을 반환받아 저장
	int num=Integer.parseInt(request.getParameter("num"));
	
	//제품번호를 전달받아 PRODUCT 테이블에 저장된 해당 제품번호의 제품정보를 검색하여
	//반환하는 DAO 클래스 메소드 호출
	ProductDTO product=ProductDAO.getDAO().selectProduct(num);
	
	//검색된 제품정보가 없는 경우 - 비정상적인 요청에 대한 응답 처리
	if(product==null) {
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/index.jsp?workgroup=error&work=error_400';");
		out.println("</script>");
		return;
	}
%>
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
	<h2>제품변경</h2>
	
	<%-- 사용자로부터 파일을 입력받아 요청 페이지로 전달하기 위해서는 **반드시 form 태그의 enctype 속성을
	[multipart/form-data]로 설정, method는 post** --%>
	<form action="<%=request.getContextPath()%>/index.jsp?workgroup=admin&work=product_modify_action"
		method="post" enctype="multipart/form-data" id="productForm">
		<%-- 변경할 제품정보를 구분하기 위한 식별자로 제품번호를 전달 --%>
		<input type="hidden" name="num" value="<%=product.getNum() %>">
		<%-- 제품 이미지를 변경하지 않을 경우 기존 제품 관련 이미지를 사용하기 위해 전달하거나
		 제품 관련 이미지를 변경할 경우 기존 제품 이미지를 서버 디렉토리에서 삭제하기 위함 --%>
		<input type="hidden" name="currentImageMain" value="<%=product.getImageMain() %>">
		<input type="hidden" name="currentImageDetail" value="<%=product.getImageDetail() %>">
		<table>
			<tr>
				<td>카테고리</td>
				<td>
					<select name="category">
						<option value="CPU" <% if(product.getCategory().equals("CPU")) { %> selected="selected" <% } %>>중앙처리장치(CPU)</option>
						<option value="MAINBOARD" <% if(product.getCategory().equals("MAINBOARD")) { %> selected="selected" <% } %>>메인보드(MAINBOARD)</option>
						<option value="MEMORY" <% if(product.getCategory().equals("MEMORY")) { %> selected="selected" <% } %>>메모리(MEMORY)</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>제품명</td>	
				<td>
					<input type="text" name="name" id="name" value="<%=product.getName() %>">
				</td>
			</tr>
			<tr>
				<td>대표이미지</td>	
				<td>
					<img src="<%=request.getContextPath()%>/product_image/<%=product.getImageMain()%>" width="400px">
					<br>
					<span style="color: red">이미지를 변경하지 않을 경우 입력하지 마세요.</span>
					<input type="file" name="imageMain" id="imageMain">
				</td>
			</tr>
			<tr>
				<td>상세이미지</td>	
				<td>
					<img src="<%=request.getContextPath()%>/product_image/<%=product.getImageDetail()%>" width="400px">
					<br>
					<span style="color: red">이미지를 변경하지 않을 경우 입력하지 마세요.</span>
					<input type="file" name="imageDetail" id="imageDetail">
				</td>
			</tr>
			<tr>
				<td>제품수량</td>	
				<td>
					<input type="text" name="qty" id="qty" value="<%=product.getQty() %>">
				</td>
			</tr>
			<tr>
				<td>제품가격</td>	
				<td>
					<input type="text" name="price" id="price" value="<%=product.getPrice() %>">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit">제품변경</button>
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