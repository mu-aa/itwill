package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//모든 Model 역할의 Class가 반드시 상속받아야 하는 Interface
//ㄴ Model Class의 요청 처리 메소드에 대한 작성 규칙 제공
//ㄴ Controller 역할의 Servlet에서 Model 객체로 요청 처리 메소드를 쉽게 호출할 수 있으며 유지보수 효율성 증가
//요청 처리 메소드를 추상 메소드로 선언
//ㄴ Interface를 상속받은 모든 자식클래스에서 반드시 추상 메소드를 Override 해야함
//ㄴ 요청 처리 메소드는 HttpServleRequest 객체와 HttpServletResponse 객체를 매개변수로 전달받아 
//요청 처리하고 View 관련 정보를 ActionForward 객체로 반환하도록 작성
//ㄴ 요청 처리 메소드에서 발생되는 ServletException과 IOException은 예외 전달(throws)
public interface Action {
	ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}