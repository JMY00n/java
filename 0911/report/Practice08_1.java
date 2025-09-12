package chapter2;

import java.util.Scanner;

public class Practice08_1 {
	public static void main(String[] args) {
		/* 실수에 대한 사칙 연산을 수행하는 프로그램 작성, 2.3 더하기 3.6 계산 결과 출력 */
		Scanner sc = new Scanner(System.in);
		System.out.print("연산 입력>>");
		double num1 = sc.nextDouble();
		String operator = sc.next();
		double num2 = sc.nextDouble();
		double result = 0;

		if (operator.equals("더하기")) {
			result = num1 + num2;
		} else if (operator.equals("빼기")) {
			result = num1 - num2;
		} else if (operator.equals("곱하기")) {
			result = num1 * num2;
		} else if (operator.equals("나누기")) {
			result = num1 / num2;
		} else {
			System.out.println("사칙연산이 아닙니다.");
		}

		System.out.println(num1 + " " + operator + " " + num2 + "의 계산결과는 " + result);

		sc.close();
	}
}
