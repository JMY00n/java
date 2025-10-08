package basic;

public class PointTest {
	public static void main(String[] args) {
		Point p1 = new Point(5, 6);
		p1.showPoint();

		ColorPoint cp1 = new ColorPoint("red");
		cp1.set(5, 6);
		cp1.showColor();
	}

}

class Point {
	int x, y;

	public Point() {

	}

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void showPoint() {
		System.out.println("(" + x + ", " + y + ")");
	}
}

class ColorPoint extends Point {
	String color;

	ColorPoint() {

	}

	ColorPoint(String color) {
		this.color = color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void showColor() {
		System.out.print(color);
		super.showPoint();
	}
}
