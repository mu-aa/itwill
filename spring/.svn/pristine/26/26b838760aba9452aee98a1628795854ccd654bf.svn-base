package xyz.itwill10.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice : 예외 처리 메소드만 작성된 Controller 클래스를 Spring Bean으로 등록하기 위한 Annotation
//ㄴ 모든 Controller 클래스의 요청 처리 메소드에서 발생되어 전달된 예외를 제공받아 처리
@ControllerAdvice
public class ExceptionController {
	private static final Logger logger=LoggerFactory.getLogger(ExceptionController.class);
	
	@ExceptionHandler(Exception.class)
	public String userinfoExceptionHandler(Exception exception) {
		exception.printStackTrace();
		logger.error(exception.getMessage());
		return "userinfo/user_error";
	}
}