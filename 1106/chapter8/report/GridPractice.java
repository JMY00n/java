package practice;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridPractice extends JFrame {
	private static final long serialVersionUID = 1L;

	public GridPractice() {
		setTitle("GridLayout으로 10개의 버튼을 배치한 프레임");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container c = getContentPane();
		// 1행 10열
		c.setLayout(new GridLayout(1, 10));

		for (int i = 0; i < 10; i++) {
			String text = Integer.toString(i);
			JButton button = new JButton(text);
			c.add(button);
		}

		setSize(400, 150);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GridPractice();
	}
}
