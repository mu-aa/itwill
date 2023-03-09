<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@page import="xyz.itwill.dao.MemberDAO"%>
<%@page import="xyz.itwill.util.Utility"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 로그인정보를 전달받아 MEMBER 테이블에 저장된 회원정보와 비교하여 인증처리하고 처리결과를 이용하여
클라이언트에게 URL 주소를 전달하는 JSP 문서 --%>
<%-- ㄴ 인증실패 : 로그인정보 입력페이지(member_login.jsp)로 이동 --%>
<%-- ㄴ 인증성공 : 세션에 권한 관련 정보를 저장하고 기존 요청 페이지로 이동하거나 또는 메인페이지(main_page.jsp)로 이동 --%>
<%
	//비정상적인 요청에 대한 응답 처리
	if(request.getMethod().equals("GET")) {
		out.print("<script type='text/javascript'>");
		out.print("location.href='"+request.getContextPath()+"/index.jsp?workgroup=error&work=error_400';");
		out.print("</script>");
		return;
	}

	//전달값을 반환받아 저장
	String id=request.getParameter("id");
	String passwd=Utility.encrypt(request.getParameter("passwd"));
	
	//아이디를 전달받아 MEMBER 테이블에 저장된 해당 아이디의 회원정보를 검색하여 반환하는 DAO 클래스의 메소드 호출
	MemberDTO member=MemberDAO.getDAO().selectMember(id);
	
	//전달받은 아이디로 검색된 회원정보가 없거나 탈퇴회원인 경우 - 아이디 인증 실패
	if(member==null || member.getStatus()==0) {
		session.setAttribute("message", "입력한 아이디가 존재하지 않습니다.");
		session.setAttribute("id", id);
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/index.jsp?workgroup=members&work=member_login';");
		out.println("</script>");
		return;
	}
	
	//검색된 회원정보의 비밀번호와 전달받은 비밀번호가 일치하지 않는 경우 - 비밀번호 인증 실패
	if(!member.getPasswd().equals(passwd)) {
		session.setAttribute("message", "입력한 아이디가 잘못되었거나 비밀번호가 일치하지 않습니다.");
		session.setAttribute("passwd", passwd);
		
		out.print("<script type='text/javascript'>");
		out.print("location.href='"+request.getContextPath()+"/index.jsp?workgroup=members&work=member_login';");
		out.print("</script>");
		return;
	}
	
	//인증 성공
	
	//아이디를 전달받아 MEMBER 테이블에 저장된 해당 아이디의 회원정보 중 마지막 로그인 날짜를 변경하는
	//DAO 클래스의 메소드 호출
	MemberDAO.getDAO().updateLastLogin(id);
	
	//세션에 권한 관련 정보를(회원정보) 저장
	session.setAttribute("loginMember", MemberDAO.getDAO().selectMember(id)); //id를 속성값으로 저장하는게 세션을 덜 사용함
	
	//세션에 저장된 요청 페이지의 URL 주소를 반환받아 저장
	String returnUrl=(String)session.getAttribute("returnUrl");
	
	if(returnUrl==null) { //요청 페이지가 없는 경우
		out.print("<script type='text/javascript'>");
		out.print("location.href='"+request.getContextPath()+"/index.jsp?workgroup=main&work=main_page';");
		out.print("</script>");
	} else { //요청 페이지가 있는 경우 
		session.removeAttribute("returnUrl");
		out.print("<script type='text/javascript'>");
		out.print("location.href='"+returnUrl+"';");
		out.print("</script>");
	}
%>
