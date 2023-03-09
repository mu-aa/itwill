package xyz.itwill.custom;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

//태그 속성이 있으며 태그 내용이 없는 커스텀 태그의 클래스
public class HelloMessageTag extends TagSupport{
	private static final long serialVersionUID = 1L;
	
	//태그 속성값을 저장하기 위한 필드 선언 - ★태그의 속성명과 같은 이름으로 선언
	private String name;
	
	//생성자에서는 객체 생성에 필요한 초기화 작업에 대한 명령 작성 - 필드 초기값 설정
	public HelloMessageTag() {
		//커스텀 태그에서 속성을 생략할 경우 기본적으로 사용될 속성값을 필드에 자동 저장하기 위해 작성
		//ㄴ 태그 속성이 필수인 경우 필드 기본값 설정 생략
		name="홍길동";
	}

	public String getName() {
		return name;
	}
	
	//커스텀 태그에서 태그 속성을 사용하여 속성값을 설정할 경우 Setter 메소드 자동 호출
	//ㄴ 매개변수로 속성값을 제공받아 필드값 변경
	public void setName(String name) {
		this.name = name;
	}
	
	//커스텀태그 사용 시 실행될 명령이 있는 경우에만 메소드를 오버라이드 선언하여 작성
	//ㄴ 메소드를 오버라이드 선언하지 않으면 자동으로 부모클래스의 명령이 없는 메소드 호출 
	@Override
	public int doStartTag() throws JspException {
		try {
			if(name.equals("홍길동")) {
				pageContext.getOut().println("<h3>관리자님, 안녕하세요.</h3>");
			} else {
				pageContext.getOut().println("<h3>"+name+"님, 안녕하세요.</h3>");
			}
		} catch (IOException e) {
			throw new JspException(e.getMessage()); //IOException 발생 시 JspException으로 변환
		}
		return super.doStartTag(); //SKIP_BODY(default)
	}
}