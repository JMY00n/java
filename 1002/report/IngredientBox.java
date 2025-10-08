package chapter5;

import java.util.Scanner;

abstract class Box {
	protected int size;

	public Box(int size) {
		this.size = size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public abstract boolean consume();

	public abstract void print();
}

public class IngredientBox extends Box {
	String name;

	public IngredientBox(String name, int size) {
		super(size);
		this.name = name;
	}

	@Override
	public boolean consume() {
		if (super.size > 0) {
			super.size--;
			return true;
		} else {
			return false;
		}

	}

	@Override
	public void print() {
		System.out.print(this.name + " ***** " + this.size);
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("***** 청춘 커피 자판기 입니다. *****");
		IngredientBox coffee = new IngredientBox("커피", 5);
		IngredientBox creamer = new IngredientBox("프림", 5);
		IngredientBox sugar = new IngredientBox("설탕", 5);

		while (true) {
			coffee.print();
			creamer.print();
			sugar.print();

			System.out.print("커피:1, 프림:2, 설탕:3, 종료:4>>");
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				if (!coffee.isEmpty())
					coffee.consume();
				else
					System.out.println("원료가 부족합니다");
				break;
			case 2:
				if (!creamer.isEmpty())
					creamer.consume();
				else
					System.out.println("원료가 부족합니다");
				break;
			case 3:
				if (!sugar.isEmpty())
					sugar.consume();
				else
					System.out.println("원료가 부족합니다");
				break;
			case 4:
				return;
			}
		}
	}
}
