<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- AJAX_COMMENT 테이블의 댓글정보에 대한 삽입,삭제,변경 기능을 제공하고 댓글 목록을 검색하여
클라이언트에게 전달하는 JSP 문서 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style type="text/css">
h1 {
	text-align: center;
}

.comment_table {
	width: 500px;
	margin: 0 auto;
	border: 2px solid #cccccc;
	border-collapse: collapse;
}

.title {
	width: 100px;
	padding: 5px 10px;
	text-align: center;
	border: 1px solid #cccccc;
}

.input {
	width: 400px;
	padding: 5px 10px;
	border: 1px solid #cccccc;
}

.btn {
	text-align: center;
	border: 1px solid #cccccc;
}

#comment_add {
	margin-bottom: 5px;
}

#comment_modify, #comment_remove {
	margin: 10px;
	display: none;	
}

#add_message, #modify_message {
	width: 500px;
	margin: 0 auto;
	margin-bottom: 20px;
	text-align: center;
	color: red;
}

#remove_message {
	padding: 3px;
	text-align: center;
	border: 1px solid #cccccc;
}

.comment {
	width: 550px;
	margin: 0 auto;
	margin-bottom: 5px;
	padding: 3px;
	border: 1px solid #cccccc;
}

.no_comment {
	width: 550px;
	margin: 0 auto;
	margin-bottom: 5px;
	border: 2px solid #cccccc;
	text-align: center;
}
</style>
</head>
<body>
	<h1>AJAX 댓글</h1>
	<hr>
	<%-- 댓글 등록 영역 --%>
	<div id="comment_add">
		<table class="comment_table">
			<tr>
				<td class="title">작성자</td>
				<td class="input"><input type="text" id="add_writer"></td> 
			</tr>
			<tr>
				<td class="title">댓글내용</td>
				<td class="input"><textarea rows="3" cols="50" id="add_content"></textarea></td> 
			</tr>
			<tr>
				<td class="btn" colspan="2">
					<button type="button" id="add_btn">댓글등록</button>
				</td>
			</tr>
		</table>
		<div id="add_message">&nbsp;</div>
	</div>
	
	<%-- 댓글목록 출력 영역 --%>
	<div id="comment_list"></div>
	
	<%-- 댓글 변경 영역 --%>
	<div id="comment_modify">
		<input type="hidden" id="modify_num" value="">
		<table class="comment_table">
			<tr>
				<td class="title">작성자</td>
				<td class="input"><input type="text" id="modify_writer"></td> 
			</tr>
			<tr>
				<td class="title">댓글내용</td>
				<td class="input"><textarea rows="3" cols="50" id="modify_content"></textarea></td> 
			</tr> 
			<tr>
				<td class="btn" colspan="2">
					<button type="button" id="modify_btn">변경</button>
					<button type="button" id="modify_cancel_btn">취소</button>
				</td>
			</tr>
		</table>
		<div id="modify_message">&nbsp;</div>
	</div>
	
	<%-- 댓글 삭제 영역 --%>
	<div id="comment_remove">
		<input type="hidden" id="remove_num" value="">
		<div id="remove_message">
			<b>정말로 삭제 하시겠습니까?</b>
			<button type="button" id="remove_btn">삭제</button>
			<button type="button" id="remove_cancel_btn">취소</button>
		</div>
	</div>
	
	<script type="text/javascript">
	displayComment();
	
	//comment_list.jsp 문서를 AJAX 기능으로 요청하여 댓글목록을 XML 문서로 응답받아 태그로 출력하는 함수
	function displayComment() {
		$.ajax({
			type: "get",
			url: "comment_list.jsp",
			dataType: "xml",
			success: function(xmlDoc) {
				//댓글목록 출력영역에 출력된 기존 댓글 목록 삭제 - 초기화
				$("#comment_list").children().remove();
				
				var code=$(xmlDoc).find("code").text();
				
				if(code=="success") {//검색된 댓글이 있는 경우
					//data 엘리먼트의 값(댓글목록 - JSON)을 반환받아 자바스크립트 객체로 변환
					var commentArray=JSON.parse($(xmlDoc).find("data").text());
					
					$(commentArray).each(function() {
						//Array 객체의 요소값(Object 객체 - 댓글정보)을 HTML 태그로 변환
						var html="<div class='comment' id='comment_"+this.num+"'>";
						html+="<b>["+this.writer+"]</b><br>";//작성자
						html+=this.content.replace(/\n/g, "<br>")+"<br>";//댓글내용
						html+="("+this.regdate+")<br>";//작성날짜
						html+="<button type='button' onclick='modifyComment("+this.num+");'>댓글변경</button>&nbsp;";//변경버튼
						html+="<button type='button' onclick='removeComment("+this.num+");'>댓글삭제</button>&nbsp;";//삭제버튼
						html+="</div>";

						//댓글목록 출력영역에 댓글정보를 마지막 자식태그로 추가하여 출력
						$("#comment_list").append(html);
					});
				} else {//검색된 댓글이 없는 경우
					var message=$(xmlDoc).find("message").text();
					$("#comment_list").html("<div class='no_comment'>"+message+"</div>");
				}
			},
			erorr: function(xhr) {
				alert("에러코드 = "+xhr.status);
			}
		});
	}
	
	//[댓글등록] 태그를 클릭한 경우 호출되는 이벤트 처리 함수 등록
	// => 입력태그의 입력값(댓글정보)을 반환받아 AJAX_COMMENT 테이블에 삽입하는 comment_add.jsp
	//문서를 AJAX 기능으로 요청하고 실행결과를 XML 문서로 응답받아 처리
	$("#add_btn").click(function() {
		var writer=$("#add_writer").val();
		if(writer=="") {
			$("#add_message").html("작성자를 입력해 주세요.");
			$("#add_writer").focus();
			return;
		}
		
		var content=$("#add_content").val();
		if(content=="") {
			$("#add_message").html("내용을 입력해 주세요.");
			$("#add_content").focus();
			return;
		}
		
		$("#add_writer").val("");
		$("#add_content").val("");
		$("#add_message").html("");
		
		$.ajax({
			type: "post",
			url: "comment_add.jsp",
			data: {"writer":writer, "content":content},
			dataType: "xml",
			success: function(xmlDoc) {
				var code=$(xmlDoc).find("code").text();
				
				if(code=="success") {
					displayComment();//댓글목록 출력
				} else {
					alert("댓글 삽입 실패");
				}
			},
			error: function(xhr) {
				alert("에러코드 = "+xhr.status);
			}
		});
	});
	
	//댓글변경태그와 댓글삭제태그를 초기화 처리하기 위한 함수
	function init() {
		//댓글변경태그를 숨기고 document 객체의 자식태그로 이동
		$("#comment_modify").hide().appendTo(document.documentElement);
		
		//댓글변경태그에서 입력태그 초기화
		$("#modify_num").val("");
		$("#modify_writer").val("");
		$("#modify_content").val("");
		//댓글변경태그에서 메세지 출력태그 초기화
		$("#modify_message").html("");
		
		//댓글삭제태그를 숨기고 document 객체의 자식태그로 이동
		$("#comment_remove").hide().appendTo(document.documentElement);
		
		//댓글삭제태그에서 입력태그 초기화
		$("#remove_num").val("");
	}
	
	//댓글 출력 태그에서 [댓글변경] 태그를 클릭한 경우 호출되는 이벤트 처리 함수
	// => comment_get.jsp 문서를 AJAX 기능으로 요청하여 변경할 댓글정보를 XML 문서로 응답받아 처리
	function modifyComment(num) {
		//alert(num);
		
		init();
		
		//댓글변경태그를 보여지도록 처리하고 변경할 댓글출력태그의 자식태그로 이동
		$("#comment_modify").show().appendTo("#comment_"+num);
		
		$.ajax({
			type: "get",
			url: "comment_get.jsp",
			data: {"num":num},
			dataType: "xml",
			success: function(xmlDoc) {
				var code=$(xmlDoc).find("code").text();
				
				if(code=="success") {
					var comment=JSON.parse($(xmlDoc).find("data").text());
					//댓글변경태그에서 입력태그의 입력값을 검색결과값으로 변경
					$("#modify_num").val(comment.num);
					$("#modify_writer").val(comment.writer);
					$("#modify_content").val(comment.content);
				} else {
					init();
				}
			},
			error: function(xhr) {
				alert("에러코드 = "+xhr.status);
			}
		});
	}
	
	//댓글변경태그에서 [변경] 태그를 클릭한 경우 호출되는 이벤트 처리 함수 등록
	//ㄴ 댓글변경태그에서 입력태그의 변경값을 반환받아 AJAX_COMMENT 테이블의 댓글정보를 변경하는
	//comment_modify.jsp 문서를 AJAX 기능으로 요청하고 실행결과를 XML 문서로 응답받아 처리
	$("#modify_btn").click(function() {
		var num=$("#modify_num").val();
		var writer=$("#modify_writer").val();
		if(writer==""){
			$("#modify_message").html("작성자를 입력해주세요.");
			$("#modify_writer").focus();
		}
		var content=$("#modify_content").val();
		if(content==""){
			$("#modify_message").html("내용을 입력해주세요.");
			$("#modify_content").focus();
		}
		
		$.ajax({
			type: "post",
			url: "comment_modify.jsp",
			data: {"num":num, "writer":writer, "content":content},
			dataType: "xml",
			success: function(xmlDoc) {
				var code=$(xmlDoc).find("code").text();
				
				if(code=="success") {
					displayComment();
					init();
				} else {
					alert("댓글 변경 실패");
				}
			},
			error: function(xhr) {
				alert("에러코드 = "+xhr.status);
			}
		});
	});
	
	//댓글변경태그에서 [취소] 태그를 클릭한 경우 호출되는 이벤트 처리 함수 등록
	//ㄴ 댓글변경태그와 댓글삭제태그를 초기화 처리하기 위한 함수(init) 호출
	$("#modify_cancel_btn").click(init);
	
	//댓글 출력태그에서 [댓글삭제] 태그를 클릭한 경우 호출되는 이벤트 처리 함수
	function removeComment(num) {
		init();
		
		//댓글삭제태그를 보여지도록 처리하고 변경할 댓글 출력태그의 자식태그로 이동
		$("#comment_remove").show().appendTo("#comment_"+num);
		
		//댓글삭제태그에서 입력태그에 댓글번호 저장
		$("#remove_num").val(num);
	}
	
	//댓글 삭제 태그에서 [삭제] 버튼을 클릭한 경우 호출되는 이벤트 처리 함수
	//ㄴ 댓글삭제태그에서 입력태그의 댓글번호를 반환받아 AJAX_COMMENT 테이블에 저장된 해당 댓글 번호의
	//댓글정보를 삭제하는 comment_remove.jsp 문서를 AJAX 기능으로 요청하고 실행결과를 XML 문서로 응답받아 처리
	$("#remove_btn").click(function(){
		var num=$("#remove_num").val();
		
		$.ajax({
			type: "get",
			url: "comment_remove.jsp",
			data: {"num":num},
			dataType: "xml",
			success: function(xmlDoc) {
				var code=$(xmlDoc).find("code").text();
				
				if(code=="success") {
					displayComment();
					init();
				} else {
					alert("댓글 삭제 실패");
				}
			},
			error: function(xhr) {
				alert("에러코드 = "+xhr.status);
			}
		});
	});
	
	//댓글 삭제 태그에서 [취소] 버튼을 클릭한 경우 호출되는 이벤트 처리 함수
	$("#remove_cancel_btn").click(init);
	</script>
</body>
</html>