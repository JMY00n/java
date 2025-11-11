package practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame {
	private static final long serialVersionUID = 1L;

	public Calculator() {
		setTitle("자바 스윙 계산기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		JPanel pn = new JPanel();
		JPanel pc = new JPanel();
		JPanel ps = new JPanel();
		
		pn.setBackground(Color.GRAY);
		pc.setLayout(new GridLayout(5, 4));
		ps.setBackground(Color.YELLOW);
		
		c.add(pn, BorderLayout.NORTH);
		c.add(pc, BorderLayout.CENTER);
		c.add(ps, BorderLayout.SOUTH);
		
		JLabel input = new JLabel("수식");
		JTextField inputText = new JTextField(10);
		pn.add(input);
		pn.add(inputText);
		
		JLabel output = new JLabel("계산 결과");
		JTextField outputText = new JTextField(10);
		ps.add(output);
		ps.add(outputText);
		
		String[] buttonLabels = {
				"C", "UN", "BK","/",
				"7", "8",  "9", "x",
				"4", "5",  "6", "-",
				"1", "2",  "3", "+",
				"0", ".",  "=", "%"
		};
		
		for (int i = 0; i < 20; i++) {
			JButton btn = new JButton(buttonLabels[i]);
			pc.add(btn);
		}
		
		
		
		setSize(400, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Calculator();
	}
}
