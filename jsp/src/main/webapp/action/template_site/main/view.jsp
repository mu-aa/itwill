<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>메인 페이지</h1>

<%-- 상대경로 : 클라이언트의 요청 JSP 문서의 경로를 기준으로 다른 자원의 경로 표현 --%>
<%-- 문제점) 템플릿 페이지(index.jsp)가 아닌 스레드가 이동된 JSP 문서를 요청한 경우
해당 자원을 찾을 수 없어 404 에러코드 발생 --%>
<%-- ㄴ 요청하는 JSP 문서와 응답 결과를 제공하는 JSP 문서의 경로가 다른 경우 문제 발생 --%>
<%-- 해결법) JSP 문서에서 필요한 자원을 표현할 경우 절대경로로 표현하는 것을 권장 --%>
<%-- <img src="images/moon.png" width="300"> --%>

<%-- 절대 경로 : 최상위 디렉토리를 기준으로 자원의 경로 표현 --%>
<%-- ㄴ CSL(HTML, CSS, JavaScript)은 ServerRoot 디렉토리를 최상위 디렉토리로 표현하여 사용 --%>
<%-- ㄴ SSL(Java)은 ContextRoot 디렉토리를 최상위 디렉토리로 표현하여 사용 --%>
<%-- 문제점) 웹자원이 저장된 ContextRoot 디렉토리의 경로가 변경될 경우 해당 자원을 찾을 수 없어 404 에러코드 발생 가능 --%>
<%-- 해결법) 메소드를 호출하여 Context 디렉토리의 경로를 반환받아 절대경로로 표현하는 것을 권장 --%>
<%-- request.getContextPath() : 요청 JSP 문서가 위치한 ContextRoot 디렉토리의 경로를 반환하는 메소드 --%>
<img src="<%=request.getContextPath() %>/action/template_site/images/moon.png" width="300">