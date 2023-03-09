<%@page import="java.text.DecimalFormat"%>
<%@page import="xyz.itwill.dto.ProductDTO"%>
<%@page import="xyz.itwill.dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 제품번호를 전달받아 PRODUCT 테이블에 저장된 해당 제품번호의 제품정보를 검색하여 클라이언트에게 전달하는 JSP 문서 --%>
<%-- => 관리자만 요청 가능한 JSP 문서 --%>
<%-- [제품정보변경]을 클릭한 경우 제품접오 입력페이지(product_modify.jsp)로 이동 - 제품번호 전달 --%>
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
table {
	margin: 0 auto;
	border: 1px solid black;
	border-collapse: collapse;
}

td {
	border: 1px solid black;
}

.title {
	background-color: black;
	color:white;
	text-align: center;
	width: 100px;
}

.value {
	padding: 5px;
	text-align: left;
	width: 500px;
}
</style>

<h2>제품상세정보</h2>
<table>
	<tr>
		<td class="title">제품번호</td>
		<td class="value"><%=product.getNum() %></td>
	</tr>
	<tr>
		<td class="title">카테고리</td>
		<td class="value"><%=product.getCategory() %></td>
	</tr>
	<tr>
		<td class="title">제품명</td>
		<td class="value"><%=product.getName() %></td>
	</tr>
	<tr>
		<td class="title">대표이미지</td>
		<td class="value">
			<img src="<%=request.getContextPath()%>/product_image/<%=product.getImageMain()%>" width="400px">
		</td>
	</tr>
	<tr>
		<td class="title">상세이미지</td>
		<td class="value">
			<img src="<%=request.getContextPath()%>/product_image/<%=product.getImageDetail()%>" width="400px">
		</td>
	</tr>
	<tr>
		<td class="title">제품수량</td>
		<td class="value"><%=DecimalFormat.getInstance().format(product.getQty()) %></td>
	</tr>
	<tr>
		<td class="title">제품가격</td>
		<td class="value"><%=DecimalFormat.getInstance().format(product.getPrice()) %>원</td>
	</tr>
</table>

<%-- [제품정보변경] 클릭 시 product_modify.jsp로 이동 --%>
<p><button type="button" onclick="location.href='<%=request.getContextPath() %>/index.jsp?workgroup=admin&work=product_modify&num=<%=product.getNum()%>';">제품정보 변경</button></p>