package chapter2;

import java.util.Scanner;

public class Practice01 {
	public static void main(String[] args) {
		/* 달러를 원화로 바꾸는 프로그램 */
		Scanner sc = new Scanner(System.in);
		int dollar = 1200;
		System.out.print("$1="+ dollar + "원입니다. 달러를 입력하세요>>");
		int input = sc.nextInt();
		// 1달러는 1200원으로 가정한다.	
		System.out.println("$"+input+"는 " + input*dollar + "원입니다.");
		
		
		sc.close();
	}
}
