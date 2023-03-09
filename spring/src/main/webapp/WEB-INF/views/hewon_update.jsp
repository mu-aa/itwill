<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
</head>
<body>
	<h1>회원정보변경</h1>
	<hr>
	<form action="hewon_update" method="post">
		<!-- 회원정보를 변경하기 위해 hidden 타입의 입력태그로 아이디를 전달 -->
		<!-- ㄴ 아이디 입력태그의 초기값으로 설정하여 read-only 속성을 사용하여 전달 가능 -->
		<%-- @SessionAttributes Annotation을 사용한 경우 아이디를 전달하지 않아도 회원정보 변경 페이지의
		요청 처리 메소드에서 회원정보를 제공받아 사용 가능 --%>
		<%-- <input type="hidden" name="id" value="${hewon.id }"> --%>
		<table>
			<tr>
				<td>아이디</td>
				<td>${hewon.id }</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="${hewon.name }"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" value="${hewon.email }"></td>
			</tr>
			<tr>
				<td colspan="2"><button type="submit">회원정보변경</button></td>
			</tr>
		</table>
	</form>
</body>
</html>