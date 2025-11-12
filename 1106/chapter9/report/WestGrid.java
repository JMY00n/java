package chapter10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter; // MouseAdapter 임포트
import java.awt.event.MouseEvent;   // MouseEvent 임포트
import java.util.ArrayList;         // ArrayList 임포트

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WestGrid extends JFrame {
	private static final long serialVersionUID = 1L;

    // ⭐ 1. CENTER 패널의 모든 숫자를 저장할 리스트를 멤버 변수로 선언
    private ArrayList<JLabel> numberLabels = new ArrayList<>();
    
    // ⭐ 2. CENTER 패널 (pc)을 멤버 변수로 선언하여 다른 메서드에서 접근 가능하게 함
    private JPanel pc; 

	public WestGrid() {
		setTitle("West Grid 프레임");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container c = getContentPane();
		JPanel pw = new JPanel();
		pc = new JPanel(); // 멤버 변수로 사용
		
        // NORTH, SOUTH 영역을 사용하지 않으므로 CENTER가 남은 공간을 모두 차지합니다.

		// 패널 레이아웃 설정
		pw.setLayout(new GridLayout(10, 0)); // 10행 1열
		pc.setLayout(null); // 절대 배치

		c.add(pw, BorderLayout.WEST);
		c.add(pc, BorderLayout.CENTER);

        // =======================================================
        // A. WEST 패널 (색상 블록) 구현 및 MouseListener 추가
        // =======================================================
		for (int i = 0; i < 10; i++) {
			int r = (int) (Math.random() * 256);
			int g = (int) (Math.random() * 256);
			int b = (int) (Math.random() * 256);
			Color color = new Color(r, g, b);

			JLabel empty = new JLabel("         "); // 폭 확보용 텍스트
			empty.setBackground(color);
			empty.setOpaque(true);
            
            // ⭐ MouseListener 추가: 클릭 시 숫자의 전경색 변경
            empty.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // 클릭된 JLabel의 배경색을 가져옴
                    Color newColor = empty.getBackground();
                    
                    // 모든 숫자의 전경색(글자색)을 변경하는 메서드 호출
                    changeNumberColor(newColor);
                }
            });
            
			pw.add(empty);
		}

        // =======================================================
        // B. CENTER 패널 (랜덤 숫자) 구현
        // =======================================================
		for (int i = 0; i < 9; i++) {
			String number = Integer.toString(i);
			JLabel printNum = new JLabel(number);

            // 초기 위치 설정
			int x = (int) ((Math.random() * 200) + 50);
			int y = (int) ((Math.random() * 200) + 50);

			printNum.setLocation(x, y);
			printNum.setSize(10, 10);
			printNum.setForeground(Color.RED); 
            
            // ⭐ 1. 숫자를 리스트에 저장
            numberLabels.add(printNum);
			pc.add(printNum);
		}
        
        // =======================================================
        // C. CENTER 패널 MouseListener 추가 (위치 재배치)
        // =======================================================
        pc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 패널 클릭 시 모든 숫자를 랜덤 재배치
                repositionNumbers();
            }
        });

		setSize(300, 300);
		setVisible(true);
	}
    
    // =======================================================
    // D. 기능 메서드
    // =======================================================

    /**
     * CENTER 패널에 있는 모든 숫자의 전경색을 변경합니다.
     */
    private void changeNumberColor(Color newColor) {
        for (JLabel label : numberLabels) {
            label.setForeground(newColor);
        }
    }
    
    /**
     * CENTER 패널에 있는 모든 숫자를 랜덤 위치로 재배치합니다.
     */
    private void repositionNumbers() {
        // CENTER 패널의 현재 크기를 가져옵니다. (setTitle 바와 테두리 제외)
        int panelWidth = pc.getWidth();
        int panelHeight = pc.getHeight();
        
        for (JLabel label : numberLabels) {
            // ⭐ 패널 크기 범위 내에서 새로운 랜덤 좌표를 계산합니다.
            // (숫자 JLabel 크기 10x10을 고려하여 10을 줍니다.)
            int newX = (int) (Math.random() * (panelWidth - 10));
            int newY = (int) (Math.random() * (panelHeight - 10));
            
            label.setLocation(newX, newY);
        }
        
        // 화면 갱신 요청
        pc.repaint();
    }


	public static void main(String[] args) {
		new WestGrid();
	}
}