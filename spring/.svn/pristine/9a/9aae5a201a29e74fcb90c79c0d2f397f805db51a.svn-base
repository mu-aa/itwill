package xyz.itwill09.mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Model : 클라이언트의 요청을 처리하기 위한 기능을 제공하는 클래스

//Model 역할을 제공하기 위한 클래스 - 요청 처리 메소드가 선언된 인터페이스를 상속받아 작성
//ㄴ 하나의 클라이언트 요청에 대해 하나의 요청 처리 클래스를 사용하여 클라이언트의 요청 처리 - 
//ㄴ 클라이언트가 [list.itwill]의 URL 주소로 요청한 경우 동작될 요청 처리 클래스
public class ListController implements Controller {
	//요청 처리 메소드 : 클라이언트의 요청을 처리하기 위한 명령을 작성한 메소드
	//ㄴ 스레드가 이동되어 응답될 JSP 문서의 이름(ViewName)을 반환
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 처리 명령 - 데이터 처리 : Service 클래스의 메소드 호출
		List<Member> memberList=new ArrayList<Member>();
		memberList.add(new Member("abc", "홍길동", "서울시 강남구"));
		memberList.add(new Member("opq", "임꺽정", "인천시 월미구"));
		memberList.add(new Member("xyz", "전우치", "수원시 팔달구"));
		
		//요청 처리 결과를 JSP 문서에 제공하기 위해 request 속성값으로 저장
		request.setAttribute("memberList", memberList);
		
		//처리 결과를 제공받아 클라이언트에게 응답할 JSP 문서의 이름(ViewName) 반환
		return "member_list";
	}
}