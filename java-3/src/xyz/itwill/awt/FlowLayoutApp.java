package xyz.itwill.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

//FlowLayout : 컴퍼넌트를 컨테이너의 왼쪽부터 오른쪽으로 차례대로 부착하는 배치관리자
//ㄴ 컨테이너의 크기를 벗어날 경우 자동으로 아래로 이동하여 컴퍼넌트 부착
//ㄴ Panel 클래스, Applet 클래스의 기본 배치관리자
public class FlowLayoutApp extends Frame{
	private static final long serialVersionUID = 1L;
	
	public FlowLayoutApp(String title) {
		super(title);
		
		//프레임의 배치관리자를 FlowLayout으로 변경
		setLayout(new FlowLayout());
		
		Button button1=new Button("Btn-1");
		Button button2=new Button("Btn-2");
		Button button3=new Button("Btn-3");
		Button button4=new Button("Btn-4");
		Button button5=new Button("Btn-5");
		
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		
		setBounds(600,100, 400,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FlowLayoutApp("Flow Layout");
	}
}
