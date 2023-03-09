<?xml version="1.0" encoding="utf-8"?>
<%@page import="xyz.itwill.dao.AjaxCommentDAO"%>
<%@page import="xyz.itwill.dto.AjaxCommentDTO"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 댓글정보(작성자와 댓글내용)을 전달받아 AJAX_COMMENT 테이블에 삽입하고 처리결과를
XML 데이타로 응답하는 JSP 문서 --%>
<%
	if(request.getMethod().equals("GET")) {
		response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		return;
	}

	request.setCharacterEncoding("utf-8");
	
	String writer=request.getParameter("writer");
	String content=request.getParameter("content");
	
	AjaxCommentDTO ajaxComment=new AjaxCommentDTO();
	ajaxComment.setWriter(writer);
	ajaxComment.setContent(content);
	
	int rows=AjaxCommentDAO.getDAO().insertAjaxComment(ajaxComment);
%>
<result>
	<% if(rows>0) {//삽입행이 있는 경우 - 댓글 삽입 성공 %>
	<code>success</code>
	<% } else {//삽입행이 없는 경우 - 댓글 삽입 실패 %>
	<code>error</code>
	<% } %>
</result>