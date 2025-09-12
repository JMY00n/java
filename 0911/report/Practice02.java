package chapter2;

import java.util.Scanner;

public class Practice02 {
	public static void main(String[] args) {
		/* 8자리 정수를 입력받아 년, 월, 일에 나누어 출력. 8자리 정수가 입력되지 않는 경우는 무시 */
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int year = input / 10000;
		int month = (input % 10000)/100;
		int day = (input % 10000) % 100;
		
		System.out.println(year+"년 " + month + "월 " + day + "일");
		
		sc.close();
	}
}
