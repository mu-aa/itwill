<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- member_xml_two.jsp 문서를 AJAX 기능으로 요청하여 회원정보를 XML 형식의 문서로 응답 받아 
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
	new xyz.itwill.Ajax("get", "member_xml_two.jsp", null, function(xhr) {
		if(xhr.readyState==4) {
			if(xhr.status==200) {
				var xmlDoc=xhr.responseXML;
				
				//code Element의 값을 반환받아 저장
				var code=xmlDoc.getElementsByTagName("code").item(0).firstChild.nodeValue;
				//log("code = "+code); //값 확인
				
				if(code=="success") {
					var memberList=xmlDoc.getElementsByTagName("member");
					for(i=0;i<memberList.length;i++){
						var member=memberList.item(i);
						var id=member.getElementsByTagName("id").item(0).firstChild.nodeValue;
						var name=member.getElementsByTagName("name").item(0).firstChild.nodeValue;
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