<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/log.js"></script>
</head>
<body>
	<h1>로그함수</h1>
	<hr>
	<div id="log"></div>
	
	<script type="text/javascript">
	/*
	document.getElementById("log").innerHTML="메세지 출력-1<br>";
	document.getElementById("log").innerHTML="메세지 출력-2<br>";
	↓↓↓↓↓↓↓ */
	
	/* 모듈화(js/log.js) 
	function log(message) {
		var logElement=document.getElementById("log");
		if(logElement!=null) {
			logElement.innerHTML+=message+"<br>";
		}
	} */
	
	/*
	log("메세지 출력-1");
	log("메세지 출력-2"); */
	
	var id="abc123", name="홍길동";
	log("아이디 = "+id+" 이름 = "+name);

	var id="xyz123", name="임꺽정";
	log("아이디 = "+id+" 이름 = "+name);
	</script>
</body>
</html>