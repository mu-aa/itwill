package xyz.itwill.awt;

import java.awt.Frame;

//CUI(Character User Interface)프로그램 : 문자 중심의 실행 환경을 제공하는 프로그램
//GUI(Graphic User Interface)프로그램 : 그래픽 중심의 실행 환경을 제공하는 프로그램
//ㄴ 컴퍼넌트를 이용하여 작성된 프로그램

//java.awt 패키지 : GUI 프로그램을 작성하기 위한 클래스가 선언된 패키지
//ㄴ 운영체제(OS)에 종속된 컴퍼넌트 제공
//javax.swing 패키지 : GUI 프로그램을 작성하기 위한 클래스가 선언된 패키지
//ㄴ 운영체제와 별개의 Java 컴퍼넌트를 제공

//컴퍼넌트(Component) : GUI 프로그램에서 디자인 요소를 구현하기 위한 클래스
//ㄴ Button, List(자료구조 클래스 아님), Label, Canvas, Checkbox, Choice, Scrollbar, TextField, TextArea 등이 존재 
//컨테이너(Container) : 컴퍼넌트를 부착하기 위한 컴퍼넌트
//ㄴ 독립적 컨테이너 : ★Frame, Window, Dialog 등 - 독립적으로 사용 가능
//ㄴ 종속적 컨테이너 : Panel, ScrollPane 등 - 다른 컨테이너에 부착하여 사용 가능
public class FrameOneApp {
	public static void main(String[] args) {
		//Frame : 메뉴가 존재하는 창
//		Frame frame=new Frame();
		Frame frame=new Frame("test");
		
		//Companent.setSize(int width, int height) : 컴퍼넌트의 크기(폭과 높이)를 변경하는 메소드
		//ㄴ 크기 또는 위치는 픽셀(Pixel : 모든 색을 표현하는 점)을 기본단위로 사용
		frame.setSize(400, 300);
		
		//Companent.setSize(int x, int y) : 컴퍼넌트의 출력 위치(x좌표, y좌표)를 변경하는 메소드
		frame.setLocation(600, 100);
		
		//Companent.setVisible(boolean) : 컴퍼넌트의 출력 유무를 설정하는 메소드
		//ㄴ false : 미출력(default),   true : 출력
		frame.setVisible(true);
		
		
		
		
	}
}
