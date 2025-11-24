package graphic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawLineMouseEx extends JFrame {
	private static final long serialVersionUID = 1L;

	private MyPanel2 panel = new MyPanel2();

	public GraphicsDrawLineMouseEx() {
		super("drawing Line by Mouse Ex");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(panel);

		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GraphicsDrawLineMouseEx();
	}
}

class MyPanel2 extends JPanel {
	private static final long serialVersionUID = 1L;
	private Vector<Point> vStart = new Vector<Point>();
	private Vector<Point> vEnd = new Vector<Point>();
	
	public MyPanel2() {
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Point startP = e.getPoint();
				vStart.add(startP);
			}
			
			public void mouseReleased(MouseEvent e) {
				Point endP = e.getPoint();
				vEnd.add(endP);
				
				repaint();
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		
		for (int i = 0; i < vStart.size(); i++) {
			Point s = vStart.elementAt(i);
			Point e = vEnd.elementAt(i);
			
			g.drawLine((int) s.getX(), (int) s.getY(), (int) e.getX(), (int) e.getY());
		}
	}
}
