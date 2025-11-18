package chapter14;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class AudioPlayer extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel text = new JLabel();
	private String currentAudioName;

	private JMenuBar toolBar = new JMenuBar();
	private JMenu audioMenu = new JMenu();
	private JMenuItem play = new JMenuItem();
	private JMenuItem exit = new JMenuItem();

	private Clip clip;

	public AudioPlayer() {
		super("오디오 파일을 찾아 연주/종료 제어");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container c = getContentPane();

		text.setText("오디오 파일을 선택하세요.");
		text.setHorizontalAlignment(SwingConstants.CENTER);
		c.add(text, BorderLayout.NORTH);

		createMenuBar();

		setSize(600, 300);
		setVisible(true);
	}

	private void createMenuBar() {
		audioMenu.setText("오디오");
		play.setText("연주");
		exit.setText("종료");

		audioMenu.add(play);
		audioMenu.add(exit);

		exit.addActionListener(new ExitActionListener());
		play.addActionListener(new OpenActionListener());

		toolBar.add(audioMenu);
		setJMenuBar(toolBar);
	}

	// 종료 이벤트
	class ExitActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			clip.stop();
			clip.setFramePosition(0);
			text.setText("오디오 파일을 선택하세요.");
		}

	}

	// 연주 텍스트 클릭하면 file chooser 열기
	class OpenActionListener implements ActionListener {
		private JFileChooser chooser;

		public OpenActionListener() {
			chooser = new JFileChooser("C:/Users/qa1pl/OneDrive/Desktop/workspace/example/src/audio");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			int result = chooser.showOpenDialog(null);
			if (result == JFileChooser.APPROVE_OPTION) {
				String filePath = chooser.getSelectedFile().getPath();
				currentAudioName = chooser.getSelectedFile().getName();

				loadAudio(filePath);
				clip.start();

				text.setText(currentAudioName + " 를 연주하고 있습니다.");
			}
		}

	}

	// 연주
	private void loadAudio(String pathName) {
		try {
			clip = AudioSystem.getClip();
			File audioFile = new File(pathName);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			clip.open(audioStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new AudioPlayer();
	}
}
