<?xml version="1.0" encoding="utf-8"?>
<%@page import="xyz.itwill.util.Utility"%>
<%@page import="xyz.itwill.dao.AjaxCommentDAO"%>
<%@page import="xyz.itwill.dto.AjaxCommentDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 댓글번호를 전달받아 AJAX_COMMENT 테이블에 저장된 해당 댓글번호의 댓글정보를 삭제하고 
처리결과를 XML 데이터로 응답하는 JSP 문서 --%>
<%
	if(request.getParameter("num")==null) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}
	
	int num=Integer.parseInt(request.getParameter("num"));
	
	int rows=AjaxCommentDAO.getDAO().deleteAjaxComment(num);
%>
<result>
	<% if(rows>0) {//삭제행이 있는 경우 - 댓글 삭제 성공 %>
	<code>success</code>
	<% } else {//삭제행이 없는 경우 - 댓글 삭제 실패 %>
	<code>error</code>
	<% } %>
</result>