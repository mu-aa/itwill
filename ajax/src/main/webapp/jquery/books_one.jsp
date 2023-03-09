<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- books_two.jsp 문서를 AJAX 기능으로 요청하여 처리결과를 XML 문서로 응답받아 태그내용을
변경하여 클라이언트에게 전달하는 JSP 문서 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
</head>
<body>
	<h1>jQuery AJAX</h1>
	<hr>
	<div id="bookList"></div>
	
	<script type="text/javascript">
	$.ajax({
		type: "get",
		url: "books_two.jsp",
		//요청 웹프로그램의 응답 결과의 문서 형식과 dataType 속성값이 일치하지 않을 경우 에러 발생
		dataType: "xml",
		success: function(xmlDoc) {
			//요청에 대한 응답 결과가 XML 문서인 경우 매개변수에 XMLDocument 객체 저장
			var count=$(xmlDoc).find("book").length; //XMLDocument 객체를 jQuery로 변환($), find 메소드로 "book" Element의 length 저장
			if(count==0){
				$("#bookList").html("<p>검색된 교재가 하나도 없습니다.</p>");
				return;
			}
			
			var html="<p>검색된 교재가 "+count+"권 있습니다.</p>";
			html+="<ol>";
			$(xmlDoc).find("book").each(function() { //each==반복문
				var title=$(this).find("title").text();
				var author=$(this).find("author").text();
				html+="<li><b>"+title+"</b>["+author+"]</li>";
			});
			
			$("#bookList").html(html); //출력
		},
		error: function(xhr) {
			alert("에러코드 = "+xhr.status);
		}
	}) 
	</script>
</body>
</html>