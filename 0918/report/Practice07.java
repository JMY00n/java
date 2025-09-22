package chapter3;

import java.util.Scanner;

public class Practice07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		System.out.print("양의 정수 10개 입력>>");

		double sum = 0;
		for (int i = 0; i < 10; i++) {
			int number = sc.nextInt();
			arr[i] = number;
			sum += arr[i];
		}

		sum /= 10;

		System.out.println(sum);

		sc.close();
	}
}
