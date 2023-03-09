package xyz.itwill10.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//요청 처리 메소드에 의해 처리된 결과를 View(JSP 문서)에 제공하는 방법
//1. ModelAndView 객체에 처리결과를 속성값으로 저장하여 제공
//2. HttpServletRequest 객체에 처리결과를 속성값으로 저장하여 제공
//★3. Model 객체에 처리결과를 속성값으로 저장하여 제공

@Controller
public class ResultController {
	/*
	@RequestMapping("/resultMAV")
	public ModelAndView modelAndViewResult() {
		ModelAndView modelAndView=new ModelAndView("result_display");
		//ModelAndView.addObject(String attributeName, Object attributeValue)
		//ㄴ ModelAndView 객체에 속성명과 속성값을 저장하기 위한 메소드 - Request Scope
		//ㄴ View(JSP 문서)에서는 EL 표현식으로 속성명을 사용하여 속성값을 제공받아 출력
		modelAndView.addObject("mavName", "홍길동");
		
		return modelAndView;
	}
	*/
	
	//요청 처리 메소드는 Front Controller에 의해 자동 호출되는 메소드
	//ㄴ 요청 처리 메소드에 매개변수를 작성하면 Front Controller는 Spring Container로부터
	//매개변수에 저장 가능한 웹 관련 객체를 제공받아 전달하여 저장
	@RequestMapping("/resultMAV")
	public ModelAndView modelAndViewResult(ModelAndView modelAndView) {
		modelAndView.setViewName("reulst_display");
		modelAndView.addObject("mavName", "홍길동");
		
		return modelAndView;
	}
	
	@RequestMapping("/resultRequest")
	public String requestResult(HttpServletRequest request) {
		//HttpServletRequest.setAttribute(String attributeName, Object attributeValue)
		//ㄴ HttpServletRequest 객체에 속성명과 속성값을 저장하기 위한 메소드 - Request Scope
		request.setAttribute("requestName", "임꺽정");
		return "result_display";
	}
	
	@RequestMapping("/resultModel")
	public String modelResult(Model model) {
		//Model 객체 : 처리결과를 속성값으로 저장하여 View에게 제공하기 위한 객체
		//Model.setAttribute(String attributeName, Object attributeValue)
		//ㄴ Model 객체에 속성명과 속성값을 저장하기 위한 메소드 - Request Scope
		model.addAttribute("modelName", "전우치");
		return "result_display";
	}
}