package chapter10;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboActionEx extends JFrame {
	private static final long serialVersionUID = 1L;

	private String[] fruits = { "apple", "banana", "mango" };
	private ImageIcon[] images = { new ImageIcon("./image/apple.png"), new ImageIcon("./image/banana.png"),
			new ImageIcon("./image/mango.png") };
	private JLabel imgLabel = new JLabel(images[0]);

	public ComboActionEx() {
		super("콤보박스 활용 예제");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JComboBox<String> combo = new JComboBox<String>(fruits);
		c.add(combo);
		c.add(imgLabel);

		combo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox<String>) e.getSource();
				int index = cb.getSelectedIndex();
				imgLabel.setIcon(images[index]);
			}
		});

		setSize(600, 600);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ComboActionEx();
	}
}
