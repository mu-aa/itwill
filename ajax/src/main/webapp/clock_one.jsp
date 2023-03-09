<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script type="text/javascript" src="js/xhr.js"></script>
<style type="text/css">

div {font-size: 20px; margin: 10px;}

</style>
</head>
<body>
	<h1>브라우저 캐싱</h1>
	<hr>
	<div>
		클라이언트 시스템의 현재 날짜와 시간은
		<span id="clientTime">2023년 1월 9일 16시 16분 22초</span>입니다.
	</div>
	
	<div>
		서버 시스템의 현재 날짜와 시간은
		<span id="serverTime">2023년 1월 9일 16시 16분 22초</span>입니다.
	</div>
	
	<script type="text/javascript">
	//브라우저가 실행되는 시스템(클라이언트)의 현재 날짜와 시간을 제공받아 태그를 변경하는 함수
	//ㄴ 클라이언트에 따라 다른 결과 제공 가능
	function displayClientTime() {
		var now=new Date();
		var displayTime=now.getFullYear()+"년 "+(now.getMonth()+1)+"월 "+now.getDate()+"일 "
			+now.getHours()+"시 "+now.getMinutes()+"분 "+now.getSeconds()+"초";
		document.getElementById("clientTime").innerHTML=displayTime;
	}
	displayClientTime();
	setInterval(displayClientTime, 1000);
	
	
	//웹프로그램을 실행하는 시스템(서버)의 현재 날짜와 시간을 제공받아 태그를 변경하는 함수
	//ㄴ 서버의 날짜와 시간을 제공받아 사용하므로 모든 클라이언트에게 동일한 결과 제공
	//문제점) 동일한 웹프로그램을 지속적으로 요청한 경우 브라우저 캐싱 기능에 의해 서버에서
	//제공하는 응답결과가 아닌 기존 응답 결과를 재사용 - 계속 최초 응답결과를 사용하여 응답 처리
	//해결법-1) 웹프로그램에 대한 요청 URL 주소를 지속적으로 변경하여 요청 - QueryString 이용**(비권장)**
	//해결법-2) 요청 웹프로그램에서 응답결과에 대한 브라우저 캐싱 기능을 무효화 처리**(권장)**
	function displayServerTime() {
		//sendRequest("get", "clock_two.jsp?dummy="+new Date().getTime(), null, function() {
		sendRequest("get", "clock_two.jsp", null, function() {
			if(xhr.readyState==4) {
				if(xhr.status==200) {
					document.getElementById("serverTime").innerHTML=xhr.responseText;
				} else {
					alert("에러 코드 = "+xhr.status);
				}
			}
		});
	}
	displayServerTime();
	setInterval(displayServerTime, 1000);
	</script>
</body>
</html>