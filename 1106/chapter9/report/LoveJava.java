package chapter10;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoveJava extends JFrame {
	private JLabel la = new JLabel("사랑해");
	private static final long serialVersionUID = 1L;
	
	public LoveJava() {
		super("마우스 올리기 내리기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(la);
		
		la.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				JLabel b = (JLabel)e.getSource();
				b.setText("Love Java");
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				JLabel b = (JLabel)e.getSource();
				b.setText("사랑해 자바");
			}
		});
		
		setSize(400, 400);
		setVisible(true);
		c.setFocusable(true);
		c.requestFocus();
	}

	public static void main(String[] args) {
		new LoveJava();
	}
}
