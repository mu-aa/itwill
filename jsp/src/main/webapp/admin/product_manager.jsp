<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@page import="xyz.itwill.dto.ProductDTO"%>
<%@page import="xyz.itwill.dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 카테고리를 전달받아 PRODUCT 테이블에 저장된 해당 카테고리의 모든 제품정보를 검색하여 클라이언트에게 전달하는 JSP 문서 --%>
<%-- ㄴ 관리자만 요청 가능한 JSP 문서 --%>
<%-- ㄴ [제품등록]을 클릭한 경우 제품정보 입력페이지(product_add.jsp)로 이동 --%>
<%-- ㄴ [카테고리]가 변경된 경우 제품목록 출력페이지(product_manager.jsp)로 이동 - 입력값 전달 --%>
<%-- ㄴ 제품정보의 [제품명]을 클릭한 경우 제품정보 출력페이지(product_detail.jsp)로 이동 - 제품번호 전달 --%>
<%@include file="/security/admin_check.jspf" %>
<%
	//전달값을 반환받아 저장
	String category=request.getParameter("category");
	if(category==null) {
		category="ALL";
	}
	
	//카테고리를 전달받아 PRODUCT 테이블에 저장된 해당 카테고리의 모든 제품정보를 검색하여 반환하는 DAO 클래스의 메소드 호출
	List<ProductDTO> productList=ProductDAO.getDAO().selectProductList(category);
%>
<style type="text/css">
#product {
	width: 1000px;
	margin: 0 auto;
}

#btn {
	text-align: right;
	margin-bottom: 5px;
}

table {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	border: 1px solid black;
	text-align: center;
	width: 200px;
}

th {
	background-color: black;
	color: white;
}

.pname {
	width: 400px;
}

td a. td a:hover {
	text-decoration: underline;
	color: blue;
}
</style>
<div id="product">
	<h1>제품목록</h1>
	
	<div id="btn">
		<button type="button" id="addBtn">제품등록</button>
	</div>
	
	<table>
		<tr>
			<th>제품번호</th>
			<th class="pname">제품명</th>
			<th>제품수량</th>
			<th>제품가격</th>
		</tr>
		
		<% if(productList.isEmpty()) { %>
		<tr>
			<td colspan="4">검색된 제품이 하나도 없습니다.</td>
		</tr>
		<% } else { %>
			<% for(ProductDTO product:productList) { %>
			<tr>
				<td><%=product.getNum() %></td>
				<td>
					<a href="<%=request.getContextPath() %>/index.jsp?workgroup=admin&work=product_detail&num=<%=product.getNum()%>">
						<%=product.getName() %>
					</a>
				</td>
				<td>
					<%=DecimalFormat.getInstance().format(product.getQty()) %>
				</td>	
				<td>
					<%-- DecimalFormat.getCurrencyInstance() : 원화표시 --%>
					<%=DecimalFormat.getCurrencyInstance().format(product.getPrice()) %>
				</td>	
			</tr>
			<% } %>
		<% } %>
	</table>
	
	<br>
	<form action="<%=request.getContextPath() %>/index.jsp?workgroup=admin&work=product_manager" 
		method="post" id="productForm">
		<select name="category" id="category">
			<option value="ALL" <% if(category.equals("ALL")) { %> selected="selected" <% } %>>
				전체(ALL)
			</option>
			<option value="CPU" <% if(category.equals("CPU")) { %> selected="selected" <% } %>>
				중앙처리장치(CPU)
			</option>
			<option value="MAINBOARD" <% if(category.equals("MAINBOARD")) { %> selected="selected" <% } %>>
				메인보드(MAINBOARD)
			</option>
			<option value="MEMORY" <% if(category.equals("MEMORY")) { %> selected="selected" <% } %>>
				메모리(MEMORY)
			</option>
		</select>
	</form>
</div>

<script type="text/javascript">
$("#addBtn").click(function() {
	location.href="<%=request.getContextPath()%>/index.jsp?workgroup=admin&work=product_add";
});

$("#category").change(function() {
	$("#productForm").submit();
});
</script>
