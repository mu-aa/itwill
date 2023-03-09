<%@page import="xyz.itwill.dto.BoardDTO"%>
<%@page import="xyz.itwill.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 글번호를 전달받아 BOARD 테이블에 저장된 게시글에서 해당 글번호의 게시글에 대한 STATUS 컬럼값을 [0]으로 변경하여
삭제 처리하고 게시글목록 출력페이지(board_list.jsp)로 이동하는 URL 주소를 클라이언트에게 전달하는 JSP 문서 --%>
<%-- ㄴ 로그인 사용자 중 게시글 작성자이거나 관리자인 경우에만 요청 가능한 JSP 문서 --%>
<%@include file="/security/login_check.jspf" %>
<%
	//비정상적인 요청에 대한 응답 처리
	if(request.getParameter("num")==null) {
		out.print("<script type='text/javascript'>");
		out.print("location.href='"+request.getContextPath()+"/index.jsp?workgroup=error&work=error_400'");
		out.print("</script>");
		return;
	}

	//전달값을 반환받아 저장
	int num=Integer.parseInt(request.getParameter("num"));
	
	//글번호를 전달받아 BOARD 테이블에 저장된 해당 글번호의 게시글을 검색하여 반환하는 DAO 클래스 메소드 호출
	BoardDTO board=BoardDAO.getDAO().selectBoard(num);
		
	//검색된 게시글이 없거나 삭제 게시글인 경우 에러페이지로 이동되도록 응답 처리 - 비정상적인 요청
	if(board==null || board.getStatus()==0) {
		out.print("<script type='text/javascript'>");
		out.print("location.href='"+request.getContextPath()+"/index.jsp?workgroup=error&work=error_400'");
		out.print("</script>");
		return;
	}
	
	//게시글 작성자 및 관리자가 아닌 경우 에러페이지로 이동되도록 응답 처리 - 비정상적인 요청
	if(!loginMember.getId().equals(board.getId()) && loginMember.getStatus()!=9) {
		out.print("<script type='text/javascript'>");
		out.print("location.href='"+request.getContextPath()+"/index.jsp?workgroup=error&work=error_400'");
		out.print("</script>");
		return;
	}
	
	//글번호와 글상태를 전달받아 BOARD 테이블에 저장된 해당 글번호의 게시글에 대한 STATUS 컬럼값을 [0]으로 변경하는
	//DAO 클래스 메소드 호출
	//BoardDAO.getDAO().updateStatus(num, board);
	
	//ㄴ 게시글을 전달받아 BOARD 테이블에 저장된 해당 게시글을 변경하는 DAO 클래스의 메소드 호출
	board.setStatus(0);
	BoardDAO.getDAO().updateBoard(board);
	
	//페이지 이동
	out.print("<script type='text/javascript'>");
	out.print("location.href='"+request.getContextPath()+"/index.jsp?workgroup=board&work=board_list&num=1';");
	out.print("</script>");
%>