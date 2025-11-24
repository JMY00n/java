package chapter12;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageMove extends JFrame {
	private static final long serialVersionUID = 1L;
	private MyPanel panel = new MyPanel();

	public ImageMove() {
		super("이미지 레이블 드래깅 연습");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 400);
		setContentPane(panel);

		setVisible(true);
	}

	public class MyPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		private ImageIcon icon = new ImageIcon(getClass().getResource("/images/apple.jpg"));
		private Image img = icon.getImage();

		// 이미지 위치 저장
		private int imageX = 150;
		private int imageY = 150;
		private int imgWidth = icon.getIconWidth();
		private int imgHeight = icon.getIconHeight();

		// 드래깅 상태 관리
		private boolean isDragging = false;
		private int offsetX, offsetY; // 마우스 클릭 위치와 이미지 좌측 상단 모서리의 거리

		public MyPanel() {
			MyMouseListener listener = new MyMouseListener();
			addMouseListener(listener);
			addMouseMotionListener(listener);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, imageX, imageY, imgWidth, imgHeight, this);
		}

		class MyMouseListener extends MouseAdapter {

			@Override
			public void mousePressed(MouseEvent e) {
				// 클릭한 위치가 이미지 영역 내부인지 확인 (x와 y 좌표 모두 범위 안에 있어야 함)
				if (e.getX() >= imageX && e.getX() <= imageX + imgWidth && e.getY() >= imageY
						&& e.getY() <= imageY + imgHeight) {

					isDragging = true; // 드래그 시작

					// 보정값(Offset) 계산: 클릭 지점과 이미지 시작점(imageX, imageY)의 차이
					offsetX = e.getX() - imageX;
					offsetY = e.getY() - imageY;
				}
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				if (isDragging) {
					imageX = e.getX() - offsetX;
					imageY = e.getY() - offsetY;

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
		new ImageMove();
	}

}
