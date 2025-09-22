package chapter3;

import java.util.Scanner;

public class Practice03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.print("양의 정수 입력>>");
			int number = sc.nextInt();
			
			if (number <= 0)
				continue;

			for (int i = 1; i <= number; i++) {
				for (int j = number; j >= i; j--) {
					System.out.print("*");
				}
				System.out.println();
			}
			return;
		}
		

	}
}
