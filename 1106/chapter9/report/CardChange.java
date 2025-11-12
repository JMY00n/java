package chapter10;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font; // 폰트 임포트 (숫자 잘 보이게)
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants; // 텍스트 중앙 정렬을 위해 임포트

public class CardChange extends JFrame {
	private static final long serialVersionUID = 1L;

	// ⭐ 1. 선택된 첫 번째 카드를 저장하는 멤버 변수
	private JPanel firstCard = null;

	// ⭐ 2. 모든 카드 패널을 저장할 배열
	private JPanel[] cards = new JPanel[12];

	// ⭐ 3. 하이라이트 색상 (보라색에 가까운 MAGENTA 사용)
	private static final Color HIGHLIGHT_COLOR = Color.MAGENTA;
	// ⭐ 4. 기본 카드 색상
	private static final Color DEFAULT_COLOR = Color.YELLOW;

	public CardChange() {
		super("카드 스위치 게임");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container c = getContentPane();
		JPanel main = new JPanel();

		// 3행, 4열, 간격 10, 10
		main.setLayout(new GridLayout(3, 4, 10, 10));
		main.setBackground(Color.WHITE); // 간격 색상을 흰색으로

		c.add(main);

		for (int i = 0; i < 12; i++) {
			JPanel cardCell = new JPanel();
			cardCell.setBackground(DEFAULT_COLOR); // 기본 카드 색상 (노란색)

			// ⭐ 5. 1부터 12까지의 숫자를 가진 JLabel 생성
			JLabel numberLabel = new JLabel(String.valueOf(i + 1));
			numberLabel.setFont(new Font("Arial", Font.BOLD, 20)); // 숫자 강조
			numberLabel.setHorizontalAlignment(SwingConstants.CENTER); // 텍스트 중앙 정렬

			cardCell.add(numberLabel); // 카드 셀에 숫자 추가

			// ⭐ 6. 배열에 저장
			cards[i] = cardCell;

			// ⭐ 7. MouseListener 부착
			cardCell.addMouseListener(new CardClickListener());

			main.add(cardCell);
		}

		setSize(400, 300);
		setLocationRelativeTo(null); // 창 중앙 배치
		setVisible(true);
	}

	// =======================================================
	// 8. 카드 클릭 이벤트 처리 클래스
	// =======================================================
	private class CardClickListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			JPanel clickedCard = (JPanel) e.getSource();

			// 이미 선택된 카드라면 무시
			if (clickedCard == firstCard) {
				return;
			}

			// --- 첫 번째 카드 선택 ---
			if (firstCard == null) {
				firstCard = clickedCard;
				firstCard.setBackground(HIGHLIGHT_COLOR); // 보라색으로 하이라이트

			}
			// --- 두 번째 카드 선택 및 교환 ---
			else {
				// 두 번째 카드를 현재 클릭된 카드로 설정
				JPanel secondCard = clickedCard;

				// 두 카드의 내용을 교환하는 메서드 호출
				swapCardContent(firstCard, secondCard);

				// 교환 후 하이라이트 해제 및 상태 초기화
				firstCard.setBackground(DEFAULT_COLOR);
				secondCard.setBackground(DEFAULT_COLOR);
				firstCard = null; // 선택 상태 초기화
			}
		}
	}

	/**
	 * 두 카드(JPanel)에 들어있는 JLabel의 텍스트(숫자)를 교환합니다.
	 */
	private void swapCardContent(JPanel card1, JPanel card2) {
		// card1과 card2는 각각 하나의 JLabel을 가지고 있습니다.

		// 1. JLabel 객체와 텍스트를 가져옴
		JLabel label1 = (JLabel) card1.getComponent(0);
		JLabel label2 = (JLabel) card2.getComponent(0);

		String text1 = label1.getText();
		String text2 = label2.getText();

		// 2. 텍스트 교환
		label1.setText(text2);
		label2.setText(text1);
	}

	public static void main(String[] args) {
		new CardChange();
	}
}