package practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WestGrid extends JFrame {
	private static final long serialVersionUID = 1L;

	public WestGrid() {
		setTitle("West Grid 프레임");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container c = getContentPane();
		JPanel pw = new JPanel();
		JPanel pc = new JPanel();
		pw.setLayout(new GridLayout(10, 0));
		pc.setLayout(null);

		c.add(pw, BorderLayout.WEST);
		c.add(pc, BorderLayout.CENTER);

		for (int i = 0; i < 10; i++) {
			int r = (int) (Math.random() * 256);
			int g = (int) (Math.random() * 256);
			int b = (int) (Math.random() * 256);
			Color color = new Color(r, g, b);

			JLabel empty = new JLabel("         ");
			empty.setBackground(color);
			empty.setOpaque(true);
			pw.add(empty);

		}

		for (int i = 0; i < 9; i++) {
			String number = Integer.toString(i);
			JLabel printNum = new JLabel(number);

			int x = (int) ((Math.random() * 200) + 50);
			int y = (int) ((Math.random() * 200) + 50);

			printNum.setLocation(x, y);
			printNum.setSize(10, 10);
			printNum.setForeground(Color.RED);
			pc.add(printNum);
		}

		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new WestGrid();
	}
}
