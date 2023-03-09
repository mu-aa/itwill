<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//스레드가 이동된 JSP 문서(footer.jsp)는 클라이언트의 요청 JSP 문서(index.jsp)의
	//request 객체와 response 객체를 제공받아 사용
	//ㄴ 스레드가 이동된 JSP 문서에서는 request 객체와 response 객체의 사용 제한 발생
	
	//스레드가 이동된 JSP 문서에서는 request 객체에 대한 리퀘스트 메세지 관련 정보 변경 불가능
	//ㄴ request.setCharacterEncoding() 메소드를 호출하여 리퀘스트 Body에 저장되어 전달되는
	//값에 대한 Charset 변경 불가능
	//해결법) 클라이언트의 요청 JSP 문서에서 리퀘스트 Body에 저장되어 전달되는 값에 대한 Charset 변경
	//request.setCharacterEncoding("utf-8");

	String masterName=request.getParameter("masterName");
	
	if(masterName==null) {
		//문제점) 스레드가 이동된 JSP 문서에서는 response 객체를 이용하여 클라이언트에게
		//에러코드나 URL 주소를 전달 불가능
		//ㄴ 스레드가 이동된 JSP 문서는 결과를 클라이언트가 아닌 요청 JSP 문서에 전달하므로
		//에러코드(sendError) 또는 URL 주소(Redirect) 전달은 무의미
		//해결법) 자바스크립트를 이용해 응답처리하여 페이지 이동 가능
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}
%>
<hr>
<p>Copyright ⓒitwill Corp. All rights reserved.</p>
<p>관리자 : <%=masterName %></p>-%>