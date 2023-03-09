<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 검색어를 입력받아 검색어가 포함된 제시어를 클라이언트에게 전달하는 JSP 문서 --%>
<%-- ㄴ 검색어가 입력될 경우 suggest_two.jsp 문서를 AJAX 기능으로 요청하여 검색어가 포함된
제시어 정보를 XML 문서로 응답받아 출력되도록 처리 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ajax.js"></script>
<style type="text/css">

#keyword {position: absolute; top: 100px; left: 10px; width: 300px; font-size: 16px;}
#suggest {position: absolute; top: 120px; left: 10px; width: 300px; border: 1px solid black; cursor: pointer; 
	font-size: 16px; z-index: 999; background: rgba(255,255,255,1); display: none;}
#choice {position: absolute; top: 150px; left: 10px;}

</style>
</head>
<body>
	<h1>제시어 기능</h1>
	<hr>
	<div>
		<%-- 검색어를 입력받기 위한 태그 --%>
		<input type="text" id="keyword">
		
		<%-- 제시어를 제공받아 출력하기 위한 태그 --%>
		<div id="suggest">
			<div id="suggestList">
				Java<br>
				Java 교재<br>
				Java 책<br>
			</div>
		</div>
		
		<%-- 선택된 제시어 관련 정보를 출력하기 위한 태그 --%>
		<div id="choice"></div>
	</div>
	
	<script type="text/javascript">
	document.getElementById("keyword").focus();
	
	document.getElementById("keyword").onkeyup=function() {
		var keyword=this.value;
		
		if(keyword=="") {
			document.getElementById("suggest").style="display: none;";
			return;
		}
		
		new xyz.itwill.Ajax("post", "suggest_two.jsp", "keyword="+keyword, function(xhr) {
			if(xhr.readyState==4) {
				if(xhr.status==200) {
					var xmlDoc=xhr.responseXML;
					
					var code=xmlDoc.getElementsByTagName("code").item(0).firstChild.nodeValue;
					
					if(code=="success") {
						var data=xmlDoc.getElementsByTagName("data").item(0).firstChild.nodeValue;
						
						var suggestList=JSON.parse(data);
						
						var html="";
						for(i=0;i<suggestList.length;i++) {
							html+="<a href=\"javascript:selectSuggest('"+suggestList[i].word
								+"','"+suggestList[i].url+"');\">"+suggestList[i].word+"</a><br>";
						}
						document.getElementById("suggestList").innerHTML=html;
						
						document.getElementById("suggest").style="display: block;";
					} else {
						document.getElementById("suggest").style="display: none;";
					}
				} else {
					alert("에러코드 = "+xhr.status);
				}
			}
		});
	}
	
	function selectSuggest(word, url) {
		document.getElementById("keyword").value=word; //입력태그의 입력값 변경
		document.getElementById("choice").innerHTML="<a href="+url+">"+word+"</a>" //태그 변경
		
		document.getElementById("suggest").style="display: none;";
	}
	</script>
</body>
</html>