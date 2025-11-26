package practice;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CircleMake extends JFrame {
	private static final long serialVersionUID = 1L;

	public CircleMake() {
		super("마우스로 원 그리기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 400);

		add(new MyPanel());

		setVisible(true);
	}

	public static void main(String[] args) {
		new CircleMake();
	}

	class Circle {
		int x; // 중심 x
		int y; // 중심 y
		int r; // 반지름

		public Circle(int x, int y, int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}

	class MyPanel extends JPanel {
		private static final long serialVersionUID = 1L;

		Vector<Circle> v = new Vector<>();
		int startX, startY; // 중심
		int curX, curY; // 드래그 중 좌표
		boolean isDragging = false;

		public MyPanel() {
			MouseAdapter mouse = new MouseAdapter() {

				@Override
				public void mousePressed(MouseEvent e) {
					startX = e.getX();
					startY = e.getY();
					isDragging = true;
				}

				@Override
				public void mouseDragged(MouseEvent e) {
					curX = e.getX();
					curY = e.getY();
					repaint();
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					isDragging = false;

					int dx = e.getX() - startX;
					int dy = e.getY() - startY;
					int r = (int) Math.sqrt(dx * dx + dy * dy);

					v.add(new Circle(startX, startY, r));

					repaint();
				}
			};
			
			addMouseListener(mouse);
			addMouseMotionListener(mouse);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.setColor(Color.PINK);
			for (Circle c : v) {
				g.drawOval(c.x - c.r, c.y - c.r, c.r * 2, c.r * 2);
			}
			
			if (isDragging) {
                int dx = curX - startX;
                int dy = curY - startY;
                int r = (int) Math.sqrt(dx * dx + dy * dy);

                g.setColor(Color.RED);
                g.drawOval(startX - r, startY - r, r * 2, r * 2);
            }
		}

	}
}
