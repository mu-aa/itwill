<%@page import="xyz.itwill.dao.BoardDAO"%>
<%@page import="xyz.itwill.dto.BoardDTO"%>
<%@page import="xyz.itwill.util.Utility"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 게시글(변경글)을 전달받아 BOARD 테이블에 저장된 해당 게시글을 변경하고 게시글 출력페이지(board_detail.jsp)로
이동하기 위한 URL 주소를 클라이언트에게 전달하는 JSP 문서 --%>
<%-- ㄴ 게시글 출력페이지(board_detail.jsp)로 글번호, 페이지번호, 검색대상, 검색단어 전달 --%>
<%-- ㄴ 로그인 사용자 중 게시글 작성자이거나 관리자인 경우에만 요청 가능한 JSP 문서 --%>
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
	int num=Integer.parseInt(request.getParameter("num"));
	String pageNum=request.getParameter("pageNum");
	String search=request.getParameter("search");
	String keyword=request.getParameter("keyword");
	String subject=Utility.escapeTag(request.getParameter("subject"));
	int status=1;
	if(request.getParameter("secret")!=null) {
		status=Integer.parseInt(request.getParameter("secret"));
	}
	String content=Utility.escapeTag(request.getParameter("content"));
	
	//BoardDTO 객체를 생성하여 전달값으로 필드값 변경
	BoardDTO board=new BoardDTO();
	board.setNum(num);
	board.setSubject(subject);
	board.setContent(content);
	board.setStatus(status);
	
	//게시글을 전달받아 BOARD 테이블에 저장된 해당 게시글을 변경하는 DAO 클래스의 메소드 호출
	BoardDAO.getDAO().updateBoard(board);
	
	//페이지 이동
	out.println("<script type='text/javascript'>");
	out.println("location.href='"+request.getContextPath()+"/index.jsp?workgroup=board&work=board_detail"
		+"&num="+num+"&pageNum="+pageNum+"&search="+search+"&keyword="+keyword+"';");
	out.println("</script>");
%>