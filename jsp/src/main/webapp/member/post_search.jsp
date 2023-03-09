<%@page import="java.util.ArrayList"%>
<%@page import="xyz.itwill.dto.ZipDTO"%>
<%@page import="xyz.itwill.dao.ZipDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 사용자로부터 동이름을 입력받아 ZIP 테이블에 저장된 해당 동 이름이 포함된 우편번호 관련 정보를 
검색하여 클라이언트에게 전달하는 JSP 문서 --%>
<%-- [기본주소]를 클릭한 경우 부모창의 입력태그(우편번호, 기본주소)의 입력값 변경 --%>
<%
	//전달값을 반환받아 저장
	String dong=request.getParameter("dong");
	
	//동이름을 전달받아 ZIP 테이블에 저장된 해당 동이름으로 시작되는 우편번호 관련 정보를 검색하여
	//반환하는 DAO 클래스 메소드 호출
	List<ZipDTO> zipList=new ArrayList<>();
	if(dong!=null) { //전달값이 없는 경우
		zipList=ZipDAO.getDAO().selectZipList(dong);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<style type="text/css">
#search {
	width: 550px;
	text-align: center;
}

table {
	border: 1px solid black;
	border-collapse: collapse;
	margin: 10px auto;
	font-size: 14px;
}

td {
	border: 1px solid black;
	text-align: center;
}

.zipcode {
	width: 100px;
}

.address {
	width: 450px;
	text-align: left;
	padding: 2px;
}
</style>
</head>
<body>
	<div id="search">
		<form name="postForm">
			동이름 : <input type="text" name="dong">
			<button type="button" id="searchBtn">주소검색</button>
		</form>
	</div>
	<%-- 검색된 우편번호 관련 정보를 클라이언트에게 전달 --%>
	<% if(!zipList.isEmpty()) { //검색된 우편번호 관련 정보가 있는 경우 %>
		<table>
			<tr>
				<td class="zipcode">우편번호</td>
				<td class="address" style="text-align: center;">기본주소</td>
			</tr>
			
			<% for(ZipDTO zip:zipList) { %>
				<tr>
					<td class="zipcode"><%=zip.getZipcode() %></td>
					<%-- a 태그를 이용하여 JavaScript 명령 작성 시 반드시 javascript 접두사를 사용해야함 --%>
					<td class="address"><a href="javascript:searchPost('<%=zip.getZipcode()%>', '<%=zip.getAddress()%>');"></a></td>
				</tr>
			<% } %>
		</table>
	<% } %>
	<script type="text/javascript">
	postForm.dong.focus();
	
	document.getElementById("searchBtn").onclick=function() {
		if(postForm.dong.value=="") {
			postForm.dong.focus();
			return;
		}
		postFrom.submit();
	}
	
	function searchPost(code, addr) {
		opener.join.zipcode.value=code;
		opener.join.address1.value=addr;
		window.close();
	}
	</script>
</body>
</html>