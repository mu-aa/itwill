<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 회원정보를 입력받기 위한 JSP 문서 --%>
<%-- => [회원가입] 태그를 클릭한 경우 form 태그를 이용하여 회원정보 삽입페이지(member_join_action.jsp)을 
POST 방식으로 요청하여 이동 - 사용자 입력값(회원정보) 전달 --%>    
<%-- => 회원정보 삽입페이지 요청 전 사용자 입력값에 대한 검증 - 입력검증, 형식검증, 중복검증(AJAX) 등 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<style type="text/css">
.title {
	width: 100px;
	padding-right: 10px;
	text-align: center;
	font-weight: bold;
}

.input {
	width: 200px;
}

.message {
	width: 500px;
	color: red;
}

.msg {
	display: none;
}

#btn {
	text-align: center;
}
</style>
</head>
<body>
	<h1>회원가입</h1>
	<hr>
	<form action="member_join_action.jsp" method="post" id="joinForm">
	<table>
		<tr>
			<td class="title">아이디</td>
			<td class="input"><input type="text" name="id" id="id"></td>
			<td class="message">
				<span id="idNullMsg" class="msg idMsg">아이디를 입력해 주세요.</span>
				<span id="idValidMsg" class="msg idMsg">아이디를 형식에 맞게 입력해 주세요.</span>
				<span id="idDuplMsg" class="msg idMsg">이미 사용중인 아이디입니다.</span>
			</td>
		</tr>
		<tr>
			<td class="title">비밀번호</td>
			<td class="input"><input type="password" name="passwd" id="passwd"></td>
			<td class="message">
				<span id="passwdNullMsg" class="msg">비밀번호를 입력해 주세요.</span>
				<span id="passwdValidMsg" class="msg">비밀번호를 형식에 맞게 입력해 주세요.</span>
			</td>
		</tr>
		<tr>
			<td class="title">이름</td>
			<td class="input"><input type="text" name="name" id="name"></td>
			<td class="message">
				<span id="nameNullMsg" class="msg">이름을 입력해 주세요.</span>
				<span id="nameValidMsg" class="msg">이름을 형식에 맞게 입력해 주세요.</span>
			</td>
		</tr>
		<tr>
			<td class="title">이메일</td>
			<td class="input"><input type="text" name="email" id="email"></td>
			<td class="message">
				<span id="emailNullMsg" class="msg">이메일을 입력해 주세요.</span>
				<span id="emailValidMsg" class="msg">이메일을 형식에 맞게 입력해 주세요.</span>
			</td>
		</tr>
		<tr>
			<td colspan="2" id="btn"><button type="submit">회원가입</button></td> 
		</tr>
	</table>	
	</form>
	
	<script type="text/javascript">
	/*
	
	//document.getElementById("id").focus(); //js
	$("#id").focus(); //jquery
	
	//document.getElementById("joinForm").onsubmit=function() {
	$(#"joinForm").submit(function() {
		//모든 메세지 관련 엘리먼트를 미배치
		/* 
		var msgList=document.querySelectorAll(".msg");
		for(i=0;i<msgList.length;i++) {
			msgList.item(i).style.display="none";
		} */ /*
		$(".msg").hide();
		
		//입력값 검증 결과를 저장하기 위한 변수
		// => false : 검증 실패(Submit 이벤트 취소), true : 검증 성공 
		var validResult=true;
		
		//id 검증
		//var id=document.getElementById("id").value;
		var id=$("#id").val();
		var idReg=/^[a-zA-Z]\w{5,19}$/g;
		if(id=="") {
			//document.getElementById("idNullMsg").style.display="block";
			$("#idNullMsg").show();
			validResult=false;
		} else if(!idReg.test(id)) {
			//document.getElementById("idValidMsg").style.display="block";
			$("#idValidMsg").show();
			validResult=false;
		} else if(!idCheckResult) { //아이디가 중복인 경우
			//document.getElementById("idDuplMsg").style.display="block";
			$("#idDuplMsg").show();
			validResult=false;
		}
		
		//passwd 검증
		var passwd=$("#passwd").val();
		var passwdReg=/^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{6,20}$/g;
		if(passwd=="") {
			//document.getElementById("passwdNullMsg").style.display="block";
			$("#passwdNullMsg").show();
			validResult=false;
		} else if(!passwdReg.test(passwd)) {
			//document.getElementById("passwdValidMsg").style.display="block";
			$("#passwdValidMsg").show();
			validResult=false;
		}
		
		//name 검증
		var name=$("#name").val();
		var nameReg=/^[가-힣]{2,10}$/g;
		if(name=="") {
			//document.getElementById("nameNullMsg").style.display="block";
			$("#nameNullMsg").show();
			validResult=false;
		} else if(!nameReg.test(name)) {
			//document.getElementById("nameValidMsg").style.display="block";
			$("#nameValidMsg").show();
			validResult=false;
		}
		
		//email 검증
		var email=$("#email").val();
		var emailReg=/^([a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+(\.[-a-zA-Z0-9]+)+)*$/g;
		if(email=="") {
			//document.getElementById("emailNullMsg").style.display="block";
			$("#emailNullMsg").show();
			validResult=false;
		} else if(!emailReg.test(email)) {
			//document.getElementById("emailValidMsg").style.display="block";
			$("#emailValidMsg").show();
			validResult=false;
		}
		
		return validResult;
	}
	
	//아이디 중복검사 결과를 저장하는 전역변수 선언
	//ㄴ false : 아이디 사용 불가능 / true : 아이디 사용 가능
	var idCheckResult=false;
	
	//아이디 입력태그에서 키보드를 누른 경우 호출되는 이벤트 처리 함수(Event Handler) 등록
	//document.getElementById("id").onkeyup=function() {
	$("#id").onkeyup(function(){
		idCheckResult=false;
		
		//var id=document.getElementById("id").value;
		var id=$("#id").val();
		if(id.length<6) {return;}
		
		$.ajax({
			type: "get",
			url: "member_id_check.jsp",
			data: "id="+id,
			dataType: "xml",
			success: function(xmlDoc) {
				var code=$(xmlDoc).find("code").text();
				if(code=="possible"){
					idCheckResult=true;
				}
			},
			error: function(xhr) {
				alert("에러코드 = "+xhr.status);
			}
		});
	});
	*/
	
	//submit 시 한 번에 처리
	$("#id").focus();
	$("#joinForm").submit(function() {
		$(".msg").hide();
		
		//입력값 검증 결과를 저장하기 위한 변수
		// => false : 검증 실패(Submit 이벤트 취소), true : 검증 성공 
		var validResult=true;
		
		//id 검증
		//var id=document.getElementById("id").value;
		var id=$("#id").val();
		var idReg=/^[a-zA-Z]\w{5,19}$/g;
		if(id=="") {
			$("#idNullMsg").show();
			validResult=false;
		} else if(!idReg.test(id)) {
			$("#idValidMsg").show();
			validResult=false;
		} else { // 정상적인 아이디가 입력된 경우
			//문제점) 비동기식 통신에 의해 요청에 대한 처리결과(xml)를 응답받기 전에 검증이 종료되어
			//form 태그가 실행되어버릴 수 있음 - 정상적인 아이디 중복 검사 실행 불가능
			//해걸법) 동기식 통신으로 웹프로그램을 요청하여 응답받아 처리
			$.ajax({
				type: "get",
				url: "member_id_check.jsp",
				data: "id="+id,
				async: false, //true : 비동기식 통신(default) / false : 동기식 통신
				dataType: "xml",
				success: function(xmlDoc) {
					var code=$(xmlDoc).find("code").text();
					if(code=="impossible") {
						$("#idDuplMsg").show();
						validResult=false;
					}
				},
				error: function(xhr) {
					alert("에러코드 = "+xhr.status);
				}
			});
		}
		
		//passwd 검증
		var passwd=$("#passwd").val();
		var passwdReg=/^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{6,20}$/g;
		if(passwd=="") {
			$("#passwdNullMsg").show();
			validResult=false;
		} else if(!passwdReg.test(passwd)) {
			$("#passwdValidMsg").show();
			validResult=false;
		}
		
		//name 검증
		var name=$("#name").val();
		var nameReg=/^[가-힣]{2,10}$/g;
		if(name=="") {
			$("#nameNullMsg").show();
			validResult=false;
		} else if(!nameReg.test(name)) {
			$("#nameValidMsg").show();
			validResult=false;
		}
		
		//email 검증
		var email=$("#email").val();
		var emailReg=/^([a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+(\.[-a-zA-Z0-9]+)+)*$/g;
		if(email=="") {
			$("#emailNullMsg").show();
			validResult=false;
		} else if(!emailReg.test(email)) {
			$("#emailValidMsg").show();
			validResult=false;
		}
		
		return validResult;
		
	});
	</script>
</body>
</html>