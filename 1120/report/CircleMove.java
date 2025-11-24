package chapter12;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CircleMove extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyPanel panel = new MyPanel();

	public CircleMove() {
		super("이미지 그리기 연습");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 350);
		setContentPane(panel);

		setVisible(true);
	}

	class MyPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		private ImageIcon icon = new ImageIcon(getClass().getResource("/images/back.jpg"));
		private Image img = icon.getImage();

		// 원의 좌표 및 크기
		private int x = (int) (Math.random() * 350) + 10;
		private int y = (int) (Math.random() * 300) + 10;
		private final int RADIUS = 20;

		// 드래그 상태 변수
		private boolean isDragging = false; // 현재 원을 잡고 있는지?
		private int offsetX, offsetY; // 클릭한 지점과 원의 시작점 사이의 거리
		
		public MyPanel() {
			// 마우스 이벤트
			MyMouseListener listener = new MyMouseListener();
			addMouseListener(listener);
			addMouseMotionListener(listener);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

			g.setColor(Color.GREEN);
			g.fillOval(x, y, RADIUS, RADIUS);
		}
		
		// 마우스 이벤트 처리하는 내부 클래스
		class MyMouseListener extends MouseAdapter {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getX() >= x && e.getY() <= x + RADIUS
						&& e.getY() >= y && e.getY() <= y + RADIUS) {
					isDragging = true; // 드래그 시작
					
					offsetX = e.getX() - x;
					offsetY = e.getY() - y;
				}
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				if (isDragging) {
					x = e.getX() - offsetX;
					y = e.getY() - offsetY;
					
					repaint();
				}
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				isDragging = false;
			}
		}

	}

	public static void main(String[] args) {
		new CircleMove();
	}
}
