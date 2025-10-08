package chapter5;

interface Shape1 {
	final double PI = 3.14;

	void draw();

	double getArea();

	default public void redraw() {
		System.out.println("--- 다시 그립니다. ---");
		draw();
	}
}

class Circle1 implements Shape1 {
	private int radius;

	public Circle1(int radius) {
		this.radius = radius;
	}

	@Override
	public void draw() {
		System.out.println("반지름이 " + radius + "인 원");
	}

	@Override
	public double getArea() {
		return PI * radius * radius;
	}
}

class Oval implements Shape1 {
	private int width;
	private int height;

	public Oval(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw() {
		System.out.println("가로 " + width + ", 세로 " + height + "에 내접하는 타원");
	}

	@Override
	public double getArea() {
		return PI * (width / 2.0) * (height / 2.0);
	}
}

class Rect1 implements Shape1 {
	private int width;
	private int height;

	public Rect1(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw() {
		System.out.println("가로 " + width + ", 세로 " + height + " 크기의 사각형");
	}

	@Override
	public double getArea() {
		return (double) width * height;
	}
}

public class ShapeEx {
	public static void main(String[] args) {
		Shape1[] list = new Shape1[3];
		list[0] = new Circle1(5);
		list[1] = new Oval(20, 30);
		list[2] = new Rect1(10, 40);
		
		for (int i = 0; i < list.length; i++) {
			list[i].redraw();
		}
		for (int i = 0; i < list.length; i++) {
			System.out.println("면적은 " + list[i].getArea());
		}
	}
}