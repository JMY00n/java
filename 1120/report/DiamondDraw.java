package practice;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DiamondDraw extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private MyPanel panel = new MyPanel();

	public DiamondDraw() {
		super("그래픽 다각형 연습");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 400);
		setContentPane(panel);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		private static final long serialVersionUID = 1L;

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			int w = getWidth();  // 패널 전체 너비
			int h = getHeight(); // 패널 전체 높이
			
			int centerX = w / 2; // 중심점 x
			int centerY = h / 2; // 중심점 y
			
			// 10개의 마름모 그리기
			for (int i = 1; i <= 10; i++) {
				
				// [핵심 공식]
				// 전체 반지름(w/2)을 10등분 한 뒤, i번째 크기를 구함
				// i가 10일 때: (w / 2) * 1 -> 화면 끝에 딱 맞음
				int currentRadiusX = (w / 2) * i / 10;
				int currentRadiusY = (h / 2) * i / 10;
				
				int[] xPoints = {
					centerX, 				 // 상
					centerX + currentRadiusX,// 우 (중심 + 가로반지름)
					centerX, 				 // 하
					centerX - currentRadiusX // 좌 (중심 - 가로반지름)
				};
				
				int[] yPoints = {
					centerY - currentRadiusY,// 상 (중심 - 세로반지름)
					centerY, 				 // 우
					centerY + currentRadiusY,// 하 (중심 + 세로반지름)
					centerY 				 // 좌
				};
				
				g.drawPolygon(xPoints, yPoints, 4);
			}
		}
	}

	public static void main(String[] args) {
		new DiamondDraw();
	}
}