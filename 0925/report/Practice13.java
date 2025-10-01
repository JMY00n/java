package intro;

import java.util.Scanner;

class Seat {
	String sit;

	Seat() {
		sit = "---";
	}

	public String getSit() {
		return sit;
	}

	public void setSit(String name) {
		this.sit = name;
	}
}

class Line {
	Seat[] seats = new Seat[10];

	Line() {
		for (int i = 0; i < seats.length; i++) {
			seats[i] = new Seat();
		}
	}

	void show() {
		for (int i = 0; i < seats.length; i++) {
			System.out.print(seats[i].getSit() + " ");
		}
		System.out.println();
	}

	void search(String name, int no) {

	}

	void cancle(String name) {
		for (int i = 0; i < seats.length; i++) {
			if (seats[i].getSit().equals(name))
				seats[i].setSit("---");
		}
	}
}

public class Practice13 {
	public static void main(String[] args) {
		Line S = new Line();
		Line A = new Line();
		Line B = new Line();

		Scanner sc = new Scanner(System.in);
		System.out.println("명품콘서트홀 예약 시스템입니다.");

		while (true) {
			System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4 >>");
			int mainMenu = sc.nextInt();
			int no = 0;
			switch (mainMenu) {
			case 1: /* 예약 */
				System.out.print("좌석 구분 S(1), A(2), B(3)>> ");
				int subMenu = sc.nextInt();
				if (subMenu == 1) {
					System.out.print("이름>>");
					String inputName = sc.next();
					System.out.print("번호>>");
					no = sc.nextInt();
					S.seats[no - 1].setSit(inputName);
					System.out.print("S>> ");
					S.show();
				} else if (subMenu == 2) {
					System.out.print("이름>>");
					String inputName = sc.next();
					System.out.print("번호>>");
					no = sc.nextInt();
					A.seats[no - 1].setSit(inputName);

				} else if (subMenu == 3) {
					System.out.print("이름>>");
					String inputName = sc.next();
					System.out.print("번호>>");
					no = sc.nextInt();
					B.seats[no - 1].setSit(inputName);
				} else {
					System.out.print("올바르지 않은 선택입니다.");
				}
				break;
			case 2: /* 조회 */
				System.out.print("S>> ");
				S.show();

				System.out.print("A>> ");
				A.show();

				System.out.print("B>> ");
				B.show();

				System.out.println("<<<조회를 완료하였습니다.>>>");
				break;
			case 3: /* 취소 */
				System.out.print("좌석 구분 S(1), A(2), B(3)>> ");
				no = sc.nextInt();

				if (no == 1) { // S좌석 취소
					System.out.print("S>> ");
					S.show();
					System.out.print("이름>> ");
					S.cancle(sc.next());
				} else if (no == 2) { // A좌석 취소
					System.out.print("A>> ");
					A.show();
					System.out.print("이름>> ");
					A.cancle(sc.next());
				} else if (no == 3) { // B좌석 취소
					System.out.print("B>> ");
					B.show();
					System.out.print("이름>> ");
					B.cancle(sc.next());
				} else {
					System.out.println("잘못된 번호 입니다.");
				}
				break;
			case 4: /* 끝내기 */
				return;
			}
		}
	}
}
