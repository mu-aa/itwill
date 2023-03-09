<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@page import="xyz.itwill.dto.ProductDTO"%>
<%@page import="xyz.itwill.dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- PRODUCT 테이블에 저장된 모든 제품정보를 검색하여 클라이언트에게 전달하는 JSP 문서 --%>
<%
	//PRODUCT 테이블에 저장된 모든 제품정보를 검색하여 반환하는 DAO 클래스의 메소드 호출
	List<ProductDTO> productList=ProductDAO.getDAO().selectProductList("ALL");
%>
<style type="text/css">
#productList {
	width: 1200px;
	margin: 0 auto;
}

.product {
	width: 350px;
	margin: 10px;
	padding: 10px 5px;
	border: 1px solid black;
	text-align: center;
	float: left;
}
</style>
<div id="productList">
	<% for(ProductDTO product:productList) { %>
		<% if(product.getQty()!=0) { //제품 수량이 존재하는 경우 %>
			<%-- 제품정보 출력 --%>
			<div class="product">
				<div style="font-size: 14px;"><%=product.getName() %></div>
				<div>
					<a href="#">
						<img src="<%=request.getContextPath() %>/product_image/<%=product.getImageMain() %>">
					</a>
				</div>
				<div>
					<%=DecimalFormat.getCurrencyInstance().format(product.getPrice()) %>
				</div>
			</div>
		<% } %>
	<% } %>
	<div style="clear: both;"></div>
</div>