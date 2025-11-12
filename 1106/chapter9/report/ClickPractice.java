package chapter10;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ClickPractice extends JFrame {
	private JLabel la = new JLabel("C");
	private static final long serialVersionUID = 1L;
	
	public ClickPractice() {
		super("클릭 연습용 응용프로그램");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		la.setBounds(100, 100, 50, 50);
		c.add(la);
		
		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = (int) (Math.random() * 390);
				int y = (int) (Math.random() * 390);
				la.setLocation(x, y);
			}
		});
		
		setSize(400, 400);
		setLocationRelativeTo(null); //창을 윈도우 중앙에 배치(실행 시)	
		setVisible(true);
		c.setFocusable(true);
		c.requestFocus();
	}

	public static void main(String[] args) {
		new ClickPractice();
	}
}
