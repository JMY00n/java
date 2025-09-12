package chapter2;

import java.util.Scanner;

public class Practice05 {
	public static void main(String[] args) {
		/* 출석 점수가 총 100점일 때, 지각하면 3점 감점, 결석하면 8점 감점.
		 * 두 학생 중 누구의 출석점수가 더 높은지 판단하는 프로그램 작성. 점수가 같은 경우 "점수 동일" 출력 */
		Scanner sc = new Scanner(System.in);
		
		System.out.print("학생1>>");
		String stu1 = sc.next();
		int late1 = sc.nextInt();
		int absense1 = sc.nextInt();
		int total1 = 0;
		
		System.out.print("학생1>>");
		String stu2 = sc.next();
		int late2 = sc.nextInt();
		int absense2 = sc.nextInt();
		int total2 = 0;
		
		// 각 학생의 total에 감점 점수 누적
		total1 = (late1*3) + (absense1*8);
		total2 = (late2*3) + (absense2*8);
		
		System.out.println(stu1+"의 감점은 " + total1 + ", "+stu2+"의 감점은 " + total2);
		
		// 출석 점수 비교후 높은 사람 점수 출력
		if (total1 > total2) {
			System.out.println(stu2+"의 출석 점수가 더 높음. "+stu2+" 출석 점수는 " + (100-total2));
		} else if (total2 > total1) {
			System.out.println(stu1+"의 출석 점수가 더 높음. "+stu1+" 출석 점수는 " + (100-total1));
		} else {
			System.out.println("점수 동일");
		}
		
		sc.close();
	}
}
