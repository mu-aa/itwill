package xyz.itwill.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//디자인 클래스와 이벤트 처리 클래스를 하나의 클래스로 통합하여 작성
public class EventSourceHandleApp extends Frame implements ActionListener{
	private static final long serialVersionUID = 1L;

	public EventSourceHandleApp(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		Button exit=new Button("EXIT"); //event source
		add(exit);
		
		//this 키워드를 사용하여 이벤트 처리 객체 등록
		exit.addActionListener(this); 
		
		setBounds(800,200, 300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new EventSourceHandleApp("EventSourceHandle");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
		
	}
}
