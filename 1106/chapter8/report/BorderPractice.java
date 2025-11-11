package practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderPractice extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public BorderPractice() {
		setTitle("BorderLayout 예제");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout(5, 7));
		c.setBackground(Color.YELLOW);
		c.add(new JButton("North"), BorderLayout.NORTH);
		c.add(new JButton("West"), BorderLayout.WEST);
		c.add(new JButton("South"), BorderLayout.SOUTH);
		c.add(new JButton("East"), BorderLayout.EAST);
		c.add(new JButton("Center"), BorderLayout.CENTER);
		
		setSize(400, 150);
		setVisible(true);
	}

	public static void main(String[] args) {
		new BorderPractice();
	}
}
