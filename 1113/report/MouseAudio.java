package chapter14;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseAudio extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jl = new JLabel();
	Clip clip;
	private int lastPos = 0; // 재생 위치 저장
	
	public MouseAudio() {
		super("오디오 시작 중단 연습");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 200);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(jl);
		
		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jl.setText("audio\\hiphop.wav 연주 계속");
				loadAudio("C:/Users/qa1pl/OneDrive/Desktop/workspace/example/src/audio/hiphop.wav");
				clip.setFramePosition(lastPos);
				clip.start();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				jl.setText("audio\\hiphop.wav 연주 일시 중단");
				if (clip != null && clip.isRunning())
					lastPos = clip.getFramePosition();
					clip.stop();
			}
		});
		
		setVisible(true);
		setLocationRelativeTo(null);	
	}
	
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
		new MouseAudio();
	}
}
