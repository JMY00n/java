package chapter14;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AudioPrac extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel title = new JLabel("체크된 곡만 순서대로 한 번 연주합니다.");
	
	private String[] audioNames = {
			"drum.wav", "hiphop.wav", "police_siren.wav", "wolf_houl.wav"
	};
	private JCheckBox[] item = new JCheckBox[audioNames.length];
	
	private JPanel north = new JPanel();
	private JPanel center = new JPanel();
	private JPanel south = new JPanel();
	
	private JButton playBtn = new JButton("연주시작");
	private JButton stopBtn = new JButton("연주 끝");
	
	private Clip clip;
	private Thread playThread;
	private volatile boolean isPlaying = false;
	
	private void startPlay() {
		if (isPlaying) return;
		
		java.util.List<String> list = new java.util.ArrayList<>();
	    for (int i = 0; i < item.length; i++) {
	        if (item[i].isSelected()) {
	            list.add(audioNames[i]);
	        }
	    }
	    
	    if (list.isEmpty()) {
	        System.out.println("선택된 파일 없음!");
	        return;
	    }
	    
	    isPlaying = true;
	    
	    playThread = new Thread(() -> {
	        try {
	            for (String name : list) {
	                if (!isPlaying) break; // 중간에 Stop 누르면 빠져나옴
	                playOne(name);
	            }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        } finally {
	            isPlaying = false;
	        }
	    });

	    playThread.start();

	}

	private void playOne(String fileName) {
	    try {
	        // clip이 이미 있다면 정지 후 해제
	        if (clip != null && clip.isOpen()) {
	            clip.stop();
	            clip.close();
	        }

	        java.net.URL url = getClass().getResource("/audio/" + fileName);
	        System.out.println("URL = " + url);

	        AudioInputStream stream = AudioSystem.getAudioInputStream(url);
	        clip = AudioSystem.getClip();
	        clip.open(stream);

	        clip.start();
	        Thread.sleep(50);
	        // 재생이 끝날 때까지 대기
	        while (clip.isRunning() && isPlaying) {
	            Thread.sleep(100);
	        }

	        clip.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	private void stopPlay() {
	    isPlaying = false;

	    if (clip != null) {
	        clip.stop();
	        clip.close();
	    }
	}
	
	public AudioPrac() {
		super("오디오 연주");
		setSize(500, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		north.setBackground(Color.GRAY);
		north.add(title);
		
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		for (int i = 0; i < audioNames.length; i++) {
			item[i] = new JCheckBox(audioNames[i]);
			item[i].setAlignmentX(Component.CENTER_ALIGNMENT);
			center.add(item[i]);
			center.add(Box.createVerticalStrut(20));
		}
		
		south.setLayout(new FlowLayout());
		south.add(playBtn);
		south.add(stopBtn);
		
		playBtn.addActionListener(e -> startPlay());
		stopBtn.addActionListener(e -> stopPlay());
		
		c.add(north, BorderLayout.NORTH);
		c.add(center, BorderLayout.CENTER);
		c.add(south, BorderLayout.SOUTH);

		setVisible(true);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new AudioPrac();
	}
}
