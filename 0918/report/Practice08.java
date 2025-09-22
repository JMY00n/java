package chapter3;

import java.util.Random;
import java.util.Scanner;

public class Practice08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 몇 개 저장하시겠습니까?>>");
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		double sum = 0;
		
		System.out.print("랜덤한 정수들...");
		for (int i = 0; i < arr.length; i++) {
			Random r = new Random();
			arr[i] = r.nextInt(100);
			System.out.print(arr[i] + " ");
			sum += arr[i];
		}
		
		System.out.println();
		
		sum /= N;
		
		System.out.print("평균은 ");
		System.out.println(sum);
		
		sc.close();
	}
}