<?xml version="1.0" encoding="utf-8"?>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<result>
	<code>success</code>
	<%-- CDATA는 Enter도 인식하므로 Element(or 태그)에 붙여서 작성하기 --%>
	<data><![CDATA[
		[
			{"id":"adc123","name":"홍길동"}
			,{"id":"xyz789","name":"임꺽정"}
			,{"id":"tgb567","name":"전우치"}
			,{"id":"qwe963","name":"일지매"}
			,{"id":"mnb174","name":"장길산"}
		]
	]]></data>
</result>