package xyz.itwill.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EventSourceGetApp extends Frame{
	private static final long serialVersionUID = 1L;
	//이벤트 처리 메소드에서 사용할 컴퍼넌트 또는 컨테이너는 필드로 선언
	Button red,green,blue,white;
	Canvas canvas;

	public EventSourceGetApp(String title) {
		super(title);
		
		red=new Button("RED");
		green=new Button("GREEN");
		blue=new Button("BLUE");
		white=new Button("WHITE");
		
		Panel panel=new Panel();
		panel.setLayout(new GridLayout(1, 4));
		
		canvas=new Canvas();
		
		panel.add(red);
		panel.add(green);
		panel.add(blue);
		panel.add(white);
		
		add(panel, BorderLayout.NORTH);
		add(canvas, BorderLayout.CENTER);
		
		panel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				super.windowClosed(e);
			}
		});
		
		red.addActionListener(new ColorButtonHandle());
		green.addActionListener(new ColorButtonHandle());
		blue.addActionListener(new ColorButtonHandle());
		white.addActionListener(new ColorButtonHandle());
		
		setBounds(800,300, 300,300);
		setVisible(true);
	}
	
	public class ColorButtonHandle implements ActionListener{
		//이벤트 처리 메소드는 이벤트가 발생하면 JVM에 의해 자동 호출
		//ㄴ 이벤트 처리 메소드의 매개변수에는 이벤트 정보가 저장된 XXXEvent 객체 제공
		@Override
		public void actionPerformed(ActionEvent e) {
			//Event.getSource() : 이벤트가 발생된 컴퍼넌트를 반환하는 메소드
			//ㄴ 이벤트가 발생된 컴퍼넌트를 Object 타입의 객체로 반환
			//ㄴ 명시적 객체 형변환을 사용하여 원하는 컴퍼넌트로 변환해 사용 가능
			//★Object eventSource=e.getSource();
			Button eventSource=(Button)e.getSource();
			
			//이벤트가 발생된 컴퍼넌트를 구분하여 명령 실행
			if(eventSource==red) { // 이벤트가 발생된 컴퍼넌트와 //해시코드를 비교//하여 같은 경우
				canvas.setBackground(Color.red);
			} else if(eventSource==green) {
				canvas.setBackground(Color.green);
			} else if(eventSource==blue) {
				canvas.setBackground(Color.blue);
			} else if(eventSource==white){
				canvas.setBackground(Color.white);
			}
		}
	}
	
	/*
	public class RedButtonHandle implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.setBackground(Color.RED);
		}
	}
	
	public class GreenButtonHandle implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.setBackground(Color.GREEN);
		}
	}
	
	public class BlueButtonHandle implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.setBackground(Color.BLUE);
		}
	}
	
	public class WhiteButtonHandle implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.setBackground(Color.WHITE);
		}
	}
	*/
	public static void main(String[] args) {
		new EventSourceGetApp("EventSourceGet");
	}
}
