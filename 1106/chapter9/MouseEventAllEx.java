package action;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseEventAllEx extends JFrame {
	private JLabel la = new JLabel(" Move Me");
	
	public MouseEventAllEx() {
		setTitle("MouseListener와 MouseMotionListener 예제");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		MyMouseListener listener = new MyMouseListener();
		c.addMouseListener(listener);
		c.addMouseMotionListener(listener);
		
		c.setLayout(null);
		
		la.setSize(80, 20);
		la.setLocation(100, 80);
		c.add(la);
		
		setSize(300, 200);
		setVisible(true);
	}
	
	class MyMouseListener implements MouseListener, MouseMotionListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			la.setLocation(e.getX(), e.getY());
			setTitle("mousePressed(" + e.getX() + ", " + e.getY() + ")");
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			la.setLocation(e.getX(), e.getY());
			setTitle("mouseReleased(" + e.getX() + ", " + e.getY() + ")");
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			Component comp = (Component)e.getSource();
			comp.setBackground(Color.cyan);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			Component comp = (Component)e.getSource();
			comp.setBackground(Color.yellow);
			setTitle("mouseExited(" + e.getX() + ", " + e.getY() + ")");
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			Component comp = (Component)e.getSource();
			setTitle("mouseDragged(" + e.getX() + ", " + e.getY() + ")");
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			Component comp = (Component)e.getSource();
			setTitle("mouseMoved(" + e.getX() + ", " + e.getY() + ")");
			
		}
		
	}
	public static void main(String[] args) {
		new MouseEventAllEx();
	}
}
