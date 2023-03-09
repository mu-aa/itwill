package xyz.itwill09.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ViewController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("product",new Product(4000,"프린트"));
		modelAndView.setViewName("product_view");
		return modelAndView;
	}
}