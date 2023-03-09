<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- member_xmljson_two.jsp 문서를 AJAX 기능으로 요청하여 회원목록을 XML, JSON 형식의 문서로 응답 받아
태그로 변경하여 클라이언트에게 전달하는 JSP 문서 --%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ajax.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/log.js"></script>
</head>
<body>
	<h1>회원목록</h1>
	<hr>
	<div id="log"></div>
	
	<script type="text/javascript">
	new xyz.itwill.Ajax("get", "member_xmljson_two.jsp", null, function(xhr) {
		if(xhr.readyState==4) {
			if(xhr.status==200) {
				var xmlDoc=xhr.responseXML;
				
				var code=xmlDoc.getElementsByTagName("code").item(0).firstChild.nodeValue;
				
				if(code=="success") {
					var data=xmlDoc.getElementsByTagName("data").item(0).firstChild.nodeValue; //xml로 가져오고
					
					var memberList=JSON.parse(data); //json으로 parsing
					
					for(i=0;i<memberList.length;i++) {
						var id=memberList[i].id;
						var name=memberList[i].name;
						log("[ID] = "+id+" / [NAME] = "+name);
					}
				} else {
					log("검색된 회원정보가 없습니다.");
				}
			} else {
				log("에러코드 = "+xhr.status);
			}
		}
	});
	</script>
</body>
</html>