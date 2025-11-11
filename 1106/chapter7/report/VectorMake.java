package chapter7;

import java.util.Scanner;
import java.util.Vector;

public class VectorMake {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력(-1이면 입력 끝)>>");
		
		Vector<Integer> nums = new Vector<>();
		while (true) {
			int num = sc.nextInt();
			if (num == -1)
				break;
			
			nums.add(num);
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.size(); i++) {
			if (min > nums.get(i))
				min = nums.get(i);
		}
		
		System.out.println("제일 작은 수는 " + min);
	}
}
