package practice;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridDraw extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private MyPanel panel = new MyPanel();

	public GridDraw() {
		super("격자 그리기 (자동 크기 조절)");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 400);
		setContentPane(panel);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		
		// 격자 간격 (변수로 관리하면 나중에 바꾸기 편해요)
		private int gridGap = 40; 

		public MyPanel() {
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			int width = getWidth();   // 현재 패널의 너비
			int height = getHeight(); // 현재 패널의 높이
			
			// [수직선 그리기]
			// x를 40부터 시작해서, 현재 너비(width)보다 작을 때까지 40씩 증가
			for (int x = gridGap; x < width; x += gridGap) {
				g.drawLine(x, 0, x, height);
			}
			
			// [수평선 그리기]
			// y를 40부터 시작해서, 현재 높이(height)보다 작을 때까지 40씩 증가
			for (int y = gridGap; y < height; y += gridGap) {
				g.drawLine(0, y, width, y);
			}
		}
	}

	public static void main(String[] args) {
		new GridDraw();
	}
}