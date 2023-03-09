<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- books.jsp 문서를 AJAX 기능으로 요청하여 XML 형식의 문서로 응답 받아 
태그로 변경하여 클라이언트에게 전달하는 JSP 문서 --%>
<%-- ㄴ XSL 문서를 이용하여 XML 형식의 데이터를 HTML 태그로 변환하여 응답 처리 --%>
<%-- ㄴ books.xsl 문서를 AJAX 기능으로 요청하여 XSL 문서를 응답받아 사용 --%>
<%-- AJAX 기능을 제공받기 위해 JavaScript 모듈(ajax.js - 객체) 사용 --%>
<%-- ㄴ 다수의 XMLHttpRequest 객체를 사용하여 요청과 응답 처리 가능 - 다수의 웹프로그램 동시요청 가능 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ajax.js"></script>
</head>
<body>
	<h1>교재목록</h1>
	<hr>
	<div id="books"></div>
	
	<script type="text/javascript">
	var xmlDoc=null;
	var xslDoc=null;
	function loadBooksXML() { 
		//응답결과를 제공받아 처리하는 콜백함수에는 XMLHttpRequest 객체를
		//저장하기 위한 매개변수(xhr)를 반드시 선언
		new xyz.itwill.Ajax("get", "books.jsp", null, function(xhr) { //Ajax Engine-1
			if(xhr.readyState==4){
				if(xhr.status==200) {
					xmlDoc=xhr.responseXML;
					doXSLT(); //먼저 실행되는 쪽이 함수 호출
				} else {
					alert("에러코드 = "+xhr.status);
				}
			}
		});
	}
	function loadBooksXSL() { 
		new xyz.itwill.Ajax("get", "books.xsl", null, function(xhr) { //Ajax Engine-2
			if(xhr.readyState==4){
				if(xhr.status==200) {
					xslDoc=xhr.responseXML;
					doXSLT(); //먼저 실행되는 쪽이 함수 호출
				} else {
					alert("에러코드 = "+xhr.status);
				}
			}
		});
	}
	
	function doXSLT() {
		if(xmlDoc==null || xslDoc==null) { return; } //둘 중 하나라도 실행오류면 종료
		
		//XSLTProcessor 객체 생성 - XSLT를 이용하여 XML 문서를 변환하기 위한 기능을 제공하는 객체
		var xsltProcessor=new XSLTProcessor();
		
		//XSLTProcessor.importStylesheet(xsl) : XSLTProcessor 객체에 변환 관련 정보가 저장된
		//XMLDocument 객체(XSLT)를 저장하기 위한 메소드
		xsltProcessor.importStylesheet(xslDoc);
		
		//XSLTProcessor.transformToFragment(xml, document) : XML 문서를 전달받아 XSLTProcessor 객체에
		//저장된 변환 관련 정보(XSLT)를 사용하여 document 객체의 자식 Element 객체로 반환하는 메소드
		var fragment=xsltProcessor.transformToFragment(xmlDoc, document);
		
		//반환받은 Element 객체를 특정 태그의 마지막 자식 태그로 추가하여 출력 처리
		document.getElementById("books").appendChild(fragment);
	}
	
	loadBooksXML(); //Ajax Engine이 여러개 (객체를 이용하여 여러개)를 만들었기 때문에
	loadBooksXSL(); //동시에 실행할 수 있음
	</script>
</body>
</html>