<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style type="text/css">
#btnDiv {
	margin: 10px;
}

#restBoardTable {
	border: 1px solid black;
	border-collapse: collapse; 
}

#restBoardTable td, #restBoardTable th {
	border: 1px solid black;
	padding: 3px;
}

.inputDiv {
	width: 240px;
	height: 80px;
	border: 2px solid black;
	background-color: gray;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-top: -40px;
	margin-left: -120px;
	padding: 5px;
	z-index: 100;
	display: none;
}
</style>
</head>
<body>
	<h1>RestBoard</h1>
	<hr>
	<div id="btnDiv">
		<button type="button" id="writeBtn">글쓰기</button>
	</div>
	
	<%-- 게시글 목록을 출력하는 태그 --%>
	<div id="restBoardListDiv"></div>

	<%-- 페이지 번호를 출력하는 태그 --%>
	<div id="pageNumDiv"></div>
	
	<%-- 신규 게시글을 입력받기 위한 태그 --%>
	<div id="insertDiv" class="inputDiv">
		<table>
			<tr>
				<td>작성자</td>
				<td><input type="text" id="insertWriter" class="insert"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" id="insertContent" class="insert"></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" id="insertBtn">저장</button>
					<button type="button" id="cancelInsertBtn">취소</button>
				</td>
			</tr>
		</table>
	</div>
	
	<%-- 변경 게시글을 입력받기 위한 태그 --%>
	<div id="updateDiv" class="inputDiv">
		<input type="hidden" id="updateNum">
		<table>
			<tr>
				<td>작성자</td>
				<td><input type="text" id="updateWriter" class="update"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" id="updateContent" class="update"></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" id="updateBtn">변경</button>
					<button type="button" id="cancelUpdateBtn">취소</button>
				</td>
			</tr>
		</table>
	</div>
	
	<script type="text/javascript">
	//현재 요청 페이지의 번호를 저장하기 위한 전역변수
	//ㄴ 모든 함수에서 사용 가능하며 프로그램 종료 전까지 값을 유지
	var page=1;
	
	//특정 페이지의 게시글 목록을 출력하는 함수 호출
	boardListDisplay(page);
	
	//RESTBOARD 테이블에 저장된 게시글 목록을 페이징 처리하여 검색하고 처리결과를 JSON 형식의 데이터로
	//응답하는 페이지를 AJAX 기능으로 요청
	//ㄴ 응답받은 JSON 형식의 데이터로 게시글 목록 출력 태그를 변경
	function boardListDisplay(pageNum) {
		page=pageNum;
		$.ajax({
			type: "get",
			url: "${pageContext.request.contextPath}/board_list?pageNum="+pageNum,
			dataType: "json",
			success: function(result) {
				//alert(result);//[object Object] >> 자바스크립트 Object 객체
				
				//매개변수로 제공받은 자바스크립트 객체를 HTML로 변경하여 게시글 목록 출력 태그 변경
				if(result.restBoardList.length==0) {//검색된 게시글이 없는 경우
					var html="<table id='restBoardTable'>";
					html+="<tr>";
					html+="<th width='800' colspan='6'>검색된 게시글이 없습니다.</th>";
					html+="</tr>";
					html+="</table>";
					$("#restBoardListDiv").html(html);
					return;
				}
				
				var html="<table id='restBoardTable'>";
				html+="<tr>";
				html+="<th width='50'>번호</th>";
				html+="<th width='100'>작성자</th>";
				html+="<th width='350'>내용</th>";
				html+="<th width='200'>작성일</th>";
				html+="<th width='50'>변경</th>";
				html+="<th width='50'>삭제</th>";
				html+="</tr>";
				$(result.restBoardList).each(function() {//게시글 목록을 반복 처리
					html+="<tr>";
					html+="<td align='center'>"+this.num+"</td>";
					html+="<td align='center'>"+this.writer+"</td>";
					html+="<td>"+this.content+"</td>";
					html+="<td align='center'>"+this.regdate+"</td>";
					html+="<td align='center'><button type='button' onclick='modify("+this.num+");'>변경</button></td>";
					html+="<td align='center'><button type='button' onclick='remove("+this.num+");'>삭제</button></td>";
					html+="</tr>";
				});
				html+="</table>";
				
				$("#restBoardListDiv").html(html);
				
				//페이지 번호를 출력하는 함수 호출
				pageNumDisplay(result.pager)
			},
			error: function(xhr) {
				alert("에러코드(게시글 목록 검색) = "+xhr.status)
			}
		});
	}
	
	//페이지 번호를 출력하는 태그를 변경하는 함수 - 페이지 번호 출력
	function pageNumDisplay(pager) {
		var html="";
		
		if(pager.startPage > pager.blockSize) {
			html+="<a href='javascript:boardListDisplay("+pager.prevPage+")'>[이전]</a>";
		}
		
		for(i=pager.startPage;i<=pager.endPage;i++) {
			if(pager.pageNum!=i) {
				html+="<a href='javascript:boardListDisplay("+i+")'>["+i+"]</a>";
			} else {
				html+="["+i+"]";
			}
		}
		
		if(pager.endPage!=pager.totalPage) {
			html+="<a href='javascript:boardListDisplay("+pager.nextPage+")'>[다음]</a>";
		}
		
		$("#pageNumDiv").html(html);
	}
	
	//[글쓰기] 태그를 클릭한 경우 호출되는 이벤트 처리 함수
	$("#writeBtn").click(function() {
		//변경 게시글을 입력받기 위한 태그 초기화
		$(".update").val(""); //입력태그 초기화
		$("#updateDiv").hide(); //태그 숨김
		
		//신규 게시글을 입력받기 위한 태그 출력
		$("#insertDiv").show();
	});
		
	//신규 게시글을 입력받기 위한 태그에서 [저장] 태그를 클릭한 경우 호출되는 이벤트 처리 함수
	//ㄴ 사용자 입력값을 얻어와 RESTBOARD 테이블에 삽입하는 페이지를 AJAX 기능으로 요청하여
	//처리결과를 제공받아 응답 처리 
	$("#insertBtn").click(function(){
		var writer=$("#insertWriter").val();
		var content=$("#insertContent").val();
		
		if(writer=="") {
			alert("작성자를 입력해 주세요.");
			return;
		}
	
		if(content=="") {
			alert("내용을 입력해 주세요.");
			return;
		}
		
		$.ajax({
			type: "post",
			url: "${pageContext.request.contextPath}/board_add",
			//headers : 요청정보가 저장된 Request Message의 Header를 변경하기 위한 속성
			//ㄴ Request Message의 Header에서 Body에 저장된 전달값에 대한 문서형식(MimeType)을 변경
			//headers: {"contentType": "application/json"},
			//contentType : Request Message의 Body에 저장된 전달값에 대한 문서형식을 변경하기 위한 속성
			//ㄴ Request Message의 Body에 저장된 전달값을 JSON 형식의 텍스트 데이터로 전달
			//ㄴ 요청 처리 메소드의 매개변수에서 @RequestBody Annotation을 사용하여 전달값을
			//Java 객체로 제공받아 사용 - 전달값은 Java 객체의 필드값으로 저장
			contentType: "application/json",
			//JSON.stringify(object) : JavaScript 객체를 전달받아 JSON 형식의 텍스트 데이터로 전달
			data: JSON.stringify({"writer":writer, "content":content}),
			dataType: "text",
			success: function(result) {
				if(result=="success") {
					//신규 게시글을 입력받기 위한 태그 초기화
					$(".insert").val("");//입력태그 초기화
					$("#insertDiv").hide();//태그 숨김
					
					//특정 페이지 번호의 게시글 목록을 출력하는 함수 호출
					boardListDisplay(page);
				}
			},
			error: function(xhr) {
				alert("에러코드(게시글삽입) = "+xhr.status)
			}
		});
	});
	
	//신규 게시글을 입력받기 위한 태그에서 [취소] 태그를 클릭한 경우 호출되는 이벤트 처리 함수
	$("#cancelInsertBtn").click(function() {
		//신규 게시글을 입력받기 위한 태그 초기화
		$(".insert").val("");//입력태그 초기화
		$("#insertDiv").hide();//태그 숨김
	});
	
	//게시글의 [변경] 태그를 클릭한 경우 호출되는 이벤트 처리 함수
	//ㄴ 글번호를 전달받아 RESTBOARD 테이블에 저장된 해당 글번호의 게시글을 검색하여 반환하는
	//페이지를 AJAX 기능으로 요청하여 처리결과를 JSON 형식의 데이터로 응답받아 변경 게시글을
	//입력받기 위한 태그의 입력값으로 초기화 처리
	function modify(num) {
		//신규 게시글을 입력받기 위한 태그 초기화
		$(".insert").val("");//입력태그 초기화
		$("#insertDiv").hide();//태그 숨김
		
		//변경 게시글을 입력받기 위한 태그 출력
		$("#updateDiv").show();
		
		$.ajax({
			type: "get",
			//페이지 요청 시 QueryString을 사용하여 값 전달
			//ㄴ 요청 처리 메소드의 매개변수에 @RequestParam Annotation을 사용하여 값을 제공받아 사용
			url: "${pageContext.request.contextPath}/board_view?num="+num,
			dataType: "json",
			success: function(result) {
				$("#updateNum").val(result.num);
				$("#updateWriter").val(result.writer);
				$("#updateContent").val(result.content);
			},
			error: function(xhr) {
				alert("에러코드(게시글삽입) = "+xhr.status)
			}
		});
	}
	
	//변경 게시글을 입력받기 위한 태그에서 [변경] 태그를 클릭한 경우 호출되는 이벤트 처리 함수
	//ㄴ 사용자 입력값을 얻어와 RESTBOARD 테이블에 저장된 게시글을 변경하는 페이지를 AJAX 기능으로 요청하여
	//처리결과를 제공받아 응답 처리 
	$("#updateBtn").click(function(){
		var num=$("#updateNum").val();
		var writer=$("#updateWriter").val();
		var content=$("#updateContent").val();
		
		if(writer=="") {
			alert("작성자를 입력해 주세요.");
			return;
		}
	
		if(content=="") {
			alert("내용을 입력해 주세요.");
			return;
		}
		
		$.ajax({
			type: "put",
			url: "${pageContext.request.contextPath}/board_modify",
			contentType: "application/json",
			data: JSON.stringify({"num":num, "writer":writer, "content":content}),
			dataType: "text",
			success: function(result) {
				if(result=="success") {
					$(".update").val("");//입력태그 초기화
					$("#updateDiv").hide();//태그 숨김
					
					//특정 페이지 번호의 게시글 목록을 출력하는 함수 호출
					boardListDisplay(page);
				}
			},
			error: function(xhr) {
				alert("에러코드(게시글변경) = "+xhr.status);
			}
		});
	});
	
	//변경 게시글을 입력받기 위한 태그에서 [취소] 태그를 클릭한 경우 호출되는 이벤트 처리 함수
	$("#cancelUpdateBtn").click(function(){
		$(".update").val("");
		$("#updateDiv").hide();
	});
	
	//게시글의 [삭제] 태그를 클릭한 경우 호출되는 이벤트 처리 함수
	//ㄴ 글번호를 전달받아 RESTBOARD 테이블에 저장된 해당 글번호의 게시글을 삭제하는 페이지를
	//AJAX 기능으로 요청하여 처리결과를 일반 텍스트로 제공받아 응답 처리
	function remove(num) {
		if(confirm("게시글을 삭제하시겠습니까?")) {
			$.ajax({
				type: "delete",
				//★페이지 요청 시 요청 URL 주소를 사용하여 값 전달
				//ㄴ 요청 처리 메소드의 매개변수에 @PathVariable Annotation을 사용하여 값 제공
				url: "${pageContext.request.contextPath}/board_remove/"+num,
				dataType: "text",
				success: function(result) {
					if(result=="success") {
						//특정 페이지 번호의 게시글 목록을 출력하는 함수 호출
						boardListDisplay(page);
					}
				},
				error: function(xhr) {
					alert("에러코드(게시글삭제) = "+xhr.status);
				}
			});
		}
	}
	</script>
</body>
</html>