package chapter10;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JComponentEx extends JFrame {
	private static final long serialVersionUID = 1L;

	public JComponentEx() {
		super("JComponent의 공통 메서드 예제");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JButton b1 = new JButton("Magenta/Yellow Button");
		JButton b2 = new JButton("Disabled Button");
		JButton b3 = new JButton("getX(), getY()");

		b1.setOpaque(true);
		b1.setBorderPainted(false);
		b1.setForeground(Color.MAGENTA);
		b1.setBackground(Color.YELLOW);
		b1.setFont(new Font("Arial", Font.ITALIC, 20));
		b1.setPreferredSize(new Dimension(200, 50));

		b2.setEnabled(false);
		b2.setPreferredSize(new Dimension(200, 50));

		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				setTitle(b.getX() + ", " + b.getY());
			}
		});
		b3.setPreferredSize(new Dimension(200, 50));
		
		c.add(b1);
		c.add(b2);
		c.add(b3);
		
		setSize(260, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new JComponentEx();
	}
}
