package chapter10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter; // KeyAdapter 임포트
import java.awt.event.KeyEvent; // KeyEvent 임포트

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BlueBlock extends JFrame {
	private static final long serialVersionUID = 1L;

    // 25개의 셀을 저장할 배열
    private JPanel[][] cells = new JPanel[5][5]; 
    // 블록의 현재 위치 (초기 위치: 0, 0)
    private int blockRow = 0; 
    private int blockCol = 0; 

	public BlueBlock() {
		super("상하좌우 키로 블록 움직이기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container c = getContentPane();

		JPanel menual = new JPanel();
		menual.setBackground(Color.GRAY);

		JPanel main = new JPanel();
        
        // 1. GridLayout 설정 (5x5, 핑크색 선 1픽셀)
		main.setLayout(new GridLayout(5, 5, 1, 1));
		main.setBackground(Color.PINK); 

		c.add(menual, BorderLayout.NORTH);
		c.add(main, BorderLayout.CENTER);

		JLabel text = new JLabel("상하좌우 키로 블록을 이동시킬 수 있습니다.");
		menual.add(text);
        
        // 2. 바둑판 셀 구성 및 초기 블록 배치
        for (int r = 0; r < 5; r++) {
            for (int col = 0; col < 5; col++) {
                JPanel cell = new JPanel();
                cell.setBackground(Color.WHITE); 
                
                // 초기 블록 위치 설정 (0, 0)
                if (r == blockRow && col == blockCol) {
                    cell.setBackground(Color.BLUE);
                }
                
                cells[r][col] = cell; // 배열에 저장
                main.add(cell);
            }
        }
        
        // ⭐ 3. 키 리스너 추가 및 이벤트 처리
        c.setFocusable(true); // 컨테이너가 포커스를 받을 수 있도록 설정
        c.requestFocus(); // 컨테이너에 포커스를 요청 (키 이벤트를 받기 위함)
        
        c.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                moveBlock(e.getKeyCode()); // 키 코드에 따라 블록 이동 메서드 호출
            }
        });

		setSize(300, 300);
		setLocationRelativeTo(null); 
		setVisible(true);
	}

    /**
     * 키 코드에 따라 블록을 이동시키고 화면을 업데이트하는 메서드
     */
    private void moveBlock(int keyCode) {
        int nextRow = blockRow;
        int nextCol = blockCol;

        // 1. 이동할 다음 위치 계산
        switch (keyCode) {
            case KeyEvent.VK_UP:
                nextRow--;
                break;
            case KeyEvent.VK_DOWN:
                nextRow++;
                break;
            case KeyEvent.VK_LEFT:
                nextCol--;
                break;
            case KeyEvent.VK_RIGHT:
                nextCol++;
                break;
            default:
                return; // 상하좌우 키가 아니면 종료
        }

        // 2. 경계 검사: 5x5 범위 (0~4)를 벗어나는지 확인
        if (nextRow >= 0 && nextRow < 5 && nextCol >= 0 && nextCol < 5) {
            
            // 3. 현재 위치 블록을 흰색으로 변경 (이전 위치 지우기)
            cells[blockRow][blockCol].setBackground(Color.WHITE);

            // 4. 새 위치로 블록 위치 변수 업데이트
            blockRow = nextRow;
            blockCol = nextCol;

            // 5. 새 위치 블록을 파란색으로 변경 (블록 이동)
            cells[blockRow][blockCol].setBackground(Color.BLUE);
        }
    }

	public static void main(String[] args) {
		new BlueBlock();
	}
}