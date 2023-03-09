package xyz.itwill.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//Swing 프로그램을 작성하는 방법
//  1. java.awt 패키지의 컴퍼넌트 또는 컨테이너 관련 클래스 대신
//     javax.swing 패키지의 컴퍼넌트 또는 컨테이너 관련 클래스를 사용하여 UI 구현
//     ㄴ awt 컴퍼넌트 또는 컨테이너 클래스 이름 앞에 J를 붙이면 Swing 컴퍼넌트 또는 컨테이너 클래스
//  ★2. 프레임의 닫기 버튼을 누른 경우 동작하는 기능을 변경하여 프레임 조작 가능
//     ㄴ 형식) JFrame.setDefaultCloseOperation(int operation);
//        ㄴ HIDE_ON_CLOSE(defalut), DO_NOTING_ON_CLOSE, DISPOSE_ON_CLOSE, EXIT_ON_CLOSE 중 하나의 상수를 사용하여 프레임 조작 방법 설정
//  ★3. 프레임을 직접 변경하지 않고 프레임의 Container 객체를 반환받아 변경 처리
//     ㄴ 프레임 배치관리자 변경, 프레임 컴퍼넌트 부착, 프레임 배경 색 변경 등

public class SwingApp extends JFrame{
	private static final long serialVersionUID = 1L;
	
	//JTextField 컴퍼넌트에서 문자열 입력 후 엔터를 입력하면 ActionEvent 발생
	JTextField textField;
	JTextArea textArea;

	public SwingApp(String title) {
		super(title);
		
		textField=new JTextField();
		textArea=new JTextArea("muaa is joined\n");
		
		//JScrollPane : 컴퍼넌트가 범위를 벗어날 경우 스크롤을 생성하기 위한 컨테이너
		JScrollPane jScrollPane=new JScrollPane(textArea);
		
		//JFrame.getContentPane() : 프레임의 컨테이너 기능을 제공하는 Container 객체를 반환하는 메소드
		Container container=getContentPane();
		
		container.add(jScrollPane, BorderLayout.CENTER);
		container.add(textField, BorderLayout.SOUTH);
		
		//swing에서는 모든 글꼴 사용 가능
		textField.setFont(new Font("나눔고딕코딩",Font.BOLD,14));
		textArea.setFont(new Font("나눔고딕코딩",Font.BOLD,16));
		
		textArea.setFocusable(false); //커서가 안가게 설정(출력 전용)
		
		textField.addActionListener(new TextEventHandle());

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setBounds(800,300, 300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SwingApp("Swing");
	}
	
	public class TextEventHandle implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//TextComponent.getText() : JTextField 컴퍼넌트 또는 JTextArea 컴퍼넌트에 입력된 문자열을 반환하는 메소드
			String text= textField.getText();
			
			if(!text.equals("")) {
				//JTextArea.append(String text) : JTextArea 컴퍼넌트에 문자열을 추가하여 출력하는 메소드
				textArea.append("[muaa] : "+text+"\n");

				//TextComponent.setText(String text) : JTextField 컴퍼넌트 또는 JTextArea 컴퍼넌트에 입력된 문자열을 변경하는 메소드
				textField.setText("");
			}
		}
	}
	
	
}
