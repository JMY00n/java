package chapter10;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter; // KeyAdapter 대신 MouseAdapter 사용
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent; // MouseWheelEvent 임포트

import javax.swing.JFrame;
import javax.swing.JLabel;

public class JavaLove extends JFrame {
	// JLabel은 멤버 변수로 유지
	private JLabel la = new JLabel("Love Java");
	private static final long serialVersionUID = 1L;
	
	public JavaLove() {
		super("마우스 휠로 폰트 크기 조절");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
        // ⭐ 초기 폰트 크기 설정
		la.setFont(new Font("Arial", Font.PLAIN, 15)); 
		c.add(la);
		
		// ----------------------------------------------------
		// ⭐ KeyListener 대신 MouseAdapter (MouseWheelListener) 사용
		// ----------------------------------------------------
        // 컨테이너가 마우스 이벤트를 받을 수 있도록 리스너 부착
		c.addMouseWheelListener(new MouseAdapter() {
			
            // MouseWheelEvent 발생 시 호출되는 메서드를 오버라이드
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				Font f = la.getFont();
				int size = f.getSize();
                
                // 스크롤 방향을 나타내는 값. 
                // 음수: 휠 위로 (확대), 양수: 휠 아래로 (축소)
				int notches = e.getWheelRotation();
                
                // 휠 1회당 증가/감소할 크기
                final int STEP = 5; 

                if (notches < 0) {
                    // 휠 위로 스크롤 (폰트 크기 증가)
                    int newSize = size + STEP;
                    la.setFont(new Font("Arial", Font.PLAIN, newSize));
                    System.out.println("폰트 크기 증가: " + newSize);
                    
                } else if (notches > 0) {
                    // 휠 아래로 스크롤 (폰트 크기 감소)
                    // 최소 크기 제한 (예: 5픽셀)
                    if (size > STEP) { 
                        int newSize = size - STEP;
                        la.setFont(new Font("Arial", Font.PLAIN, newSize));
                        System.out.println("폰트 크기 감소: " + newSize);
                    } else {
                         System.out.println("최소 크기에 도달했습니다.");
                    }
                }
                
                // 화면 갱신을 위해 repaint() 호출 (FlowLayout에서는 필요 없을 수 있으나 안전을 위해 호출)
                c.repaint();
			}
		});
		
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
        
        // ⭐ 마우스 휠 이벤트는 포커스와 무관하므로 requestFocus()가 필요 없습니다.
        // 하지만 혹시 다른 이벤트 처리(키보드)가 필요할 경우를 대비하여 그대로 두어도 무방합니다.
	}
	
	
	public static void main(String[] args) {
		new JavaLove();
	}
}