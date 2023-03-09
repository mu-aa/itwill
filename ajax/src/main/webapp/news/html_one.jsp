<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- html_two.jsp 문서를 AJAX 기능으로 요청하여 HTML 형식의 문서로 응답 받아 
태그로 변경하여 클라이언트에게 전달하는 JSP 문서 --%>
<%-- 문제점) 다른 웹프로그램에서 JSP 문서(html_two.jsp)를 AJAX 기능으로 요청하여 응답받아 사용하기 불편 --%>
<%-- 해결법) AJAX 기능으로 요청하는 JSP 문서는 실행 결과를 HTML 문서가 아닌
데이터가 저장된 문서 형식(CSV, XML, JSON 등)으로 응답 처리 --%>
<%-- ㄴ 웹프로그램에 대한 처리 결과값만 제공받아 HTML 태그로 변환(Parsing)하여 응답 처리 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/xhr.js"></script>
<style type="text/css">

#newsList {width: 50%; margin: 0 auto;}
#newsHead {padding: 5px; text-align: center; font-size: x-large; border: 2px solid black;}
#newsContent {padding: 5px; font-size: medium; border: 2px dashed black; display: none;}

</style>
</head>
<body>
	<h1>헤드라인 뉴스</h1>
	<hr>
	<div id="newsList">
		<div id="newsHead">헤드라인 뉴스</div>
		<div id="newsContent">
			<%-- 
			<ol>
				<li>뉴스 제목-1[언론사-1]</li>
				<li>뉴스 제목-2[언론사-2]</li>
				<li>뉴스 제목-3[언론사-3]</li>
				<li>뉴스 제목-4[언론사-4]</li>
				<li>뉴스 제목-5[언론사-5]</li>
			</ol>
			--%>
		</div>
	</div>
	
	<script type="text/javascript">
	document.getElementById("newsList").onmouseover=function() {
		//AJAX 기능을 사용하여 웹프로그램을 요청하여 응답결과를 제공받아 처리
		sendRequest("get", "html_two.jsp", null, function() {
			if(xhr.readyState==4) {
				if(xhr.status==200) {
					document.getElementById("newsContent").innerHTML=xhr.responseText;
				} else {
					alert("에러 코드 = "+xhr.status);
				}
			}
		});
		document.getElementById("newsContent").style="display: block;";
	}
	
	document.getElementById("newsList").onmouseout=function() {
		document.getElementById("newsContent").style="display: none;";
	}
	</script>
</body>
</html>