package chapter3;

import java.util.Scanner;

public class Practice05 {
	public static void main(String[] args) {
		// 양의 정수를 10개 입력받아 배열을 만들고 만들어진 배열 중 3의 배수만 출력
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		System.out.print("양의 정수 10개 입력>>");
		
		for (int i = 0; i < 10; i++) {
			int number = sc.nextInt();
			arr[i] = number;
		}
		
		// 3의 배수만 출력
		System.out.print("3의 배수는 ...");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 3 == 0) {
				System.out.print(arr[i] + " ");
			}
		}
		
		sc.close();
	}
}
