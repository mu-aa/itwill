<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 사용자에게 회원정보를 입력받기 위한 JSP 문서 - 입력페이지 --%>
<%-- ㄴ [가입]을 클릭한 경우 form 태그를 실행해 처리페이지(join_action.jsp)를 post 방식으로 요청해 
페이지 이동 - 사용자 입력값(회원정보) 전달 --%>
<%
	//전달값(에러메세지)을 반환받아 저장
	/* ●1
	String message=request.getParameter("message");
	
	if(message==null) { //전달값이 없는 경우
		message=""; //null이 저장되지 않도록 초기화
	}
	*/
	
	/* ●2
	String message=request.getParameter("message");
	if(message!=null && message.equals("1")) {
		message="비정상적인 방법으로 요청했습니다.";
	} else {
		message="";
	}*/
	
	//전달값(임의값)을 반환받아 저장
	/* ●3
	String message=request.getParameter("message");
	if(message==null) { //전달값이 없는 경우 - 에러 미발생
		message="";
	} else { //전달값이 있는 경우 - 에러 발생
		message="비정상적인 방법으로 요청했습니다.";
	}*/
	
	//●4
	//session 내장객체에 저장된 속성값(에러메세지)을 반환받아 저장
	String message=(String)session.getAttribute("message");
	if(message==null) { //session 내장객체에 저장된 속성값이 없는 경우
		message="";
	} else { //session 내장객체에 저장된 속성값이 있는 경우
		//session 내장객체에 저장된 속성값 삭제
		//ㄴ 다른 JSP 문서에서 session 내장객체에 저장된 속성값을 반환받아 사용하지 못하도록 제거
		session.removeAttribute("message");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>JSP</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript">
function loading() {
	window.document.join.id.focus();
}

function inputCheck(form) {
	if(is_null(form.id)) {
		alert("아이디를 입력해 주세요.");
		form.id.focus();
		return false;
	}
	
	
	if(!isID(form.id)) {
		alert("아이디는 영문자로 시작되며 영문자,숫자,_의 조합만 가능합니다.");
		form.id.focus();
		return false;
	}
	
	if(is_null(form.pass)) {
		alert("비밀번호를 입력해 주세요.");
		form.pass.focus();
		return false;
	}
	
	if(is_null(form.repass)) {
		alert("비밀번호확인을 입력해 주세요.");
		form.repass.focus();
		return false;
	}			
	
	if(isShort(form.pass, 6, "비밀번호는 6글자 이상 입력해 주세요.")) {
		return false;
	}
	
	if(!isSame(form.pass, form.repass)) {
		alert("비밀번호와 비밀번호확인이 서로 같지 않습니다.");
		form.pass.focus();
		return false;
	}
	
	if(is_null(form.name)) {
		alert("이름을 입력해 주세요.");
		form.name.focus();
		return false;
	}	
	
	if(is_null(form.addr)) {
		alert("주소를 입력해 주세요.");
		form.addr.focus();
		return false;
	}
	
	return true;			
}
</script>
<link rel="stylesheet" href="css/common.css" type="text/css"/>
</head>
<body onload="loading();">
<h3 align="center">◆◆◆ 회원가입 ◆◆◆</h3>
	<form name="join" method="post" action="join_action.jsp" 
		onsubmit="return inputCheck(join);">
		<table bgcolor="black" cellspacing="1" cellpadding="5" align="center">
		<tr>
			<th bgcolor="44ff44"><font size="2">아이디</font></th>
			<td bgcolor="white" width="300">
				<input type="text" size="10" name="id" class="TXTFLD">
			</td>
		</tr>
		<tr>
			<th bgcolor="44ff44"><font size="2">비밀번호</font></th>
			<td bgcolor="white" width="300">
				<input type="password" size="10" name="pass" class="TXTFLD">
			</td>
		</tr>
		<tr>
			<th bgcolor="44ff44"><font size="2">비밀번호확인</font></th>
			<td bgcolor="white" width="300">
				<input type="password" size="10" name="repass" class="TXTFLD">
			</td>
		</tr>
		<tr>
			<th bgcolor="44ff44"><font size="2">이름</font></th>
			<td bgcolor="white" width="300">
				<input type="text" size="10" name="name" class="TXTFLD">
			</td>
		</tr>
		<tr>
			<th bgcolor="44ff44"><font size="2">주소</font></th>
			<td bgcolor="white" width="300">
				<input type="text" size="30" name="addr" class="TXTFLD">
			</td>
		</tr>
		<tr>
			<th bgcolor="44ff44"><font size="2">성별</font></th>
			<td bgcolor="white" width="300">
				<input type="radio" name="gender" value="남자" checked><font size="2">남자</font>
				<input type="radio" name="gender" value="여자"><font size="2">여자</font>
			</td>
		</tr>
		<tr>
			<th bgcolor="44ff44"><font size="2">직업</font></th>
			<td bgcolor="white" width="300">
				<select name="job">
					<option value="학생">학생</option>
					<option value="주부">주부</option>
					<option value="회사원">회사원</option>
					<option value="기타">기타</option>
				</select>
			</td>
		</tr>
		<tr>
			<th bgcolor="44ff44"><font size="2">취미</font></th>
			<td bgcolor="white" width="300">
				<input type="checkbox" name="hobby" value="게임" checked><font size="2">게임</font>
				<input type="checkbox" name="hobby" value="등산"><font size="2">등산</font>
				<input type="checkbox" name="hobby" value="낚시"><font size="2">낚시</font>
				<input type="checkbox" name="hobby" value="운동"><font size="2">운동</font>
				<input type="checkbox" name="hobby" value="기타"><font size="2">기타</font>
			</td>
		</tr>
		<tr>
			<th bgcolor="44ff44"><font size="2">자기소개</font></th>
			<td bgcolor="white" width="300">
				<textarea rows="5" cols="40" name="profile"></textarea>
			</td>
		</tr>		
		<tr>
			<th colspan="2" bgcolor="ff8888">
				<input type="submit" value="가입">
				<input type="reset" value="취소">
			</th>
		</tr>
		</table>
	</form>
	<%-- 표현식(Expression)으로 변수값 출력 시 변수에 null이 저장된 경우 null 문자열로 변환되어 출력 --%>
	<p align="center" style="color: red;"><%=message %></p>
</body>
</html>