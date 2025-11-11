package practice;

import java.util.Scanner;
import java.util.Vector;

abstract class Shape {
	public String toString() {
		return "Shape";
	}
}

class Line extends Shape {
	public String toString() {
		return "Line";
	}
}

class Rect extends Shape {
	public String toString() {
		return "Rect";
	}
}

class Circle extends Shape {
	public String toString() {
		return "Circle";
	}
}

public class ShapeApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("그래픽 에디터 Beauty Graphic Editor를 실행합니다.");
		Vector<Shape> vc = new Vector<Shape>();

		while (true) {
			System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>");
			int answer = sc.nextInt();
			switch (answer) {
			case 1: // 삽입
				System.out.print("Line(1), Rect(2), Circle(3)>>");
				int one = sc.nextInt();

				if (one == 1) {
					Shape line = new Line();
					vc.add(line);
				} else if (one == 2) {
					Shape rect = new Rect();
					vc.add(rect);
				} else if (one == 3) {
					Shape circle = new Circle();
					vc.add(circle);
				} else {
					System.out.println("1, 2, 3 번 중에 선택해주세요.");
					continue;
				}

				break;
			case 2: // 삭제
				System.out.print("삭제할 도형의 위치>>");
				int input = sc.nextInt();

				try {
					vc.remove(input - 1);
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("삭제할 수 없습니다.");
				}
				
				break;

			case 3: // 모두 보기
				for (Shape val : vc) {
					System.out.println(val + " ");
				}

				break;
			case 4: // 종료
				return;
			}
		}
	}
}
