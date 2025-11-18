package chapter14;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class JToolAndOptipn extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public JToolAndOptipn() {
		super("연습");
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("파일");
		JMenuItem exit = new JMenuItem("종료");
	
		fileMenu.add(exit);
		menuBar.add(fileMenu);
		
		exit.addActionListener(e -> {
			int result = JOptionPane.showConfirmDialog(
					this,
					"정말 종료하시겠습니까?",
					"확인",
					JOptionPane.YES_NO_OPTION);
			
			if (result == JOptionPane.YES_OPTION)
				System.exit(0);
		});
		
		setJMenuBar(menuBar);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new JToolAndOptipn();
	}
}
