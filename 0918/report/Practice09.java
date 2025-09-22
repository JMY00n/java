package chapter3;

import java.util.Random;
import java.util.Scanner;

public class Practice09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Random r = new Random();

		int arr[][] = new int[4][4];

		System.out.println("4x4 배열에 랜덤한 값을 저장한 후 출력합니다.");
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = r.nextInt(255);
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%-4d", arr[i][j]);
			}
			System.out.println();
		}
		sc.close();
	}

}
