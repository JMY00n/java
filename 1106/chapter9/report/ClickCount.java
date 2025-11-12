package chapter10;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent; // ActionEvent 임포트
import java.awt.event.ActionListener; // ActionListener 임포트

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClickCount extends JFrame {
	private static final long serialVersionUID = 1L;

	public ClickCount() {
		super("클릭 횟수 카운트");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container c = getContentPane();
		JPanel main = new JPanel();
		main.setLayout(new FlowLayout());

		for (int i = 0; i < 5; i++) { // 버튼 5개 추가
			JButton btn = new JButton("0");
			
            // ⭐ 1. 버튼에 ActionListener 부착
            btn.addActionListener(new ActionListener() {
                // 2. actionPerformed 메서드 오버라이드 (버튼 클릭 시 실행)
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 이벤트가 발생한 버튼 객체를 가져옴
                    JButton clickedButton = (JButton)e.getSource();
                    
                    // 3. 현재 텍스트(String)를 가져와 숫자로 변환
                    String currentText = clickedButton.getText();
                    int count = Integer.parseInt(currentText);
                    
                    // 4. 숫자를 1 증가시킴
                    count++;
                    
                    // 5. 증가된 숫자를 다시 String으로 변환하여 버튼 텍스트로 설정
                    clickedButton.setText(String.valueOf(count));
                }
            });
            
			main.add(btn);
		}

		c.add(main);

		setSize(300, 100);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ClickCount();
	}
}