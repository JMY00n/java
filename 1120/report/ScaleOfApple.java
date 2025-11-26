package practice;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ScaleOfApple extends JFrame {
	private static final long serialVersionUID = 1L;
	private MyPanel panel = new MyPanel();

	public ScaleOfApple() {
		super("그래픽 이미지 확대 축소 연습");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 400);
		setContentPane(panel);
		setVisible(true);
		setLocationRelativeTo(null);

		panel.requestFocus();
	}

	public static void main(String[] args) {
		new ScaleOfApple();
	}

	class MyPanel extends JPanel {
		private static final long serialVersionUID = 1L;

		ImageIcon icon = new ImageIcon(getClass().getResource("/images/apple.jpg"));
		Image img = icon.getImage();

		// 이미지 원본 크기
		int imgWidth = icon.getIconWidth();
		int imgHeight = icon.getIconHeight();

		// 이미지 초기 위치
		int imgX = 100;
		int imgY = 100;

		public MyPanel() {
			// 패널이 키 입력을 받을 수 있도록 설정
			setFocusable(true);
			MyKeyboardListener listener = new MyKeyboardListener();
			addKeyListener(listener);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, imgX, imgY, imgWidth, imgHeight, this);
		}

		class MyKeyboardListener extends KeyAdapter {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyChar = e.getKeyChar(); // 눌린 키 가져오기
				int keyCode = e.getKeyCode();

				// Shift, Ctrl 은 무시하기
				if (keyCode == KeyEvent.VK_SHIFT || keyCode == KeyEvent.VK_CONTROL)
					return;

				if (keyChar == '+' || keyChar == '=') {
					/* 확대 */
					imgWidth += 10;
					imgHeight += 10;
					repaint();
				} else if (keyChar == '-') {
					/* 축소 */
					if (imgWidth > 10 && imgHeight > 10) {
						imgWidth -= 10;
						imgHeight -= 10;
						repaint();
					}
				} else {
					/* +, - 로만 기능을합니다. 라는 alert 창 표시 */
					JOptionPane.showMessageDialog(null, "+ 또는 - 키를 눌러주세요.");
				}
			}
		}
	}

}
