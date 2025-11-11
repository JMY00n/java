package chapter7;

import java.util.Scanner;
import java.util.Vector;

public class SumPositives {
	Scanner sc = new Scanner(System.in);
	private Vector<Integer> v = new Vector<Integer>();

	public void read() {
		while (true) {
			int num = sc.nextInt();
			if (num == 0)
				return;

			v.add(num);
		}
	}

	public void changeToZero() {
		for (int i = 0; i < v.size(); i++) {
			if (v.get(i) < 0) {
				v.set(i, 0);
			}
		}
	}

	public void showAll() {
		for (int val : v)
			System.out.print(val + " ");
		
		System.out.println();
	}

	public int add() {
		int sum = 0;
		for (int i = 0; i < v.size(); i++) {
			if (v.get(i) > 0) {
				sum += v.get(i);
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		SumPositives sp = new SumPositives();
		System.out.print("0이 입력될 때까지 정수입력>>");
		sp.read(); // 정수들을 입력받아 벡터 v에 저장
		sp.changeToZero(); // 벡터 v에 저장된 음수들을 모두 0으로 변경
		System.out.print("음수를 0으로 바꾸면 ");
		sp.showAll(); // 벡터 v의 원소들을 모두 출력
		System.out.println("양수들의 합은 " + sp.add()); // 벡터 v의 양수들의 합 출력
	}
}
