package chapter3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Practice15 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			try {
				System.out.println("곱하고자 하는 정수 2개 입력>>");
				int n = sc.nextInt();
				int m = sc.nextInt();

				System.out.println(n + "x" + m + "=" + n * m);
				break;
			} catch (InputMismatchException e) {
				System.out.println("정수를 입력하세요!");
				sc.nextLine();
			}
			
		}
	}
}
