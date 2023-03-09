<%@page import="xyz.itwill.dao.MemberDAO"%>
<%@page import="xyz.itwill.util.Utility"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 회원정보를 전달받아 MEMBER 테이블에 저장된 회원정보를 변경하고 내정보 출력페이지(member_mypage.jsp)로
이동하기 위한 URL 주소 전달하는 JSP 문서 --%>
<%-- => 로그인 사용자만 요청 가능한 JSP 문서 --%>
<%@include file="/security/login_check.jspf" %>
<%
	//비정상적인 요청에 대한 응답 처리
	if(request.getMethod().equals("GET")) {
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/index.jsp?workgroup=error&work=error_400';");
		out.println("</script>");
		return;
	}
	
	//전달값을 반환받아 저장
	String id=request.getParameter("id");
	String passwd=request.getParameter("passwd");
	if(passwd==null || passwd.equals("")) {//비밀번호 전달값이 없는 경우
		//로그인 사용자의 비밀번호를 변수에 저장 - 기존 비밀번호 유지
		passwd=loginMember.getPasswd();
	} else {//비밀번호 전달값이 있는 경우
		//새로운 비밀번호를 암호화 처리하여 변수에 저장 - 비밀번호 변경
		passwd=Utility.encrypt(passwd);
	}
	String name=request.getParameter("name");
	String email=request.getParameter("email");
	String mobile=request.getParameter("mobile1")+"-"
		+request.getParameter("mobile2")+"-"+request.getParameter("mobile3");
	String zipcode=request.getParameter("zipcode");
	String address1=request.getParameter("address1");
	String address2=request.getParameter("address2");
	
	//MemberDTO 객체를 생성하여 전달값으로 필드값 변경
	MemberDTO member=new MemberDTO();
	member.setId(id);
	member.setPasswd(passwd);
	member.setName(name);
	member.setEmail(email);
	member.setMobile(mobile);
	member.setZipcode(zipcode);
	member.setAddress1(address1);
	member.setAddress2(address2);

	//회원정보를 전달받아 MEMBER 테이블에 저장된 회원정보를 변경하는 DAO 클래스의 메소드 호출
	MemberDAO.getDAO().updateMember(member);
	
	//세션에 저장된 권한 관련 정보(회원정보) 변경
	session.setAttribute("loginMember", MemberDAO.getDAO().selectMember(id));
	
	//클라이언트에게 URL 주소 전달
	out.println("<script type='text/javascript'>");
	out.println("location.href='"+request.getContextPath()+"/index.jsp?workgroup=member&work=member_mypage';");
	out.println("</script>");
%>