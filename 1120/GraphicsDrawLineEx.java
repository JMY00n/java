package graphic;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawLineEx extends JFrame {
	private static final long serialVersionUID = 1L;
	private MyPanel panel = new MyPanel();

	public GraphicsDrawLineEx() {
		super("drawLine 사용 예제");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(200, 170);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.drawLine(20, 20, 100, 100);
		}
	}
	
	public static void main(String[] args) {
		new GraphicsDrawLineEx();
	}
}
