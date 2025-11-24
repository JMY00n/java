package graphic;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawImageEx extends JFrame {
	private static final long serialVersionUID = 1L;
	private MyPanel panel = new MyPanel();

	public GraphicsDrawImageEx() {
		super("원본 크기로 원하는 위치에 이미지 그리기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(panel);

		setSize(300, 420);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon(getClass().getResource("/images/bg.jpg"));
		private Image img = icon.getImage(); // 이미지 객체

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.drawImage(img, 20, 20, this);
		}

	}

	public static void main(String[] args) {
		new GraphicsDrawImageEx();
	}
}
