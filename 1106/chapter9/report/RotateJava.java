package chapter10;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class RotateJava extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JLabel la = new JLabel("Love Java");
	private String str = "Love Java";

	public RotateJava() {
		super("Left 키로 문자열 이동");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(la);
		
		c.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					str = str.substring(1) + str.substring(0, 1);
					la.setText(str);
				}
			}
		});
		
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		c.setFocusable(true);
		c.requestFocus();
	}
	
	public static void main(String[] args) {
		new RotateJava();
	}
}
