package xyz.itwill.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//디자인 클래스 내부에 이벤트 처리 클래스를 선언 - 중첩 클래스
public class EventInnerHandleApp extends Frame{
	private static final long serialVersionUID = 1L;

	public EventInnerHandleApp(String title) {
		super(title);
		setLayout(new FlowLayout());
		Button exit=new Button("EXIT");
		add(exit);
		
		//외부클래스에서는 내부클래스를 사용하여 객체 생성 가능
		exit.addActionListener(new EventHandle());
		
		setBounds(800,200, 300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new EventInnerHandleApp("EventInnerHandle");
	}
	
	//내부클래스는 외부클래스의 필드와 메소드를 접근제한자에 상관없이 사용 가능
	public class EventHandle implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	
	
}
