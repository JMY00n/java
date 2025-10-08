package chapter5;

import java.util.Scanner;

class BaseArray {
	protected int array[];
	protected int nextIndex = 0;

	public BaseArray(int size) {
		array = new int[size];
	}

	public int length() {
		return array.length;
	}

	public void add(int n) {
		if (nextIndex == array.length)
			return;
		array[nextIndex] = n;
		nextIndex++;
	}

	public void print() {
		for (int n : array)
			System.out.print(n + " ");
		System.out.println();
	}
}

public class BinaryArray extends BaseArray {
	int threshold;

	public BinaryArray(int size) {
		super(size);
	}

	public BinaryArray(int size, int threshold) {
		super(size);
		this.threshold = threshold;
	}

	@Override
	public void add(int n) {
		if (nextIndex == array.length)
			return;
		if (n > this.threshold) {
			array[nextIndex] = 1;
			nextIndex++;
		} else {
			array[nextIndex] = 0;
			nextIndex++;
		}
	}

	public static void main(String[] args) {
		int threshold = 50; // 임계값 50
		BinaryArray bArray = new BinaryArray(10, threshold);

		Scanner sc = new Scanner(System.in);
		
		System.out.print(">>");
		for (int i = 0; i < bArray.length(); i++) {
			int n = sc.nextInt();
			bArray.add(n);
		}

		bArray.print();
		sc.close();
	}

}
