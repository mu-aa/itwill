package xyz.itwill.awt;

import java.awt.Button;
import java.awt.Frame;

//모든 컨테이너에는 전달받은 컴퍼넌트를 자동으로 부착하기 위한 배치 관리자가 존재
//ㄴ Frame, Window, Dialog 등의 기본 배치관리자 : BorderLayout
//ㄴㄴ Panel, Applet 등의 기본 배치 관리자 : FlowLayout
//배치관리자(LayoutManager)
//ㄴ 컴퍼넌트의 크기와 출력위치를 자동 변경하여 컴퍼넌트를 컨테이너에 부착하기 위한 객체
//ㄴㄴ ★BorderLayout, ★FlowLayout, ★GrideLayout 클래스 등 
public class NonLayoutManagerApp extends Frame{
	private static final long serialVersionUID = 1L;
	
	public NonLayoutManagerApp(String title) {
		super(title);
		
		//Container.setLayout(LayoutManager mgr) : 컨테이너의 배치관리자를 변경하는 메소드
		setLayout(null); // 배치관리자를 사용하지 않도록 설정
		
		Button button1=new Button("BUTTON-1");
		Button button2=new Button("BUTTON-2");
		
		//배치관리자를 사용하지 않을 경우 반드시 컴퍼넌트의 크기와 출력위치를 변경하고 컨테이너에 부착
		button1.setBounds(80,100, 100,80);
		button2.setBounds(190,100, 100,120);
		
		add(button1);
		add(button2);
		
		setBounds(600,100, 400,500);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new NonLayoutManagerApp("Muaa");
		
	}
}
