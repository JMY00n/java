package chapter3;

import java.util.Scanner;

public class ArrayAccess {
	public static void main(String[] args) {
		int[] intArray = new int[5];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		Scanner sc = new Scanner(System.in);

		System.out.println("정수 값 5개 입력 : ");

		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = sc.nextInt();

			if (intArray[i] > max)
				max = intArray[i];
			if (intArray[i] < min)
				min = intArray[i];
		}

		System.out.println("최대 값 = " + max);
		System.out.println("최소 값 = " + min);

		sc.close();
	}
}
