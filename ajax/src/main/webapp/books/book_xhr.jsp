<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- books.jsp 문서를 AJAX 기능으로 요청하여 XML 형식의 문서로 응답 받아 
태그로 변경하여 클라이언트에게 전달하는 JSP 문서 --%>
<%-- ㄴ XSL 문서를 이용하여 XML 형식의 데이터를 HTML 태그로 변환하여 응답 처리 --%>
<%-- ㄴ books.xsl 문서를 AJAX 기능으로 요청하여 XSL 문서를 응답받아 사용 --%>
<%-- AJAX 기능을 제공받기 위해 JavaScript 모듈(xhr.js - 전역변수, 함수) 사용 --%>
<%-- ㄴ 하나의 XMLHttpRequest 객체를 사용하여 요청과 응답 처리 - 다수의 웹프로그램 동시 요청 불가능 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/xhr.js"></script>
</head>
<body>
	<h1>교재목록</h1>
	<hr>
	<div id="books"></div>
	
	<script type="text/javascript">
	var xmlDoc=null; //XML 문서에 저장된 값을 저장하기 위한 전역변수
	var xslDoc=null; //XSL 문서에 저장된 값을 저장하기 위한 전역변수
	
	//books.jsp 문서를 AJAX 기능으로 요청하여 XML 문서로 응답받은 결과를 전역변수에 저장하는 함수
	function loadBooksXML() {
		sendRequest("get", "books.jsp", null, function(){
			if(xhr.readyState==4) {
				if(xhr.status==200) {
					xmlDoc=xhr.responseXML;
					loadBooksXSL(); //정상적인 실행을 위해 함수 안에 호출
				} else {
					alert("에러코드 = "+xhr.status);
				}
			}
		});
	}
	
	//books.xsl 문서를 AJAX 기능으로 요청하여 XSL 문서로 응답받은 결과를 전역변수에 저장하는 함수
	function loadBooksXSL() {
		sendRequest("get", "books.xsl", null, function(){
			if(xhr.readyState==4) {
				if(xhr.status==200) {
					xslDoc=xhr.responseXML;
					doXSLT(); //정상적인 실행을 위해 함수 안에 호출
				} else {
					alert("에러코드 = "+xhr.status);
				}
			}
		});
	}
	
	//XSLT를 사용하여 XML 문서를 제공받아 HTML 문서로 변환하여 페이지를 변경하는 함수
	function doXSLT() { //xmlDoc, xslDoc 객체가 둘 다 필요함
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
	
	loadBooksXML();
	//loadBooksXML(); 비동기식 통신이라 아직 결과가 나오지 않았는데  
	//doXSLT();		  호출될 수 있기 때문에 함수안에 포함시켜야함
	</script>
</body>
</html>