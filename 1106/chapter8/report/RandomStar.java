package practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RandomStar extends JFrame {
	public RandomStar() {
		setTitle("랜덤한 별을 가진 프로그램");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container c = getContentPane();
		JPanel pn = new JPanel();
		JPanel pc = new JPanel();
		JPanel ps = new JPanel();

		pn.setBackground(Color.GRAY);
		pc.setLayout(null);
		pc.setBackground(Color.WHITE);
		ps.setBackground(Color.YELLOW);

		c.add(pn, BorderLayout.NORTH);
		c.add(pc, BorderLayout.CENTER);
		c.add(ps, BorderLayout.SOUTH);

		JLabel text = new JLabel("별 개수");
		JTextField inputStar = new JTextField(8);
		JButton makeStar = new JButton("별 만들기");
		pn.add(text);
		pn.add(inputStar);
		pn.add(makeStar);

		JButton exit = new JButton("Exit");
		ps.add(exit);

		JButton refresh = new JButton("refresh");
		int btnWidth = 80;
		int btnHeight = 25;
		refresh.setBounds(5, 5, btnWidth, btnHeight);
		pc.add(refresh);
	

		// 별 생성
		for (int i = 0; i < 15; i++) {
			JLabel star = new JLabel("*");
			int x = (int) (Math.random() * 280);
			int y = (int) (Math.random() * 180);
			star.setBounds(x, y, 10, 10);
			star.setForeground(Color.RED);
			
			pc.add(star);
		}

		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new RandomStar();
	}
}
