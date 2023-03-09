package xyz.itwill10.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JoinController {
	@RequestMapping(value="join", method=RequestMethod.GET)
	public String join() {
		return "join_form";
	}
	
	//전달값을 제공받아 Request Scope 속성값으로 저장하고 속성값을 출력하기 위한
	//JSP 문서의 ViewName을 반환하는 요청 처리 메소드
	//ㄴ @RequestParam Annotation을 사용하여 매개변수와 같은 이름으로 전달되는 값이 없는 경우 400 에러 발생
	/*
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(@RequestParam String id, @RequestParam String passwd
			, @RequestParam String name, @RequestParam String email, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("passwd", passwd);
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		
		return "join_display";
	} */
	
	//전달값을 제공받아 Request Scope 속성값으로 저장하고 속성값을 출력하기 위한
	//JSP 문서의 ViewName을 반환하는 요청 처리 메소드
	//ㄴ 전달값과 같은 이름의 매개변수에 전달값을 제공받아 요청 처리 메소드에서 사용
	//ㄴ @ModelAttribute Annotation을 사용하여 매개변수에 저장된 값을 속성값으로 저장하여 View에게 제공
	//@ModelAttribute : 객체(값)를 View에게 제공하기 위한 Annotation
	//ㄴ 메소드에 @ModelAttribute Annotation을 사용하면 메소드의 반환값을 요청 처리 클래스의
	//모든 요청 처리 메소드의 View에게 제공
	//ㄴ 매개변수에 @ModelAttribute Annotation을 사용하면 매개변수에 저장된 값을 요청 처리 메소드의 View에게 제공
	//value 속성 : View에서 속성값을 사용하기 위한 속성명을 속성값으로 설정
	//ㄴ 다른 속성이 없는 경우 속성값만 설정 가능
	//@ModelAttribute Annotation을 사용하면 매개변수와 같은 이름의 전달값이 없어도 400 에러코드 미발생
	/*
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(@ModelAttribute("id") String id, @ModelAttribute("passwd") String passwd
			, @ModelAttribute("name") String name, @ModelAttribute("email") String email) {
		return "join_display";
	} */
	
	//★전달값을 매개변수로 제공받아 객체의 필드값으로 저장하고 객체를 Request Scope 속성값으로
	//저장하고 속성값을 출력하기 위한 View의 ViewName을 반환하는 요청 처리 메소드
	/*
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(@RequestParam String id, @RequestParam String passwd
			, @RequestParam String name, @RequestParam String email, Model model) {
		Member member=new Member();
		member.setId(id);
		member.setPasswd(passwd);
		member.setName(name);
		member.setEmail(email);
		
		//model.addAttribute("member", member);
		//Model.addAttribute(Object attributeValue) : Model 객체에 속성명과 속성값(객체)을
		//저장하기 위한 메소드 - Request Scope
		//ㄴ 속성값의 자료형(클래스)을 속성명으로 자동 설정
		//ㄴ 속성값으로 원시값(Wrapper 객체) 또는 String 객체 저장 불가
		model.addAttribute(member);
		
		return "join_display";
	} */
	
	//★★요청 페이지에 전달값이 있는 경우 요청 처리 메소드의 매개변수 자료형을 VO(DTO) 클래스로 작성하면
	//Front Controller는 VO(DTO) 클래스를 객체로 생성하여 매개변수에 전달하여 저장
	//ㄴ VO 클래스의 객체는 전달값의 이름과 같은 이름의 필드에 전달값을 제공받아 저장
	//Command 객체 : 전달값을 제공받아 필드에 저장된 객체로 속성값으로 저장하여 요청 처리 메소드의
	//View에서 사용될 수 있도록 제공
	//ㄴ @ModelAttribute Annotation을 사용하여 객체를 속성값으로 저장해 View에게 제공
	//ㄴ @ModelAttribute Annotation 생략 가능 - 생략 비권장
	//ㄴ value 속성을 생략하면 Command 객체의 자료형(클래스)이 속성명으로 자동 설정
	/*
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(@ModelAttribute Member member) {
		return "join_display";
	}
	*/
	
	/*
	//@ModelAttribute Annotation의 value 속성을 사용하여 View에게 제공될 속성값의 속성명 변경
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(@ModelAttribute(value="mem") Member member, Model model) {
		if(member.getId().equals("abc123")) { //아이디가 중복된 경우
			model.addAttribute("message", "아이디가 이미 사용중입니다.");
			return "join_form"; //입력페이지 이동
		}
		
		return "join_display";
	}*/
	
	//★★요청 페이지에 전달값이 있는 경우 요청 처리 메소드의 매개변수 자료형을 Map 인터페이스로 작성하면
	//Front Controller는 Map 객체를 생성하여 매개변수에 전달하여 저장
	//ㄴ 모든 전달값을 Map 객체의 Entry로 추가하여 매개변수로 제공
	//ㄴ Map 객체의 Entry에는 전달값의 이름을 맵키(MapKey - String)로 하여 전달값을 맵값(MapValue - String)으로
	//제공받아 추가
	//ㄴ Map 인터페이스로 작성된 매개변수에는 반드시 @RequestParam Annotation을 사용해야만 Map 객체로
	//전달값을 맵값으로 제공받아 사용 가능
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(@RequestParam Map<String, Object> map, Model model) {
		model.addAttribute("mem", map);
		return "join_display";
	}
}