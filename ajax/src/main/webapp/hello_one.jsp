<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<style type="text/css">

#display {width: 50%; padding: 5px; margin: 10px; font-size: 30px; border: 1px solid red;}

</style>
</head>
<body>
	<h1>AJAX Programming</h1>
	<hr>
	<div id="display">Hello, AJAX</div>
	<div>
		<button type="button" id="btn1">번역하기</button>
		<button type="button" id="btn2">배경색 변경</button>
	</div>
	
	<script type="text/javascript">
	/*	//Element 객체(button 태그)의 클릭 이벤트에 의해 호출될 이벤트 처리 함수 등록
	document.getElementById("btn1").onclick=function() {
		//DHTML을 이용해 페이지의 요소(태그) 변경
		//ㄴ 현재 웹프로그램의 실행 결과를 이용하여 태그 변경
		document.getElementById("display").innerHTML="안녕하세요, AJAX";
	}  */
	
	//XMLHttpRequest 객체를 저장하기 위한 전역변수 선언
	//XMLHttpRequest 객체 : 비동기식으로 웹프로그램을 요청하여 응답받아 처리하기 위한 객체 - AJAX Engine
	var xhr=null;
	
	//XMLHttpRequest 객체를 생성하여 반환하는 함수 선언
	//ㄴ 브라우저 종류와 버전에 따라 XMLHttpRequest 객체를 생성하는 방법이 다양하므로 함수로 선언
	function getXMLHttpRequest() {
		if(window.ActiveXObject) { //IE4~6
			try{
				return new ActiveXObject("msxml12.XMLHTTP"); //IE5~6
			} catch (e) {
				try {
					return new ActiveXObject("MicrosoftXML.HTTP"); //IE4
				} catch (e) {
					return null;
				}
			}
		} else if(window.XMLHttpRequest) {//IE7 이상 또는 대다수의 웹브라우저
			return new XMLHttpRequest();
		} else {
			return null;
		}
	}
	
	//Element 객체(button 태그)의 클릭 이벤트에 의해 호출될 이벤트 처리 함수 등록
	document.getElementById("btn1").onclick=function() {
		//AJAX 기능(Asynchronous JavaScript + XML)을 이용하여 페이지의 요소(태그) 변경
		//ㄴ XMLHttpRequest 객체를 사용하여 비동기식으로 다른 웹프로그램을 요청하여 실행
		//, 결과를 XML로 제공받아 페이지의 요소 변경
		
		//●1. XMLHttpRequest 객체를 생성하여 저장 - 전역변수와 함수 이용
		xhr=getXMLHttpRequest();
		
		//●2. XMLHttpRequest 객체의 준비상태(Ready State)가 변경될 경우 호출될 이벤트 처리 함수 등록
		//XMLHttpRequest.readyState : XMLHttpRequest 객체의 준비상태 정보를 저장한 속성(Property)
		//ㄴ XMLHttpRequest 객체의 준비상태는 순차적으로 자동 변경
		//ㄴ 0(기본), 1(요청 초기화 - open), 2(요청 - send), 3(응답대기 - 처리중), 4(응답 - 결과)
		//XMLHttpRequest.onreadystatechange : XMLHttpRequest 객체의 준비상태가 변경될 경우
		//호출될 이벤트 처리 함수를 저장(등록)하기 위한 이벤트 속성(Property)
		xhr.onreadystatechange=changeHTML; //이벤트 처리 함수는 4번 호출됨
		
		//●3. XMLHttpRequest 객체로 open 메소드 호출 - **readyState: 1**
		//XMLHttpRequest.open(method, url[, async]) : XMLHttpRequest 객체로 웹 프로그램을
		//요청하기 위한 정보를 설정하는 메소드
		//ㄴ method : 요청방식 - GET, POST - (PUT, PATCH, DELETE) 등
		//ㄴ url : 요청 웹프로그램의 URL 주소 - 현재 서버의 웹프로그램만 요청 가능
		//ㄴ async : true(비동기식 - default)/false(동기식) 통신 구분
		xhr.open("get", "hello_two.jsp", true); //비동기식 통신 - 요청에 대한 응답의 딜레이 미발생 - 다른 작업 가능
		//xhr.open("get", "hello_two.jsp", false); //동기식 통신 - 요청에 대한 응답의 딜레이 발생 - 다른 작업 불가능
		
		//●4. XMLHttpRequest 객체로 send 메소드 호출 - **readyState: 2**
		//XMLHttpRequest.send(data) : XMLHttpRequest 객체로 웹프로그램을 요청하기 위한 메소드
		//ㄴ date : 요청 웹프로그램에 전달할 값을 [이름=값&이름=값& ...] 형식으로 표현하여 제공
		//ㄴ Request 메세지의 body에 값을 저장하여 전달 - POST 방식으로 요청하여 값 전달
		//ㄴ 전달값이 없거나 GET 방식으로 요청한 경우 매개변수에는 null 전달
		xhr.send(null); //웹프로그램 요청 - 준비상태가 자동으로 [3]과 [4]로 변경 
	}
	
	//XMLHttpRequest 객체의 준비상태가 변경될 경우 호출될 이벤트 처리 함수(이벤트 핸들러)
	function changeHTML() {
		/* if(xhr.readyState==1){
			alert("요청 초기화 상태");
		} else if(xhr.readyState==2){
			alert("요청 상태");
		} else if(xhr.readyState==3){
			alert("응답대기 상태");
		} else if(xhr.readyState==4){
			alert("응답완료 상태");
		} */
		
		//●5. 응답결과를 제공받아 페이지의 요소 조작 - DHTML
		if(xhr.readyState==4) {
			//XMLHttpRequest.status : 요청에 대한 실행 결과의 상태코드(Status Code)를 저장한 속성(Property)
			if(xhr.status==200) { //요청에 대한 정상적인 실행결과(2XX)
				//XMLHttpRequest.responseText : 웹프로그램 요청에 대한 실행결과를 TEXT 또는 HTML로 저장한 속성(Property)
				//XMLHttpRequest.responseXML: 웹프로그램 요청에 대한 실행결과를 XML로 저장한 속성(Property)
				document.getElementById("display").innerHTML=xhr.responseText;
			} else { //요청에 대한 비정상적인 실행 결과(4XX or 5XX)
				alert("에러코드 = "+xhr.status);
			}
		} else { //요청이 아직 처리중인 경우
			document.getElementById("display").innerHTML="<img src='image/loading.gif' width='50'>"
		}
	}
	
	document.getElementById("btn2").onclick=function() {
		document.getElementById("display").style="background-color: pink";
	}
	</script>
</body>
</html>