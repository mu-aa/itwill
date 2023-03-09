package xyz.itwill.awt;

import java.awt.Button;
import java.awt.Frame;

public class ComponentAddApp extends Frame {
	private static final long serialVersionUID = 1L;
	
	public ComponentAddApp(String title) {
		super(title);
		
		//Button 클래스 : 버튼 컴퍼넌트 구현
		//Button(String label) : 버튼 이름을 설정하여 Button 객체를 생성하기 위한 생성자 
		Button button=new Button("Button");
		
		//Container.add(Componenet c) : 컨테이너에 컴퍼넌트를 부착하는 메소드
		//ㄴ 컨테이너에 설정된 기본 배치 관리자(LayoutManager)에 의해
		//컴퍼넌트의 크기와 출력위치가 자동 설정되어 컨테이너에 컴퍼넌트가 자동으로 부착된다
		add(button);
		
		setBounds(600,100, 300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ComponentAddApp("컴퍼넌트 부착");
		
		
	}
}
