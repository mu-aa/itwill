<?xml version="1.0" encoding="utf-8"?>
<%@page import="xyz.itwill.util.Utility"%>
<%@page import="xyz.itwill.dao.AjaxCommentDAO"%>
<%@page import="xyz.itwill.dto.AjaxCommentDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- AJAX_COMMENT 테이블에 저장된 모든 댓글정보를 검색하여 XML 데이타로 응답하는 JSP 문서 --%>
<%
	List<AjaxCommentDTO> ajaxCommentList=AjaxCommentDAO.getDAO().selectAjaxCommentList();
%>
<result>
	<% if(!ajaxCommentList.isEmpty()) {//검색된 댓글이 있는 경우 %>
	<code>success</code>
	<data><![CDATA[
		[
		<% for(int i=0;i<ajaxCommentList.size();i++) { %>
			<% if(i>0) { %>,<% } %>
			{"num":<%=ajaxCommentList.get(i).getNum()%>
			<%-- 문제점)검색된 결과값에서 JSON 형식의 데이타로 표현할 수 없는 문자값이 존재하는 경우 에러 발생 --%>
			<%-- 해결법)JSON 형식의 데이타로 표현할 수 없는 문자값을 변환하여 사용 --%>
			,"writer":"<%=Utility.toJSON(ajaxCommentList.get(i).getWriter())%>"
			,"content":"<%=Utility.toJSON(ajaxCommentList.get(i).getContent())%>"
			,"regdate":"<%=ajaxCommentList.get(i).getRegdate()%>"}
		<% } %>
		]
	]]></data>
	<% } else {//검색된 댓글이 없는 경우 %>
	<code>empty</code>
	<message><![CDATA[첫번째 댓글을 입력해 주세요.]]></message>
	<% } %>
</result>