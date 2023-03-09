package xyz.itwill.awt;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.TextArea;
import java.awt.event.KeyEvent;

//Frame >> MenuBar >> Menu >> MenuItem(상세메뉴목록)

public class MenuBarApp extends Frame {
	private static final long serialVersionUID = 1L;
	
	public MenuBarApp(String title) {
		super(title);
		
		MenuBar menuBar=new MenuBar();
		
		Menu file=new Menu("File");
		Menu help=new Menu("Help");
		
		menuBar.add(file); //메뉴바에 메뉴 부착
		menuBar.add(help);

		//MenuShortcut : 단축키를 설정하기 위한 클래스
		MenuItem open=new MenuItem("Open",new MenuShortcut(KeyEvent.VK_O));
		MenuItem save=new MenuItem("Save",new MenuShortcut(KeyEvent.VK_S));
		MenuItem exit=new MenuItem("Exit");
		
		MenuItem view=new MenuItem("HelpView");
		MenuItem info=new MenuItem("Infomation");
		
		file.add(open); //메뉴에 메뉴아이템 부착
		file.add(save);
		file.addSeparator(); //구분선
		file.add(exit);
		
		help.add(view);
		help.add(info);
		
		//Frame.setMenuBar(MenuBar mb) : 프레임에 메뉴바를 변경하는 메소드
		setMenuBar(menuBar);

		add(new TextArea(), BorderLayout.CENTER);
		
		setBounds(500,100, 1000,700);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		new MenuBarApp("MenuBar");
	}
}
