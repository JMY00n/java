package chapter3;

import java.util.Scanner;

public class WhileExam02 {
	public static void main(String[] args) {
		int count = 0;
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("-1을 입력하기 전까지의 합과 평균을 구합니다.");
		System.out.print("정수 입력 : ");
		int number = sc.nextInt();
		
		while (number != -1) {
			sum += number;
			count++;
			number = sc.nextInt();
		}
		if (count == 0) System.out.print("입력된 숫자가 없습니다.");
		else {
			System.out.println("입력된 정수의 개수는 " + count + "개 입니다.");
			System.out.println("정수들의 합 = " + sum + ", 평균 = " + (double)sum/count);
		}
		
		sc.close();
	}
}
