package xyz.itwill.awt;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//이벤트 처리를 위해 리스너 인터페이스 대신 어댑터 클래스를 상속받아 사용 가능
//ㄴ 리스너 인터페이스에 >>추상메소드가 2개 이상 선언된 경우에만<< 어댑터 클래스 제공
//ㄴ 필요한 이벤트 처리 메소드만 오버라이드 선언 가능(필요없는 메소드까지 오버라이드 해야하는 번거로움 해결)
@SuppressWarnings("unused")
public class WindowAdapterApp extends Frame{
	private static final long serialVersionUID = 1L;
	
	public WindowAdapterApp(String title) {
		super(title);
		
		Button red,green,blue;
		Canvas canvas;
		
		//내부 익명클래스를 사용해 이벤트 처리 객체 등록
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				super.windowClosing(e);
			}
		});
		
		
		setBounds(800,300, 300,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new WindowAdapterApp("WindowAdapter");
	}
	
	/*
	//클래스를 상속받았기 때문에 필요한 메소드만 오버라이드 가능
	public class WindowEventHandle extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
			super.windowClosing(e);
		}
	}*/	
}
