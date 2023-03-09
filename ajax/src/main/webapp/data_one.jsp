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
	<h1>AJAX - 값 전달</h1>
	<hr>
	<div id="display">요청 웹프로그램에 대한 실행 결과 출력</div>
	<div>
		이름 : <input type="text" id="name">
		<button type="button" id="getBtn">GET 방식의 요청</button>
		<button type="button" id="postBtn">POST 방식의 요청</button>
	</div>
	
	<script type="text/javascript">
	var xhr=null;
	
	function getXMLHttpRequest() {
		if(window.ActiveXObject) {
			try {
				return new ActiveXObject("msxml12.XMLHTTP");
			} catch (e) {
				try {
					return new ActiveXObject("MicrosoftXML.HTTP");
				} catch (e) {
					return null;
				}
			}
		} else if(window.XMLHttpRequest) {
			return new XMLHttpRequest();
		} else {
			return null;
		}
	}
	
	//[GET 방식의 요청] 버튼을 클릭한 경우 호출되는 이벤트 처리 함수 등록
	document.getElementById("getBtn").onclick=function() {
		//입력태그의 입력값을 반환받아 저장
		var name=document.getElementById("name").value;
		
		//입력값 검증
		if(name=="") {
			document.getElementById("display").innerHTML="이름을 입력해주세요.";
			return;
		}
		
		//입력태그 초기화
		document.getElementById("name").value="";
		
		xhr=getXMLHttpRequest();
		xhr.onreadystatechange=viewMessage;
		
		//XMLHttpRequest 객체를 이용하여 웹프로그램을 GET 방식으로 요청
		//ㄴ GET 방식으로 웹프로그램을 요청할 경우 send 메소드가 아닌 open 메소드에 QueryString을 사용하여 값 전달
		//문제점) 전달값에 URL 주소로 표현 불가능한 문자값이 존재하는 경우 400 에러코드 발생
		//해결법) 전달값에 URL 주소로 표현 불가능한 문자값이 존재하는 경우 부호화 처리하여 전달
		name=encodeURIComponent(name);
		xhr.open("get", "data_two.jsp?name="+name, true);
		xhr.send(null);
		
	}
	
	//[POST 방식의 요청] 버튼을 클릭한 경우 호출되는 이벤트 처리 함수 등록
	document.getElementById("getBtn").onclick=function() {
		//입력태그의 입력값을 반환받아 저장
		var name=document.getElementById("name").value;
		
		//입력값 검증
		if(name=="") {
			document.getElementById("display").innerHTML="이름을 입력해주세요.";
			return;
		}
		
		//입력태그 초기화
		document.getElementById("name").value="";
		
		xhr=getXMLHttpRequest();
		xhr.onreadystatechange=viewMessage;
		
		//XMLHttpRequest 객체를 이용하여 웹프로그램을 POST 방식으로 요청
		//ㄴ POST 방식으로 웹프로그램을 요청한 경우 send 메소드의 매개변수를 사용하여 값 전달
		//문제점) send 메소드를 이용해 값을 전달할 경우 "multipart/form-data"(원시데이터) 형식으로 값 전달
		//ㄴ 요청 웹프로그램에 request 객체의 getParameter() 메소드로 전달값 반환 불가능
		//해결법) "application/x-www-form-urlencoded" 형식(텍스트 데이터)으로 값이 전달되도록 request message의 header 정보 변경 
		xhr.open("post", "date_two.jsp");
		//XMLHttpRequest.setRequestHeader(header, value) : XMLHttpRequest 객체를 이용하여 웹프로그램을 요청할 때
		//사용하는 request message의 header 정보를 변경하는 메소드
		//ㄴ request message의 body에 저장된 값이 텍스트 형식의 문자값을 표현
		//ㄴ open 메소드 호출 후 사용 가능
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.send("name="+name);
		
	}
	
	//요청 웹프로그램의 응답결과를 제공받아 페이지의 요소를 변경하는 이벤트 처리 함수
	function viewMessage() {
		if(xhr.readyState==4) {
			if(xhr.status==200) {
				document.getElementById("display").innerHTML=xhr.responseText;
			} else {
				alert("에러코드 = "+xhr.status);
			}
		}
	}
	</script>
</body>
</html>