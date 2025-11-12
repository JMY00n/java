package chapter10;

import java.awt.BorderLayout; // BorderLayout 임포트 추가
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension; // Dimension 임포트 추가
import java.awt.FlowLayout; // FlowLayout 임포트 추가

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel; // JLabel 임포트 추가 (숫자 표시용)
import javax.swing.JPanel;

public class OpenChallenge extends JFrame {
	private static final long serialVersionUID = 1L;

	public OpenChallenge() {
		super("홀짝 게임");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
      
		JPanel pcWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 30)); 
		pcWrapper.setBackground(Color.LIGHT_GRAY); // 중앙 배경색 확인용
		
		JPanel card = new JPanel();
		int cardWitdh = 100;
		int cardHeight = 100;
		card.setBackground(Color.PINK);
        
		card.setPreferredSize(new Dimension(cardWitdh, cardHeight)); 
        
        JLabel numLabel = new JLabel("42", JLabel.CENTER); 
        card.add(numLabel);
		
		JPanel ps = new JPanel();
		ps.setBackground(Color.YELLOW);
        
        ps.add(new JButton("홀"));
        ps.add(new JButton("짝"));
		
        c.add(pcWrapper, BorderLayout.CENTER); // 중앙 래퍼 패널을 CENTER에 넣어 남은 공간을 차지
		c.add(ps, BorderLayout.SOUTH); // 버튼 패널을 하단에 고정
		
		setSize(300, 230);
		setLocationRelativeTo(null); 
		setVisible(true);
	}

	public static void main(String[] args) {
		new OpenChallenge();
	}
}