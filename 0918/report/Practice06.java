package chapter3;

import java.util.Scanner;

public class Practice06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		System.out.print("양의 정수 10개 입력>>");

		for (int i = 0; i < 10; i++) {
			int number = sc.nextInt();
			arr[i] = number;
		}

		System.out.print("각 자리수의 합이 9인 수...");
		for (int n : arr) {
			int sum = 0;
			String s = String.valueOf(Math.abs(n));
			for (int j = 0; j < s.length(); j++) {
				sum += s.charAt(j) - '0';
			}
			if (sum == 9) {
				System.out.print(n + " ");
			}
		}

		sc.close();
	}
}
