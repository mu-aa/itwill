package xyz.itwill.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

//Panel : 컴퍼넌트를 부착하여 그룹화 처리하기 위한 컨테이너
//ㄴ 독립적으로 사용 불가능, 다른 컨테이너에 부착하여 사용
public class PanelApp extends Frame{
	private static final long serialVersionUID = 1L;

	public PanelApp(String title) {
		super(title);
		
		Button red=new Button("RED");
		Button green=new Button("GREEN");
		Button blue=new Button("BLUE");
		
		//TextField : 한 줄의 문자열을 입력받기 위한 컴퍼넌트
		TextField field=new TextField();
		
		//TextArea : 여러 줄의 문자열을 입력받기 위한 컴퍼넌트
		TextArea area=new TextArea();
		
		Panel panel=new Panel();
		
		//Panel의 기본 배치관리자 : FlowLayout
		panel.add(red);
		panel.add(green);
		panel.add(blue);
		
		add(panel,BorderLayout.NORTH); //패널을 프레임의 북쪽 위치에 부착
		add(area, BorderLayout.CENTER); //텍스트영역을 프레임의 중앙 위치에 부착
		add(field, BorderLayout.SOUTH); //텍스트필드를 프레임의 남쪽 위치에 부착
		
		//Component.setFont(Font f) : 컴퍼넌트의 글자 관련 속성을 변경하는 메소드
		//Font(String name, int style, int size)
		//ㄴ 글자의 글꼴, 스타일, 크기를 전달받아 글자 관련 속성을 저장한 객체를 생성하기 위한 생성자
		//ㄴ 글꼴과 스타일은 Font 클래스에서 제공하는 상수필드 사용
		//ㄴ 컨테이너에 적용된 디자인은 컴퍼넌트에 그대로 상속되어 적용 
		panel.setFont(new Font(Font.SANS_SERIF,Font.BOLD, 16)); 
		area.setFont(new Font(Font.SANS_SERIF,Font.PLAIN, 20));
		field.setFont(new Font(Font.SANS_SERIF,Font.BOLD+Font.ITALIC, 16));
		
		//Component.setForeground(Color c) : 컴퍼넌트의 글자색을 변경하는 메소드
		//Color(int red, int green, int blue) : 빛의 3원소를 전달받아 색을 저장하기 위한 객체를 생성하는 생성자
		red.setForeground(new Color(255,0,0));
		green.setForeground(new Color(0,255,0));
		blue.setForeground(new Color(0,0,255));
		
		//Component.setBackground(Color c) : 컴퍼넌트의 배경색을 변경하는 메소드
		//ㄴ Color 객체는 Color 클래스의 상수필드를 사용하여 설정 가능
		panel.setBackground(Color.GRAY);
		
		//TextComponent.setEnabled(boolean b) : 컴퍼넌트의 활성화 상태여부를 설정하는 메소드
		//TextComponent.setEditable(boolean b) : 텍스트 컴퍼넌트의 입력값 변경여부를 설정하는 메소드
		//TextComponent.setFocusable(boolean b) : 텍스트 컴퍼넌트의 입력초점의 위치여부를 설정하는 메소드
		//false : 입력초점 미위치   true : 입력초점(커서) 위치(default)
		area.setFocusable(false);
//		area.setEnabled(false);
//		area.setEditable(false);
		
		setBounds(600,100, 300,400);
		setVisible(true);
	}
	
	
	
	
	public static void main(String[] args) {
		new PanelApp("Panel");
	}
}
