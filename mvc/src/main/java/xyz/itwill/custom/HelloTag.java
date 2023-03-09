package xyz.itwill.custom;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

//커스텀 태그(Custom Tag) : JSP 문서에서 스크립트 요소 대신 사용하기 위해 프로그래머가 직접 만든 태그
//ㄴ 태그 클래스 작성 -> TLD 파일에 커스텀 태그 등록 -> JSP 문서에 커스텀 태그 사용

//태그 클래스 : JSP 문서에서 커스텀 태그를 사용할 경우 호출될 메소드가 선언된 클래스
//ㄴ TagSupport 클래스, BodyTagSupport 클래스, SimpleTagSupport 클래스 중 하나를 상속받아 작성 
//ㄴ 커스텀 태그 사용 시 호출되는 메소드는 부모클래스의 메소드를 오버라이드 선언하여 작성

//태그 속성과 태그 내용이 없는 커스텀 태그의 클래스
public class HelloTag extends TagSupport{
	private static final long serialVersionUID = 1L;
	
	//JSP 문서에서 커스텀 태그를 최초로 사용할 경우 태그 클래스로 객체를 생성하기 위해 1회만 호출
	public HelloTag() {
		//System.out.println("기본생성자로 객체 생성");
	}
	
	//JSP 문서에서 커스텀 태그의 시작태그를 사용할 때마다 자동 호출되는 메소드
	@Override
	public int doStartTag() throws JspException {
		//System.out.println("doStartTag()");
		
		try {
			//부모클래스(TagSupport)에게 제공받은 PageContext 객체(pageContext 변수에 저장)를 이용하여
			//웹프로그램 실행에 필요한 객체를 반환받아 명령 작성
			//PageContext.getOut() : 응답결과를 생성하기 위한 출력스트림(JspWriter 객체)을 반환
			pageContext.getOut().println("<div>안녕하세요.</div>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//doStartTag() 태그의 반환값(정수값) : 부모클래스(TagSupport)에서 제공되는 상수 사용
		//ㄴ SKIP_BODY, EVAL_BODY_INCLUDE, EVAL_BODY_AGAIN 중 하나를 선택하여 반환
		//ㄴ SKIP_BODY : 태그내용을 클라이언트에게 전달하지 않을 경우 사용하는 상수 - default
		//ㄴ EVAL_BODY_INCLUDE : 태그내용을 클라이언트에게 전달할 경우 사용하는 상수
		//ㄴ EVAL_BODY_AGAIN : 태그내용을 클라이언트에게 다시 한번 전달할 경우 사용하는 상수
		return SKIP_BODY;
	}
	
	//JSP 문서에서 커스텀 태그의 태그내용을 사용할 때마다 자동 호출되는 메소드
	@Override
	public int doAfterBody() throws JspException {
		//System.out.println("doAfterBody()");
		
		//doAfterBody() 태그의 반환값(정수값) : doStartTag() 태그의 반환값과 동일
		return super.doAfterBody();
	}
	
	//JSP 문서에서 커스텀 태그의 종료태그를 사용할 때마다 자동 호출되는 메소드
	@Override
	public int doEndTag() throws JspException {
		//System.out.println("doEndTag()");
		
		//doEndTag() 태그의 반환값(정수값) : 부모클래스(TagSupport)에서 제공되는 상수 사용
		//ㄴ SKIP_PAGE, EVAL_PAGE(default) 중 하나를 선택하여 반환
		//SKIP_PAGE : 종료태그 실행 후 JSP 문서를 강제로 종료할 때 사용하는 상수
		//EVAL_PAGE : 종료태그 실행 후 JSP 문서를 계속 실행할 때 사용하는 상수(default)
		return EVAL_PAGE;
	}
}