package chapter2;

import java.util.Scanner;

public class Practice03 {
	public static void main(String[] args) {
		/* 떡볶이 1인분 2000원, 김말이 1인분 1000원, 쫄면 1인분 3000원. */
		int tteok = 2000;
		int kim = 1000;
		int jjol = 3000;
		int total = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("**** 자바 분식입니다. 주문하면 금액을 알려드립니다. ****");
		System.out.print("떡볶이 몇 인분>>");
		int order1 = sc.nextInt();

		System.out.print("김말이 몇 인분>>");
		int order2 = sc.nextInt();

		System.out.print(" 쫄면 몇 인분>>");
		int order3 = sc.nextInt();

		total = (order1*tteok) + (order2*kim) + (order3*jjol);
		
		System.out.println("전체 금액은 " + total + "입니다.");
		
		sc.close();
	}
}
