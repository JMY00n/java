package chapter10;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButtonEx extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel imageJLabel = new JLabel(); // 이미지 표시할 컴포넌트

	private ImageIcon[] icons = new ImageIcon[3];

	JRadioButton car = new JRadioButton("자동차");
	JRadioButton boat = new JRadioButton("배");
	JRadioButton airplane = new JRadioButton("비행기");

	public RadioButtonEx() {
		super("라디오 버튼 만들기 예제");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel pn = new JPanel(new FlowLayout());
		ButtonGroup g = new ButtonGroup();
		
		MyItemListener listener = new MyItemListener();
		car.addItemListener(listener);
		boat.addItemListener(listener);
		airplane.addItemListener(listener);

		icons[0] = new ImageIcon("./image/car.png");
		icons[1] = new ImageIcon("./image/boat.png");
		icons[2] = new ImageIcon("./image/airplane.png");

		g.add(car);
		g.add(boat);
		g.add(airplane);

		pn.add(car);
		pn.add(boat);
		pn.add(airplane);

		c.add(pn, BorderLayout.NORTH);
		c.add(imageJLabel, BorderLayout.CENTER);
		
		setSize(500, 500);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	class MyItemListener implements ItemListener {
		ImageIcon selectedIcon = null;

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) { // 선택이 되면
				if (e.getItem() == car)
					selectedIcon = icons[0];
				else if (e.getItem() == boat)
					selectedIcon = icons[1];
				else if (e.getItem() == airplane)
					selectedIcon = icons[2];
				else
					System.out.println("지원하지 않는 항목입니다.");

				imageJLabel.setIcon(selectedIcon);
			}

		}
	}

	public static void main(String[] args) {
		new RadioButtonEx();
	}

}
