package xyz.itwill.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//컴퍼넌트에 대한 이벤트 처리를 위해 익명의 내부클래스 사용
public class EventAnnonymousHandleApp extends Frame{
	private static final long serialVersionUID = 1L;
	
	public EventAnnonymousHandleApp(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		Button exit=new Button("EXIT");
		add(exit);
		
		//Listener 인터페이스를 상속받은 익명의 클래스(1회용)를 이용하여 이벤트 처리 객체 생성
		exit.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		setBounds(800,300, 300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new EventAnnonymousHandleApp("EventAnnonymousHandle");
	}

}
