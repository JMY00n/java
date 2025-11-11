package practice;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GoBan extends JFrame {
	private static final long serialVersionUID = 1L;

	public GoBan() {
		setTitle("4x4 Color 프레임");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new GridLayout(4, 4));
		
		for (int i = 0; i < 16; i++) {
			Color[] cb = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA, Color.GRAY, Color.PINK, Color.LIGHT_GRAY, Color.WHITE, Color.BLACK, Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN};
			
			JLabel ja = new JLabel(i+"");
			ja.setOpaque(true);
			ja.setBackground(cb[i]);
			c.add(ja);
		}

		setSize(600, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GoBan();
	}
}
