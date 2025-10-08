package chapter5;

public class Point3DColor extends Point {
	int z;
	String color;

	Point3DColor(int x, int y, int z, String color) {
		super(x, y);
		this.z = z;
		this.color = color;
	}

	void move(Point3DColor p) {
		super.move(p.getX(), p.getY());
		this.z = p.z;
		this.color = p.color;
	}

	@Override
	public String toString() {
		return "(" + super.getX() + ", " + super.getY() + ", " + z + ")" + color + "점입니다.";
	}

	public boolean equals(Point3DColor p) {
		if (super.getX() == p.getX() && super.getY() == p.getY() && this.z == p.z && this.color.equals(p.color))
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		Point3DColor p = new Point3DColor(10, 20, 30, "RED");
		System.out.println(p.toString());

		Point3DColor q = new Point3DColor(1, 2, 3, "BLUE");
		p.move(q);
		System.out.println(q.toString());
		System.out.println(p.toString());

		Point3DColor r = new Point3DColor(1, 2, 3, "BLUE");
		if (p.equals(r))
			System.out.println("예. 같은 위치 같은 색깔의 점입니다.");
		else
			System.out.println("아니오");
	}

}
