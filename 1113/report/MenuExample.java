package chapter14;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuExample extends JFrame {
	private static final long serialVersionUID = 1L;

	public MenuExample() {
		super("메뉴 만들기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menuFile = new JMenu("파일");
		JMenu menuEdit = new JMenu("편집");
		JMenu menuSearch = new JMenu("보기");
		JMenu menuInput = new JMenu("입력");
		
		JMenuItem scaleUp = new JMenuItem("화면확대");
		JMenuItem angle = new JMenuItem("쪽윤곽");
		
		menuSearch.add(scaleUp);
		menuSearch.add(angle);
		
		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuBar.add(menuSearch);
		menuBar.add(menuInput);
		
		setJMenuBar(menuBar);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MenuExample();
	}
}
