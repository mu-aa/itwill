package xyz.itwill10.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xyz.itwill10.dto.Member;

@Controller
public class LoginController {
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "login_form";
	}
	
	//전달값을 제공받아 인증 처리 후 권한 관련 정보를 Session Scope 속성값으로 저장하고
	//로그인 성공 메세지를 출력하는 JSP 문서의 ViewName을 반환하는 요청 처리 메소드
	//ㄴ 전달값을 매개변수에 하나씩 제공받아 사용 가능
	//ㄴ Session Scope 속성값을 저장하기 위한 매개변수를 이용하여 HttpSession 객체를 제공받아 사용
	/*
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam String id, @RequestParam String passwd
			, HttpSession session, Model model) {
		if(!id.equals("abc123") || !passwd.equals("123456")) { //인증 실패
			//에러 관련 정보를 Request Scope 속성값으로 저장
			//Request Scope : 현재 실행중인 요청 처리 메소드와 포워드 이동한 View에서만 속성값을 제공받아 사용
			model.addAttribute("message", "아이디 또는 비밀번호가 올바르지 않습니다.");
			model.addAttribute("id", id);
			return "login_form"; //입력페이지로 이동
		}
		
		//인증 성공 - 권한 관련 정보를 Session Scope 속성값으로 저장
		//Session Scope : 동일한 세션을 사용하는 모든 요청 처리 메소드와 View에서 속성값을 제공받아 사용
		session.setAttribute("loginId", id); //Session Scope
		
		return "login_display";
	} */
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute Member member, HttpSession session, Model model) {
		if(!member.getId().equals("abc123") || !member.getPasswd().equals("123456")) { //인증 실패
			model.addAttribute("message", "아이디 또는 비밀번호가 올바르지 않습니다.");
			return "login_form"; //입력페이지로 이동
		}
		
		//인증 성공 - 권한 관련 정보를 Session Scope 속성값으로 저장
		//Session Scope : 동일한 세션을 사용하는 모든 요청 처리 메소드와 View에서 속성값을 제공받아 사용
		session.setAttribute("loginId", member.getId()); //Session Scope
		
		return "login_display";
	}
}