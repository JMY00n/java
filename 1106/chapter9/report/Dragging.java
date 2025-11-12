package chapter10;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;

public class Dragging extends JFrame {
	private static final long serialVersionUID = 1L;

	public Dragging() {
		super("드래깅동안 YELLOW");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setBackground(Color.GREEN);

		c.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Container c = (Container) e.getSource();
				c.setBackground(Color.YELLOW);
			}
		});

		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Container c = (Container) e.getSource();
				c.setBackground(Color.GREEN);
			}
		});

		setSize(400, 400);
		setVisible(true);
		c.setFocusable(true);
		c.requestFocus();
	}

	public static void main(String[] args) {
		new Dragging();
	}
}
