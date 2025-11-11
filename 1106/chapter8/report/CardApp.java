package practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardApp extends JFrame {
	private static final long serialVersionUID = 1L;

	public CardApp() {
		setTitle("16장의 카드의 뒷면에 숨겨진 이미지 찾기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container c = getContentPane();
		JPanel pn = new JPanel();
		JPanel pc = new JPanel();
		JPanel ps = new JPanel();
		JPanel pe = new JPanel();
		JPanel pw = new JPanel();

		pn.setBackground(Color.YELLOW);
		ps.setBackground(Color.YELLOW);
		pw.setBackground(Color.GRAY);
		pc.setBackground(Color.WHITE);
		pc.setLayout(new GridLayout(4, 4, 10, 10));
		pe.setBackground(Color.GRAY);

		c.add(pn, BorderLayout.NORTH);
		c.add(ps, BorderLayout.SOUTH);
		c.add(pw, BorderLayout.WEST);
		c.add(pc, BorderLayout.CENTER);
		c.add(pe, BorderLayout.EAST);

		JLabel findImage = new JLabel("숨겨진 이미지 찾기");
		pn.add(findImage);

		JButton startBtn = new JButton("실행 시작");
		ps.add(startBtn);

		for (int i = 0; i < 16; i++) {
			String text = Integer.toString(i);
			JLabel jl = new JLabel(text);
			jl.setBackground(Color.GREEN);
			jl.setOpaque(true);
			pc.add(jl);
		}
		
		JLabel pwEmpty = new JLabel("        ");
		JLabel peEmpty = new JLabel("        ");
		pw.add(pwEmpty);
		pe.add(peEmpty);

		setSize(400, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new CardApp();
	}
}
