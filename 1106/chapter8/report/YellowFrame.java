package practice;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class YellowFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public YellowFrame() {
		setTitle("Make a Window using Swing");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container contentPane = getContentPane();
		contentPane.setBackground(Color.YELLOW);

		setSize(400, 150);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new YellowFrame();
	}
}
