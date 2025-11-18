package chapter14;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class JFileExample extends JFrame {
	private static final long serialVersionUID = 1L;
	private BackgroundPanel bgPanel = new BackgroundPanel();
	

	public JFileExample() {
		super("메뉴로 배경 이미지 로딩하기");
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("파일");
		JMenuItem open = new JMenuItem("열기");

		fileMenu.add(open);
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
		add(bgPanel);
		
		open.addActionListener(e -> {
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(new File("/Users/yunjeongmin/Documents/java/workspace/chapter14/src/image"));
			int result = chooser.showOpenDialog(null);
			
			if (result == JFileChooser.APPROVE_OPTION) {
				File file = chooser.getSelectedFile();
				bgPanel.setImg(file.getAbsolutePath());
			}
			
			
		});
		
		setVisible(true);
	}
	
	class BackgroundPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		
		private Image img = null;
		
		public void setImg(String path) {
			img = new ImageIcon(path).getImage();
			repaint();
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			if (img != null)
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		}
		
	}

	public static void main(String[] args) {
		new JFileExample();
	}
}
