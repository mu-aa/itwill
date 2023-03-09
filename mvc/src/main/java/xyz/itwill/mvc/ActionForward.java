package xyz.itwill.mvc;

//응답 관련 정보(View)를 저장하기 위한 클래스
public class ActionForward {
	//이동 형식에 대한 정보를 저장하기 위한 필드
	//ㄴ false : Redirect 이동, true : Forward 이동
	//Redirect 이동 : 클라이언트에게 요청 URL 주소(/XXX.do)를 전달하여 다시 요청하도록 응답
	//ㄴ 클라이언트 브라우저의 요청 URL 주소 변경
	//Forward 이동 : Servlet(Controller)에서 JSP(View)로 Thread를 이동하여 응답 처리
	//ㄴ 클라이언트 브라우저의 요청 URL 주소 미변경
	private boolean forward;
	
	//이동될 웹프로그램의 경로를 저장하기 위한 필드
	//ㄴ Redirect 이동 : /XXX.do || Forward 이동 : /XXX.jsp
	private String path;
	
	public ActionForward() {
		// TODO Auto-generated constructor stub
	}

	public boolean isForward() {
		return forward;
	}

	public void setForward(boolean forward) {
		this.forward = forward;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
