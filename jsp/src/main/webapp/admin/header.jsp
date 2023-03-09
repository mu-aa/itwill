<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 관리자 관련 페이지를 요청한 경우 템플릿 페이지의 header에 포함될 JSP 문서 --%>
<%--
	//세션의 속성값을 저장된 권한 관련 정보를 반환받아 저장
	MemberDTO loginMember=(MemberDTO)session.getAttribute("loginMember");
	
	//비로그인 사용자이거나 관리자가 아닌 경우 에러페이지로 이동되도록 응답 처리 - 비정상적인 요청
	if(loginMember==null || loginMember.getStatus()!=9) {
		out.print("<script type='text/javascript'>");
		out.print("location.href='"+request.getContextPath()+"/index.jsp?workgroup=error&work=error_400';");
		out.print("</script>");
		return;
	}
--%>
<%@include file="/security/admin_check.jspf" %>
<div id="profile">
		[admin]<%=loginMember.getName() %>님 환영합니다.&nbsp;&nbsp;
		<a href="index.jsp?workgroup=member&work=member_logout_action">로그아웃</a>&nbsp;&nbsp;
		<a href="index.jsp?workgroup=main&work=main_page">쇼핑몰</a>&nbsp;&nbsp;
</div>
<div id="logo"><a href="index.jsp?workgroup=admin&work=main_page">쇼핑몰관리</a></div>
<div id="menu">
	<a href="index.jsp?workgroup=admin&work=member_manager">회원관리</a>
	<a href="index.jsp?workgroup=admin&work=product_manager">제품관리</a>
	<a href="index.jsp?workgroup=admin&work=order_manager">주문관리</a>
	<a href="index.jsp?workgroup=admin&work=board_manager">게시글관리</a>
</div>