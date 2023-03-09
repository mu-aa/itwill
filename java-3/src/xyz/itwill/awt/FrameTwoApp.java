package xyz.itwill.awt;

import java.awt.Frame;


//GUI 프로그램은 Frame 클래스를 상속받아 작성하는 것을 권장
public class FrameTwoApp extends Frame{
	private static final long serialVersionUID = 1L;
	
	//생성자에서 프레임에 대한 디자인 설정- UI(User Interface) 구현
	public FrameTwoApp(String title) {		
//		Frame(String title)
		super(title);
//		setTitle(title); //프레임 제목 변경
		
//		setSize(400, 300); //프레임 크기기 변경
//		setLocation(600, 100); //프레임 출력위치 변경
		//Component.setBounds(int x, int y, int width, int height) : 컴퍼넌트의 출력 위치와 크기 변경
		setBounds(600,100, 400,300);
		
		//Component.setResizable(boolean resize) : 프레임의 크기 변경 여부를 설정하는 메소드
		//ㄴ false : 프레임 크기 변경 불가능,  true : 프레임 크기 변경 가능(default)
		setResizable(false);
		
		setVisible(true); //프레임 출력
	}
	
	public static void main(String[] args) {												//┌메뉴가 있는 창
		//Frame 클래스를 상속받은 자식 클래스로 객체 생성 -> Frame(부모 클래스) 객체 생성 : 프레임 생성
		new FrameTwoApp("Frame Test"); // 생성자에서도 변경 가능하지만 main에서도 가능
		
		
		
		
	}
	
	
	
}
