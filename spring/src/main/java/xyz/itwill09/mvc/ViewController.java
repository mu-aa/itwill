package xyz.itwill09.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Model 역할을 제공하기 위한 클래스
//ㄴ 클라이언트가 [view.itwill]의 URL 주소로 요청한 경우 동작될 요청 처리 클래스
public class ViewController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member=new Member("abc", "홍길동", "서울시 강남구");
		request.setAttribute("member", member);
		return "member_view";
	}
}