package xyz.itwill.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class CalculatorAnotherApp extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JLabel label;
	private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
	private JButton bMulti, bDiv, bPlus, bMinus, bClear, bEquals;

	//연산식을 저장하기 위한 필드
	private String operation="";
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorApp frame = new CalculatorApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CalculatorAnotherApp() {
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 200, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(10, 10));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 4, 5, 5));
		
		b7 = new JButton("7");
		b7.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(b7);
		
		b8 = new JButton("8");
		b8.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(b8);
		
		b9 = new JButton("9");
		b9.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(b9);
		
		bMulti = new JButton("*");
		bMulti.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(bMulti);
		
		b4 = new JButton("4");
		b4.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(b4);
		
		b5 = new JButton("5");
		b5.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(b5);
		
		b6 = new JButton("6");
		b6.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(b6);
		
		bDiv = new JButton("/");
		bDiv.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(bDiv);
		
		b1 = new JButton("1");
		b1.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(b1);
		
		b2 = new JButton("2");
		b2.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(b2);
		
		b3 = new JButton("3");
		b3.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(b3);
		
		bPlus = new JButton("+");
		bPlus.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(bPlus);
		
		b0 = new JButton("0");
		b0.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(b0);
		
		bClear = new JButton("C");
		bClear.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(bClear);
		
		bEquals = new JButton("=");
		bEquals.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(bEquals);
		
		bMinus = new JButton("-");
		bMinus.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(bMinus);
		
		label = new JLabel("0");
		label.setBackground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		label.setFont(new Font("Dialog", Font.BOLD, 30));
		contentPane.add(label, BorderLayout.NORTH);
		
		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		bMulti.addActionListener(this);
		bDiv.addActionListener(this);
		bPlus.addActionListener(this);
		bMinus.addActionListener(this);
		bClear.addActionListener(this);
		bEquals.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//이벤트가 발생된 컴퍼넌트(JButton 컴퍼넌트)를 반환받아 저장
		// => 반환받은 Object 객체를 JButton 클래스로 명시적 객체 형변환하여 저장
		JButton eventButton=(JButton)e.getSource();
		
		//이벤트가 발생된 JButton 컴퍼넌트를 구분하여 명령 처리
		if(eventButton==bClear) {//이벤트가 발생된 JButton 컴퍼넌트가 [Clear]인 경우
			operation="";//연산식 저장 필드 초기화
			label.setText("0");//출력 컴퍼넌트 초기화
		} else if(eventButton==bEquals) {//이벤트가 발생된 JButton 컴퍼넌트가 [Equals]인 경우
			//연산식에서 검색하기 위한 연산자가 저장된 문자열 배열 선언
			String[] operatorArray={"*","/","+","-"};
			
			int index=-1;//연산식에서 연산자 위치의 첨자를 저장하기 위한 변수
			//연산식에서 연산자를 검색하기 위한 반복문
			for(int i=0;i<operatorArray.length;i++) {
				index=operation.lastIndexOf(operatorArray[i]);
				if(index!=-1) break;
			}
			
			//연산식에서 연산자를 찾을 수 없는 경우 이벤트 처리 메소드 종료
			if(index<=0) return; 
			
			try {
				//연산식에서 피연산자와 연산자를 분리하여 변수에 저장
				int num1=Integer.parseInt(operation.substring(0, index));
				int num2=Integer.parseInt(operation.substring(index+1));
				String operator=operation.substring(index, index+1);
				
				//연산식를 비교하여 피연산자의 연산 결과를 저장
				int result=0;
				switch (operator) {
				case "*": result=num1*num2; break;
				case "/": result=num1/num2; break;
				case "+": result=num1+num2; break;
				case "-": result=num1-num2; break;
				}
				
				//JLabel 컴퍼넌트에 연산 결과 출력 
				// => 연산 결과값을 문자열로 변환해야 setText() 메소드 호출 가능
				//label.setText(String.valueOf(result));
				label.setText(result+"");
				
				//operation="";//연산식 저장 필드 초기화
				operation=result+"";//연산 결과를 연산식에 저장 - 반복적인 연산 가능
			} catch (ArithmeticException exception) {//어떤 수를 0으로 나눈 경우 발생되는 예외
				operation="";
				label.setText("0으로 나눌 수 없습니다.");
			} catch (NumberFormatException exception) {//문자열을 숫자값으로 변환할 수 없는 경우 발생되는 예외
				operation="";
				label.setText("0");
				//JOptionPane.showMessageDialog(Component parent, String message)
				// => 메세지를 출력하는 다이얼로그를 보여주는 메소드 
				JOptionPane.showMessageDialog(this, "입력된 연산식이 형식에 맞지 않습니다.");
			} catch (Exception exception) {//모든 예외
				JOptionPane.showMessageDialog(this, "프로그램에 예기치 못한 오류가 있습니다.");
				System.exit(0);
			}
		} else {
			//이벤트가 발생된 JButton 컴퍼넌트의 문장열을 반환받아 연산식에 추가(결합)하여 저장
			//JComponent.getText() : 컴퍼넌트의 문자열을 반환하는 메소드 
			operation+=eventButton.getText();
			
			//연산식을 JLabel 컴퍼넌트에 출력되도록 문자열 변경
			//JComponent.setText(String text) : 컴퍼넌트의 문자열을 변경하는 메소드 
			label.setText(operation);
		}
	}
}