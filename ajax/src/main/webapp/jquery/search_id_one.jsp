<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 사용자로부터 이름과 이메일을 입력받아 해당 이름과 이메일을 사용하는 회원의 아이디를
클라이언트에게 전달하는 JSP 문서 --%>
<%-- ㄴ search_id_two.jsp 문서를 AJAX 기능으로 요청하여 처리결과를 XML 문서로 응답받아
아이디가 출력되도록 프로그램 작성 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
</head>
<body>
	<h1>아이디 찾기</h1>
	<hr>
	<table>
		<tr>
			<td>이름</td>
			<td><input type="text" id="name"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" id="email"></td>
		</tr>
		<tr>
			<td colspan="2"><button type="button" id="btn">아이디 찾기</button></td>
		</tr>
	</table>
	<hr>
	<div id="result"><%-- 출력 결과) 홍길동님의 아이디는 [abc123] 입니다. --%></div>
	
	<script type="text/javascript">
	$("#btn").click(function() {
		var name=$("#name").val();
		if(name=="") {
			$("#result").html("이름을 입력해주세요.");
			$("#name").focus();
			return;
		}
		
		var email=$("#email").val();
		if(name=="") {
			$("#result").html("이메일을 입력해주세요.");
			$("#email").focus();
			return;
		}
		
		$("#name").val(""); //초기화
		$("#email").val(""); //초기화
		
		$.ajax({
			type: "post",
			url: "search_id_two.jsp",
			//전달값을 Object 객체 형식으로 표현하여 전달 가능
			data: {"name":name, "email":email},
			dataType: "xml",
			success: function(xmlDoc) {
				var code=$(xmlDoc).find("code").text();
				
				if(code=="ok") {
					var id=$(xmlDoc).find("id").text();
					$("#result").html(name+"님의 아이디는 ["+id+"] 입니다.");
				} else {
					$("#result").html(name+"님의 아이디가 존재하지 않습니다.");
				}
			},
			error: function(xhr) {
				alert("에러코드 = "+xhr.status);
			}
		});
	});
	</script>
</body>
</html>