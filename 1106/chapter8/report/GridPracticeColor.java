package practice;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridPracticeColor extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public GridPracticeColor() {
		setTitle("배경 색을 가진 10개의 버튼");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(1, 10));
		
		Color[] color = {Color.RED, Color.BLACK, Color.BLUE,
						 Color.CYAN, Color.DARK_GRAY, Color.GRAY,
						 Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA,
						 Color.PINK};
		
		for (int i = 0; i < 10; i++) {
			String text = Integer.toString(i);
			JButton button = new JButton(text);
			c.add(button);
			button.setOpaque(true);
			button.setBackground(color[i]);
		}
		
		setSize(400, 150);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GridPracticeColor();
	}
}
