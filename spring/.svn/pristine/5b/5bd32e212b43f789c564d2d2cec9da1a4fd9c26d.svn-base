package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//TilesView : 요청 처리 메소드의 반환값(ViewName)을 제공받아 다수의 JSP 문서를 합쳐
//하나의 JSP 문서(템플릿 페이지)로 응답하기 위한 기능을 제공하는 View 프로그램 - ViewResolver
//●1. TilesView 관련 라이브러리(tiles-extras)를 프로젝트에 build 처리 - maven : pom.xml
//●2. 요청 처리 메소드의 반환값(ViewName)을 제공받아 응답할 템플릿 페이지 설정
//ㄴ TilesView 환경설정 파일(XML)을 작성하여 설정 - /WEB-INF/spring/appServlet/tiles.xml (WEB-INF 하위 디렉토리)
//●3. Front Controller가 요청 처리 메소드의 반환값(ViewName)을 제공받아 TilesView를 이용하여
//응답되도록 Spring Bean Configuration File 설정 - servlet-context.xml
//ㄴ 기존의 ViewName을 JSP 문서로 변환하여 응답한 InternalResourceViewResolver 먼저 실행되도록 설정
@Controller
public class TilesController {
	@RequestMapping("/")
	public String tiles() {
		return "main";
	}
	
	@RequestMapping("/tiles1")
	public String tilesOne() {
		return "tiles/view";
	}
	
	@RequestMapping("/tiles2")
	public String tilesTwo() {
		return "tiles/sub/view";
	}
	
	@RequestMapping("/mgr")
	public String tilesAdmin() {
		return "admin";
	}
	
	@RequestMapping("/mgr_member")
	public String tilesMember() {
		return "admin/member";
	}
}