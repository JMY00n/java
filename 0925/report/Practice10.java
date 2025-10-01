package intro;

import java.util.Scanner;

class DayDiary {
	String work;

	public void setWork(String work) {
		this.work = work;
	}

	public String getWork() {
		return work;
	}
	
	public String show() {
		if (work == null)
			return "...";
		else
			return work;
	}
}

class MonthDiary {
	DayDiary[] days = new DayDiary[30];
	Scanner sc = new Scanner(System.in);
	int year;
	int month;
	
	MonthDiary(int month, int year) {
		this.month = month;
		this.year = year;
		
		for (int i = 0; i < days.length; i++) {
			days[i] = new DayDiary();
		}
	}

	public void input() {
		System.out.print("날짜(1~30)와 텍스트(빈칸없이 4글자이하)>>");
		int day = sc.nextInt();
		String work = sc.next();
		days[day - 1].setWork(work);
	}

	public void view() {
		for (int i = 0; i < days.length; i++) {
			System.out.print(days[i].show() + "\t");
			if ((i + 1) % 7 == 0)
				System.out.println(); // 7일 마다 줄바꿈
		}
		System.out.println();
	}
	
	public void finish() {
		System.out.println("==== 전체 일정 ====");
		view();
		System.out.println("프로그램을 종료합니다.");
		sc.close();
	}
	
	public void run() {
		System.out.println("***** "+year+"년 "+month+"월 다이어리 *****");
		while (true) {
			System.out.print("기록:1, 보기:2, 종료:3>> ");
			int menu = sc.nextInt();
			switch (menu) {
			case 1: input(); break;
			case 2: view(); break;
			case 3: finish(); return;
			default: System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

}

public class Practice10 {
	public static void main(String[] args) {
		MonthDiary monthDiary = new MonthDiary(2024, 10);
		monthDiary.run();
	}
}
