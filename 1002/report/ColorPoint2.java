package chapter5;

public class ColorPoint2 extends Point {
	String color;

	public ColorPoint2() {
		this.color = "WHITE";
	}
	
	public ColorPoint2(int x, int y) {
		super(x, y);
		this.color = "BALCK";
	}

	public ColorPoint2(int x, int y, String color) {
		super(x, y);
		this.color = color;
	}

	void set(String color) {
		this.color = color;
	}

	void set(int x, int y) {
		super.move(x, y);
	}

	double getDistance(Point p) {
		double deltaX = super.getX() - p.getX();
		double deltaY = super.getY() - p.getY();

		return Math.sqrt((deltaX * deltaX) + (deltaY * deltaY));
	}

	@Override
	public String toString() {
		return "(" + super.getX() + ", " + super.getY() + ") 위치의 " + "\"" + color + "\"" + "색 점";
	}

	public static void main(String[] args) {
		ColorPoint2 zeroPoint = new ColorPoint2();
		System.out.println(zeroPoint.toString());

		ColorPoint2 cp = new ColorPoint2(10, 10, "RED");
		cp.set("BLUE");
		cp.set(10, 20);
		System.out.println(cp.toString() + "입니다.");
		
		ColorPoint2 thresholdPoint = new ColorPoint2(100, 100);
		System.out.println("cp에서 임계점까지의 거리는 " + cp.getDistance(thresholdPoint));

	}

}
