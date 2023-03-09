package xyz.itwill09.mvc;

//응답 관련 정보를 제공하기 위한 클래스
public class ViewResolver {
	//JSP 문서의 이름(ViewName)을 전달받아 JSP 문서의 경로를 완성하여 반환하는 메소드
	public String getView(String viewName) {
		return "/WEB-INF/mvc/"+viewName+".jsp";
	}
}