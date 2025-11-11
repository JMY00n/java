package practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OpenChallenge extends JFrame {
	private static final long serialVersionUID = 1L;

	public OpenChallenge() {
		setTitle("Open Challenge 9");
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

		JLabel headText = new JLabel("단어 조합 게임! 순서대로 단어를 클릭하세요~~");
		JButton newTextBtn = new JButton("New Text");
		pn.add(headText);
		pn.add(newTextBtn);

		JLabel name = new JLabel("이름");
		JTextField input = new JTextField(10);
		ps.add(name);
		ps.add(input);

		String text = "I can't help falling in love with you";
		String[] words = text.split(" ");

		for (int i = 0; i < words.length; i++) {
			int x = (int) (Math.random() * 350);
			int y = (int) (Math.random() * 180);
			JLabel word = new JLabel(words[i]);

			int wordWith = words[i].length() * 8 + 5;
			word.setBounds(x, y, wordWith, 15);
			
			pc.add(word);
		}

		setSize(400, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new OpenChallenge();
	}
}
