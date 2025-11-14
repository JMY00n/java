package chapter14;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CoffeeApp extends JFrame {
	private static final long serialVersionUID = 1L;

	private NorthPanel np = new NorthPanel();
	private CenterPanel cp = new CenterPanel();
	private SouthPanel sp = new SouthPanel();

	public CoffeeApp() {
		super("Open Challenge 14");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container c = getContentPane();

		c.add(np, BorderLayout.NORTH);
		c.add(cp, BorderLayout.CENTER);
		c.add(sp, BorderLayout.SOUTH);

		setSize(600, 400);
		setVisible(true);
	}

	class NorthPanel extends JPanel {
		private static final long serialVersionUID = 1L;

		private JLabel jl = new JLabel("WelCome, Hot Coffee!!");

		NorthPanel() {
			setBackground(Color.PINK);
			add(jl);
		}
	}

	class CenterPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		String[] kinds = { "Cup", "Coffee", "Water", "Sugar", "Cream" };
		int[] heights = { 200, 200, 200, 200, 200 };
		final int MAX_HEIGHT = 200;

		public CenterPanel() {
			setBackground(Color.WHITE);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			int rectWidth = 60;
			int gap = 40;
			int totalWidth = kinds.length * rectWidth + (kinds.length - 1) * gap;
			int startX = (getWidth() - totalWidth) / 2;
			int yBase = getHeight() - 80;

			g.setFont(new Font("맑은 고딕", Font.BOLD, 14));

			for (int i = 0; i < kinds.length; i++) {
				int x = startX + i * (rectWidth + gap);
				int height = heights[i];

				g.setColor(Color.GRAY);
				g.fillRect(x, yBase - height, rectWidth, height);

				g.setColor(Color.GRAY);
				g.drawRect(x, yBase - MAX_HEIGHT, rectWidth, MAX_HEIGHT);

				g.setColor(Color.BLACK);
				g.drawString(kinds[i], x + 5, yBase + 20);

			}
		}
	}

	class SouthPanel extends JPanel {
		private static final long serialVersionUID = 1L;

		public SouthPanel() {
			JButton blackBtn = new JButton("Black Coffee");
			JButton sugarBtn = new JButton("Sugar Coffee");
			JButton dabangBtn = new JButton("Dabang Coffee");
			JButton resetBtn = new JButton("Reset");

			setLayout(new FlowLayout());

			blackBtn.addActionListener(new MyActionListener(cp, "blackBtn"));
			sugarBtn.addActionListener(new MyActionListener(cp, "sugarBtn"));
			dabangBtn.addActionListener(new MyActionListener(cp, "dabangBtn"));
			resetBtn.addActionListener(new MyActionListener(cp, "resetBtn"));

			add(blackBtn);
			add(sugarBtn);
			add(dabangBtn);
			add(resetBtn);
		}
	}

	class MyActionListener implements ActionListener {
		private CenterPanel cp;
		private String type;
		JOptionPane jp = new JOptionPane();

		public MyActionListener(CenterPanel cp, String type) {
			this.cp = cp;
			this.type = type;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			int[] h = cp.heights; // 재료 높이 배열 접근
			int max = cp.MAX_HEIGHT;

			switch (type) { // 버튼 종류에 따라
			case "blackBtn":
				h[0] -= max * 0.1;
				h[1] -= max * 0.2;
				h[2] -= max * 0.2;
				JOptionPane.showMessageDialog(null, "주문하신 Black Coffee 나왔습니다.");
				break;

			case "sugarBtn":
				h[0] -= max * 0.1;
				h[1] -= max * 0.2;
				h[2] -= max * 0.2;
				h[3] -= max * 0.2;
				JOptionPane.showMessageDialog(null, "주문하신 Sugar Coffee 나왔습니다.");
				break;
			case "dabangBtn":
				h[0] -= max * 0.1;
				h[1] -= max * 0.2;
				h[2] -= max * 0.2;
				h[3] -= max * 0.2;
				h[4] -= max * 0.2;
				JOptionPane.showMessageDialog(null, "주문하신 Dabang Coffee 나왔습니다.");
				break;
			case "resetBtn":
				for (int i = 0; i < h.length; i++) {
					h[i] = max;
				}
				break;

			}

			boolean shortage = false;

			for (int i = 0; i < h.length; i++) {
				if (h[i] <= 0) {
					shortage = true;
					break; // 하나라도 재료가 부족하면 더 검사할 필요 없음
				}
			}
			if (shortage) {
				JOptionPane.showMessageDialog(null, "재료가 부족합니다.");
			}
			
			// 높이 음수 방지
			for (int i = 0; i < h.length; i++) {
				if (h[i] < 0) {
					h[i] = 0;
					shortage = true;
				}
			}

			cp.repaint();
		}

	}

	public static void main(String[] args) {
		new CoffeeApp();
	}
}
