package chapter14;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class TextApp extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public TextApp() {
		super("숫자가 아닌 키가 입력되는 경우 경고창 만들기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 300);
		
		Container c = getContentPane();
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(Color.GRAY);
		toolBar.add(new JLabel("학번:"));
		
		JTextField text = new JTextField();
		toolBar.add(text);
		
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char ch = e.getKeyChar();
				if (!Character.isDigit(ch)) {
					e.consume();
					JOptionPane.showMessageDialog(null, ch + "는 숫자키가 아닙니다. \n숫자를 입력하세요.");
				}
			}
		});
		
		c.add(toolBar, BorderLayout.SOUTH);
		
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new TextApp();
	}
}
