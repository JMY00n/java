package chapter12;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HideAndShow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyPanel panel = new MyPanel();
	private JButton btn = new JButton("Hide/Show");

	public HideAndShow() {
		super("이미지 그리기 연습");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 350);
		setContentPane(panel);

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.toggleImage();
			}
		});

		add(btn);

		setVisible(true);
	}

	class MyPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		private ImageIcon icon = new ImageIcon(getClass().getResource("/images/back.jpg"));
		private Image img = icon.getImage();

		private boolean isShow = true;

		public void toggleImage() {
			isShow = !isShow;
			repaint();
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			if (isShow) {
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			}
		}

	}

	public static void main(String[] args) {
		new HideAndShow();
	}
}
