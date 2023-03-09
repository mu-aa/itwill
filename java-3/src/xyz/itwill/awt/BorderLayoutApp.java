package xyz.itwill.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

//BorderLayout : 컴퍼넌트를 컨테이너의 중앙, 동, 서, 남, 북 으로 구분하여 부착하는 배치관리자
//ㄴ 컴퍼넌트를 컨테이너에 부착할 때 부착 위치를 반드시 설정
//ㄴ Frame, Window, Dialog 등의 기본 배치관리자 
public class BorderLayoutApp extends Frame {
	private static final long serialVersionUID = 1L;
	
	public BorderLayoutApp(String title) {
		super(title);
		
		//프레임의 배치관리자를 BorderLayout 객체로 변경
		//setLayout(new BorderLayout()); - 프레임은 BorderLayout이 기본 배치관리자라 생략 가능

		Button button1=new Button("Center");
		Button button2=new Button("East");
		Button button3=new Button("West");
		Button button4=new Button("South");
		Button button5=new Button("North");
		
		//Container.add(Conponent c, int) : 컴퍼넌트를 컨테이너의 원하는 위치에 부착하는 메소드
		//ㄴ 컴퍼넌트의 부착 위치는 BorderLayout 클래스의 상수필드 이용
		//ㄴ 컴퍼넌트의 부착 위치가 생략된 경우 컴퍼넌트를 무조건 컨테이너의 중앙에 부착
		//ㄴ 컨테이너 중앙에는 반드시 컴퍼넌트를 배치해야 하지만 동서남북은 생략 가능
		add(button1, BorderLayout.CENTER);
		add(button2, BorderLayout.EAST);
		add(button3, BorderLayout.WEST);
		add(button4, BorderLayout.SOUTH);
		add(button5, BorderLayout.NORTH);
		
		setBounds(600,100, 400,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BorderLayoutApp("BorderLayout");
	}
	
}
