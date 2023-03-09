package xyz.itwill.awt;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//프레임에서는 WindowEvent 발생 - WindowListener 인터페이스를 상속받은 자식클래스로 이벤트 처리
public class WindowListenerApp extends Frame{
	private static final long serialVersionUID = 1L;
	
	public WindowListenerApp(String title) {
		super(title);
		
		//프레임에서 이벤트가 발생될 경우 동작될 이벤트 처리 객체 등록
		addWindowListener(new WindowEventHandle());
		
		setBounds(800,200, 300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new WindowListenerApp("WindowEvent");
	}
	
	public class WindowEventHandle implements WindowListener{
		@Override
		public void windowOpened(WindowEvent e) {
			System.out.println("windowOpened 메소드 호출");
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("windowClosing 메소드 호출");
			System.exit(0);
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			System.out.println("windowClosed 메소드 호출");
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			System.out.println("windowIconified 메소드 호출");
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			System.out.println("windowDeiconified 메소드 호출");
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			System.out.println("windowActivated 메소드 호출");
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			System.out.println("windowDeactivated 메소드 호출");
			
		}
	}
	
	
}
