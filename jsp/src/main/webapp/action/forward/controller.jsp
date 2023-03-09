<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달값에 따라 서로 다른 JSP 문서의 응답결과를 클라이언트에게 전달되도록 스레드를 이동하는 JSP 문서
- 프로그램의 흐름을 제어하는 기능 --%>
<%
	//전달값을 반환받아 저장
	String category=request.getParameter("category");

	if(category==null) {
		//클라이언트에게 URL 주소가 전달되도록 응답 처리
		//ㄴ URL 주소를 전달받은 클라이언트는 브라우저의 URL 주소를 변경하여 서버의 자원을
		//요청하여 결과를 응답 받아 출력 - 페이지 이동
		response.sendRedirect("main.jsp"); //리다이렉트 이동
		return;
	}
	
	//전달값을 이용하여 스레드가 이동될 JSP 문서의 파일 경로를 생성하여 저장
	String filePath=category+".jsp";
%>
<%-- forward Action Tag : JSP 문서에 page 속성값으로 설정된 JSP 문서로 스레드를 이동하여 명령을
실행하고 처리결과를 클라이언트에게 전달하여 응답하기 위한 태그 --%>
<%-- 형식) <jsp:forward page="JSP"></jsp:forward include> 또는 <jsp:forward page="JSP"/> --%>
<%-- ㄴ page 속성값으로 JSP 표현식(Expression) 사용 가능 --%>
<%-- 포워드 이동 : 요청 JSP 문서에서 응답 JSP 문서로 스레드를 이동하여 응답 처리 --%>
<jsp:forward page="<%=filePath %>"/>