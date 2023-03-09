package xyz.itwill.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//컴퍼넌트에서 이벤트가 발생될 경우 원하는 결과를 제공하는 명령이 실행되도록 프로그램 작성(이벤트 프로그램)

//이벤트 처리 프로그램 작성 방법
// 1. 컴퍼넌트와 컨테이너 관련 클래스를 이용하여 디자인 클래스 작성 - UI 구현
//   ㄴ Frame 클래스를 상속받아 작성
//   ㄴ 컴퍼넌트 또는 컨테이너에서 다양한 이벤트 발생 - XXXEvent 클래스 : 이벤트 정보를 저장하기 위한 클래스
//   ㄴ 이벤트 소스 : 이벤트가 발생된 컴퍼넌트 또는 컨테이너
// 2. 이벤트 소스에서 발생된 이벤트를 처리하기 위한 클래스 작성
//   ㄴ 이벤트를 처리하기 위한 리스너 인터페이스를 상속받아 작성 - XXXEvent >> XXXListener
//   ㄴ ex) ActionEvent를 처리하기 위해서는 ActionListener 상속받은 클래스로 이벤트 처리
//   ㄴ 리스너 인터페이스에서는 컴퍼넌트(컨테이너)에서 발생되는 이벤트를 처리하기 위한
//      메소드가 추상메소드로 선언 돼있으므로 자식클래스에서 오버라이드 선언하여 이벤트 처리명령 작성
// 3. 이벤트가 발생 -> 이벤트 처리 클래스가 객체로 생성 -> 이벤트 처리 메소드가 호출 -> 이벤트 처리 명령이 실행
//   ㄴ 이벤트 소스에서 이벤트 발생되면 이벤트 처리 클래스의 객체로 이벤트 처리되도록 메소드 호출
//   ㄴ 형식) Component.addXXXListener(Listener l);
//   ㄴ 이벤트 처리 클래스의 객체가 자동으로 이벤트 처리 메소드를 호출하여 이벤트 호출
public class EventHandleApp extends Frame {
	private static final long serialVersionUID = 1L;

	public EventHandleApp(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		
		//버튼을 누른 경우 ActionEvent 발생
		Button exit=new Button("EXIT"); //이벤트 소스
		
		add(exit);
		
		//이벤트 처리 객체 등록 - 이벤트가 발생될 경우 이벤트 처리 메소드 자동 호출
		exit.addActionListener(new EventHandle()); 
		
		setBounds(800,200, 300,300);
		setVisible(true);	
	}
	
	public static void main(String[] args) {
		new EventHandleApp("EventHandle");
	}	
}


class EventHandle implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
	
}
