package xyz.itwill.awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

//GridLayout : 컨테이너에 행열을 설정하여 컴퍼넌트를 부착하는 배치관리자
public class GridLayoutApp extends Frame{
	private static final long serialVersionUID = 1L;
	
	public GridLayoutApp(String title) {
		super(title);
		
		//프레임의 배치관리자를 GridLayout 객체로 변경
		setLayout(new GridLayout(3, 2)); //3행 2열
		
		Button button1=new Button("Btn-1");
		Button button2=new Button("Btn-2");
		Button button3=new Button("Btn-3");
		Button button4=new Button("Btn-4");
		Button button5=new Button("Btn-5");
		Button button6=new Button("Btn-6");
		
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		add(button6);
		
		setBounds(600,100, 300,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new GridLayoutApp("Grid Layout");
	}
}
