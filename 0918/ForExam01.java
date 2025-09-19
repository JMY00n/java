package chapter3;

import java.util.Scanner;

class ForExam01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		
		System.out.print("정수 입력 : ");
		int number = sc.nextInt();
		
		for (int i = 1; i <= number; i++) {
			sum += i;
		}
		
		System.out.println(sum);
		
		sc.close();
	}
}