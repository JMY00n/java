package chapter5;

import java.util.Scanner;

interface IStack {
	int capacity();

	int length();

	boolean push(String val);

	String pop();
}

public class StringStack implements IStack {
	private int capacity;
	private String[] str;
	private int topIndex;

	StringStack(int capacity) {
		this.capacity = capacity;
		this.str = new String[capacity];
		topIndex = 0;
	}

	@Override
	public int capacity() {
		return this.capacity;
	}

	@Override
	public int length() {
		return this.topIndex;
	}

	@Override
	public boolean push(String val) {
		if (this.topIndex == this.capacity) {
			System.out.println("스택이 꽉 차서 디지털 저장 불가");
			return false;
		}

		this.str[this.topIndex] = val;
		this.topIndex++;
		return true;
	}

	@Override
	public String pop() {
		if (this.topIndex == 0) {
			return null;
		}

		this.topIndex--;
		String value = this.str[this.topIndex];
		this.str[this.topIndex] = null;

		return value;
	}

	public void print() {
		for (int i = 0; i < this.topIndex; i++) {
			System.out.print(str[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("스택용량>>");

		StringStack stack = new StringStack(sc.nextInt());

		while (true) {
	        System.out.print("문자열 입력>>");
	        String input = sc.next();

	        if (input.equals("그만")) {
	            System.out.print("스택에 저장된 문자열 팝 : ");
	            stack.print();
	            sc.close();
	            return;
	        }

	        stack.push(input);
	    }

	}
}
