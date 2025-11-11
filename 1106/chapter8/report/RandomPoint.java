package practice;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class RandomPoint extends JFrame {
	private static final long serialVersionUID = 1L;

	public RandomPoint() {
		setTitle("배치관리자 없는 컨트롤러");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(null);

		for (int i = 0; i < 20; i++) {
			int x = (int) ((Math.random() * 250) + 10);
			int y = (int) ((Math.random() * 250) + 10);

			int r = (int) (Math.random() * 256);
			int g = (int) (Math.random() * 256);
			int b = (int) (Math.random() * 256);

			JLabel jl = new JLabel("");
			jl.setSize(10, 10);
			jl.setLocation(x, y);
			jl.setOpaque(true); // label 컴포넌트의 배경색이 불투명하게 출력되도록 설정
			jl.setBackground(new Color(r, g, b));
			
			c.add(jl);
		}

		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new RandomPoint();
	}
}
