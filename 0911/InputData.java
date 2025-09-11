package s0911;

import java.util.Scanner;

public class InputData {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("이름, 도시, 나이, 체중, 독신여부를 빈칸으로 구분하여 입력하세요.");
		String name = sc.next();
		String city = sc.next();
		int age = sc.nextInt();
		double weight = sc.nextDouble();
		boolean single = sc.nextBoolean();
		
		System.out.println("이름 : " + name);
		System.out.println("도시 : " + city);
		System.out.println("나이 : " + age);
		System.out.println("체중 : " + weight);
		System.out.println("싱글 : " + single);
		
		sc.close();
	}
}
