package xyz.itwill.io;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

//텍스트 파일 편집 프로그램 - 메모장
public class NotepadApp extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JMenuItem init, open, save, exit;
	private JTextArea area;
	//FileDialog : 파일을 선택하기 위한 다이얼로그를 생성하는 필드
	private FileDialog openDialog, saveDialog;
	private String filePath; //현재 작업중인 문서파일의 경로를 저장하는 필드
	private boolean status=false; // JTextArea 컴퍼넌트의 문서 변경 유무 확인을 저장하기 위한 필드
	
	public NotepadApp(String title) {
		super(title);
		
		JMenuBar bar=new JMenuBar();
		JMenu menu=new JMenu("파일(F)");
		menu.setMnemonic('F');
		init=new JMenuItem("새로만들기(N)",'N');
		open=new JMenuItem("열기(O)",'O');
		save=new JMenuItem("저장(S)",'S');
		exit=new JMenuItem("끝내기(X)",'X');
		init.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_DOWN_MASK));
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_DOWN_MASK));
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_DOWN_MASK));
		menu.add(init);
		menu.add(open);
		menu.add(save);
		menu.addSeparator();
		menu.add(exit);
		bar.add(menu);
		setJMenuBar(bar);
		
		area=new JTextArea();
		area.setFont(new Font("굴림체",Font.PLAIN,20));
		JScrollPane pane=new JScrollPane(area);
		getContentPane().add(pane,BorderLayout.CENTER);
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		//프레임에서 닫기버튼을 누른 경우 실행될 이벤트 처리 객체 등록
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//선택 다이얼로그를 닫거나 [취소]를 선택한 경우 이벤트 처리 메소드 종료
				if(!isSave()) return;
				System.exit(0);
			}
		});
		
		setBounds(450,150, 1100,700);
		setVisible(true);
		
		init.addActionListener(this);
		open.addActionListener(this);
		save.addActionListener(this);
		exit.addActionListener(this);
		
		//JTextArea 컴퍼넌트에서 키보드 관련 이벤트가 발생된 경우 실행될 이벤트 처리 객체 등록
		//ㄴ KeyAdapter 클래스를 상속받은 익명의 자식클래스 객체를 이용하여 이벤트 처리
		area.addKeyListener(new KeyAdapter() {
			@Override  //★KeyPressed:키가 눌렸을 때, KeyTyped:문자가 입력된 경우, keyReleased:키를 눌렀다 뗐을 때
			public void keyTyped(KeyEvent e) { 
				//KeyEvent.getKeyChar() : 이벤트가 발생된 키보드의 문자값을 반환하는 메소드
				//이벤트가 발생된 키보드의 문자값이 null이 아닌 경우
				if(!status && e.getKeyChar()!='\0') {
					status=true;
					setTitle("*"+getTitle().replace("*", "")); //별 갯수 하나 이상 넘지않게 replace
				}
			}
		});
		
		//읽기 파일 선택하기 위한 파일 다이얼로그 생성
		openDialog=new FileDialog(this, "열기", FileDialog.LOAD);
		//쓰기 파일 선택하기 위한 파일 다이얼로그 생성
		saveDialog=new FileDialog(this, "저장", FileDialog.SAVE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object eventSource=e.getSource();
		
		if(eventSource==init) {
			//선택 다이얼로그에서 저장 유무 선택
			//ㄴ 선택 다이얼로그를 닫거나 [취소]를 선택한 경우 이벤트 처리 메소드 종료
			if(!isSave()) return;
			
			filePath=null;
			area.setText("");
			setTitle("제목없음 - Java 메모장");
			
		} else if(eventSource==open) {
			//선택 다이얼로그를 닫거나 [취소]를 선택한 경우 이벤트 처리 메소드 종료
			if(!isSave()) return;
			
			//파일을 선택하거나 취소한 경우 파일 다이얼로그는 자동으로 숨김 처리
			openDialog.setVisible(true);
			
			//FileDialog.getFile() : 선택된 파일을 반환하는 메소드 
			//파일 다이얼로그에서 파일 선택을 취소한 경우 이벤트 처리 메소드 종료
			if(openDialog.getFile()==null) return;
			
			//FileDialog.getDirectory() : 선택된 파일이 저장된 디렉토리 경로를 반환하는 메소드 
			filePath=openDialog.getDirectory()+openDialog.getFile();
			
			try {
				BufferedReader in=new BufferedReader(new FileReader(filePath));
				
				//프레임 제목을 현재 파일로 변경
				setTitle(openDialog.getFile()+" - Java 메모장");

				area.setText("");
				
				//파일에 저장된 값을 한줄씩 읽어 JTextArea 컴퍼넌트에 출력 처리
				while(true) {
					//파일 입력스트림에서 엔터(Enter)전까지의 모든 문자데이터(문자열)를 읽어 저장
					String text=in.readLine();
					if(text==null) { break; } // 읽을 문자열이 없는 경우 반복문 종료
					//JTeaxArea 컴퍼넌트에 문자열을 추가하여 출력
					area.append(text+"\n");
				}
				
				in.close();
				
				//JTextArea.setCaretPosition(int position) : JTextArea 컴퍼넌트의 입력 촛점(커서) 위치를 변경하는 메소드
				area.setCaretPosition(0);
			} catch(FileNotFoundException error) {
				JOptionPane.showMessageDialog(this, "선택한 파일을 찾을 수 없습니다.");
			} catch (IOException error) {
				JOptionPane.showMessageDialog(this, "프로그램에 문제가 발생했습니다.");
			}
		} else if(eventSource==save) {
			save();
		} else if(eventSource==exit) {
			//선택 다이얼로그를 닫거나 [취소]를 선택한 경우 이벤트 처리 메소드 종료
			if(!isSave()) return;
			System.exit(0);
		}
	}
	
	//JTextArea 컴퍼넌트의 내용 변경에 따른 저장 유무를 선택하여 처리하기 위한 메소드
	//ㄴ 선택 다이얼로그를 이용, 저장 유무를 선택하여 처리
	//ㄴ 반환값 - false : 창닫기 또는 취소,  true : 저장 또는 미저장
	//ㄴ [새로만들기], [열기], [끝내기]의 JMenuItem 컴퍼넌트 선택 시 호출
	public boolean isSave() {
		if(status) { //JTextArea 컴퍼넌트의 내용이 변경된 경우
			status=true;
			//JOptionPane.showConfirmDialog(Component parent, String messsage, String title, int optionType)
			//ㄴ 선택 다이얼로그를 출력하는 메소드 - 선택값 반환
			int choice=JOptionPane.showConfirmDialog(this, "변경된 내용을 저장하시겠습니까?","확인",JOptionPane.YES_NO_CANCEL_OPTION);
			
			if(choice==JOptionPane.YES_OPTION) {
				save();
			} else if(choice==JOptionPane.CANCEL_OPTION || choice==JOptionPane.CLOSED_OPTION) {
				return false;
			}	
		}
		//선택 다이얼로그에서 [저장] 또는 [미저장]을 선택한 경우
		status=false;//변경 상태 초기화
		return true;
	}
	
	public void save() {
		if(filePath==null) {	//현재 작업중인 문서 파일이 있는 경우 다이얼로그 생략
			saveDialog.setVisible(true);
			if(saveDialog.getFile()==null) return;
			filePath=saveDialog.getDirectory()+saveDialog.getFile();
			setTitle(saveDialog.getFile()+" -  Java 메모장");
		}
		
		try {
			BufferedWriter out=new BufferedWriter(new FileWriter(filePath, true));
			
			/*★*/String text=area.getText(); //JTextArea 컴퍼넌트의 모든 문자열을 반환받아 저장
			
			out.write(text);
			out.close();
			
			status=false; //저장 상태 초기화
		} catch (IOException e1) {
			System.out.println("ERROR");
		}
	}
	
	public static void main(String[] args) {
		new NotepadApp("제목없음 - Java 메모장");	
	}
}
