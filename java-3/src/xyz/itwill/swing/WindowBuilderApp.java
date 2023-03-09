package xyz.itwill.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class WindowBuilderApp extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JButton red;
	private JButton blue;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JMenuBar menuBar;
	private JMenu file;
	private JMenu help;
	private JMenuItem fileMenuItem;
	private JMenuItem helpMenuItem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBuilderApp frame = new WindowBuilderApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WindowBuilderApp() {
		setTitle("WindowBuilder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 200, 400, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		red = new JButton("빨간색");
		red.setForeground(Color.RED);
		red.setFont(new Font("굴림", Font.BOLD, 14));
		panel.add(red);
		
		JButton green = new JButton("초록색");
		green.setFont(new Font("굴림", Font.BOLD, 14));
		green.setForeground(Color.GREEN);
		panel.add(green);
		
		blue = new JButton("파란색");
		blue.setFont(new Font("굴림", Font.BOLD, 14));
		blue.setForeground(Color.BLUE);
		panel.add(blue);
		
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		setJMenuBar(menuBar);
		
		file = new JMenu("File");
		menuBar.add(file);
		
		fileMenuItem = new JMenuItem("Save");
		file.add(fileMenuItem);
		
		help = new JMenu("Help");
		menuBar.add(help);
		
		helpMenuItem = new JMenuItem("Infomation");
		help.add(helpMenuItem);
		
		JTextArea textArea = new JTextArea();
		textArea.setFocusable(false);
		contentPane.add(textArea, BorderLayout.CENTER);
		
		
	}

}
