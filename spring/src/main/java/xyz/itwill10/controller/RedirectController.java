package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	@RequestMapping("/forward_move")
	public String forward(Model model) {
		//Model 객체를 이용하여 View에게 제공할 객체를 속성값으로 저장 - Request Scope
		model.addAttribute("name", "홍길동");
		
		//View를 생성하기 위한 ViewName 반환
		//ㄴ Front Controller는 제공받은 ViewName을 InternalResourceViewResolver 객체를
		//사용하여 JSP 문서로 변환하고 JSP 문서로 포워드 이동하여 응답처리
		//포워드 이동 : 서버 내부에서 현재 웹프로그램의 스레드를 다른 웹프로그램으로 이동하여 명령 실행
		//ㄴ 클라이언트의 요청 URL 주소 미변경, Request Scope 속성값을 객체로 제공받아 사용 가능
		return "display_forward";
	}
	
	/*
	@RequestMapping("/redirect_move")
	public String redirect(Model model) {
		model.addAttribute("name", "임꺽정");
		
		return "display_redirect";
	}
	
	@RequestMapping("/redirect")
	public String redirect() {
		//ViewName에 redirect: 접두사를 사용하여 URL 주소를 반환하면 Front Controller는
		//반환받은 ViewName의 URL 주소를 클라이언트에게 전달 - redirect 이동
		//ㄴ 클라이언트에게 URL 주소를 전달하여 응답 처리하면 클라이언트는 해당 URL 주소로
		//브라우저의 주소를 변경하여 서버에 페이지 요청 처리
		//redirect 이동 : 클라이언트에게 URL 주소를 전달하여 페이지를 재요청하여 웹프로그램의 명령 실행
		//ㄴ 클라이언트의 요청 URL 주소 변경, Request Scope 속성값 사용 불가
		return "redirect:/redirect_move";
	}
	*/
	
	@RequestMapping("/redirect_move")
	public String redirect() {
		return "display_redirect";
	}
	
	/*
	@RequestMapping("/redirect")
	public String redirect(Model model) {
		model.addAttribute("name", "임꺽정"); //Request Scope
		return "redirect:/redirect_move"; //redirect는 Request Scope 사용 불가
	} */
	
	//RedirectAttributes 객체 : redirect 이동되는 페이지의 요청 처리 메소드와 View에게 속성값을
	//저장하여 사용하기 위한 기능을 제공하는 객체
	@RequestMapping("/redirect")
	public String redirect(RedirectAttributes attributes) {
		//RedirectAttributes.addFlashAttribute(String attributeName, Object attributeValue)
		//ㄴ 속성명과 속성값을 저장하여 redirect 이동되는 페이지의 요청 처리 메소드와
		//View에게 속성값을 제공하기 위한 메소드 - Request Scope
		attributes.addFlashAttribute("name", "임꺽정");
		return "redirect:/redirect_move";
	}
}