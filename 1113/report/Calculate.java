package chapter14;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MyDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private JLabel text = new JLabel("두 수를 더합니다.");
	private JTextField firstInput = new JTextField(10);
	private JTextField secondInput = new JTextField(10);
	private JButton addBtn = new JButton("Add");
	
	private JPanel north = new JPanel();
	private JPanel center = new JPanel();
	private JPanel south = new JPanel();
	
	private int sum = 0;
	
	public int getSum() {
		return sum;
	}
	
	public MyDialog(JFrame frame, String title) {
		super(frame, title, true);
		
		Container c = getContentPane();
		
		north.add(text);
		
		center.setLayout(new FlowLayout());
		center.add(firstInput);
		center.add(secondInput);
		
		south.add(addBtn);
		
		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int first = Integer.parseInt(firstInput.getText());
				int second = Integer.parseInt(secondInput.getText());
				sum = first + second;
				dispose();
			}
		});
		
		c.add(north, BorderLayout.NORTH);
		c.add(center, BorderLayout.CENTER);
		c.add(south, BorderLayout.SOUTH);
		
		setLocationRelativeTo(null);
		setSize(200, 200);
	}
	
}

public class Calculate extends JFrame {
	private static final long serialVersionUID = 1L;
	private MyDialog dialog;

	public Calculate() {
		super("다이얼로그 만들기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container c = getContentPane();
		dialog = new MyDialog(this, "Calculation Dialog");
		JPanel north = new JPanel();
		north.setLayout(new FlowLayout());
		
		JButton calc = new JButton("calculate");
		JLabel result = new JLabel("계산 결과 출력");
		result.setBackground(Color.GREEN);
		// calc 버튼 btn을 누르면 JDialog 창 출력
		north.add(calc);
		north.add(result);
		
		c.add(north, BorderLayout.NORTH);
		
		calc.addActionListener(e -> {
			dialog.setVisible(true);
			
			int resultValue = dialog.getSum();
			result.setText(""+resultValue);
		});

		setSize(400, 400);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new Calculate();
	}
}
