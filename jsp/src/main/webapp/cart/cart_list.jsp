<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 장바구니 목록을 클라이언트에게 전달하는 JSP 문서 --%>
<%-- ㄴ 로그인 사용자만 요청 가능한 JSP 문서 --%>
<%--
	//세션에 저장된 권한 관련 정보(회원정보)를 반환받아 저장
	MemberDTO loginMember=(MemberDTO)session.getAttribute("loginMember");

	//비로그인 사용자가 JSP 문서를 요청한 경우 로그인정보 입력페이지(member_login.jsp)로 이동
	if(loginMember==null) {
		//request.getRequestURI() : 요청 URL 주소에서 URI 주소를 반환하는 메소드
		String requestURI=request.getRequestURI();
		//System.out.println("requestURI = "+requestURI); == /jsp/index.jsp
				
		//request.getQueryString() : 요청 URL 주소에서 QueryString을 반환하는 메소드
		String queryString=request.getQueryString();
		//System.out.println("queryString = "+queryString); == workgroup=member&work=member_login(물음표 뒤의 자원들, 물음표 미포함)
				
		//session 내장객체에 요청 URL 주소를 속성값으로 저장
		if(queryString==null || queryString.equals("")) {
			session.setAttribute("returnURI", requestURI);
		} else {
			session.setAttribute("returnURI", requestURI+"?"+queryString);
		}
		
		out.print("<script type='text/javascript'>");
		out.print("location.href='"+request.getContextPath()+"/index.jsp?workgroup=member&work=member_login';");
		out.print("</script>");
	}
--%>
<%@include file="/security/login_URL.jspf" %>
<h1>장바구니 목록</h1>