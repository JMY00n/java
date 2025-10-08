package chapter5;

public class Point3D extends Point {
	int z;

	Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}

	void moveUp(int z) {
		this.z += z;
	}

	void moveDown(int z) {
		this.z -= z;
	}
	
	protected void move(int x, int y) {
		super.move(x, y);
	}
	
	protected void move(int x, int y, int z) {
		super.move(x, y);
		this.z = z;
	}

	@Override
	public String toString() {
		return "(" + super.getX() + "," + super.getY() + "," + z + ")의 점";
	}

	public static void main(String[] args) {
		Point3D p = new Point3D(3, 2, 1);
		System.out.println(p.toString() + "입니다.");
		
		p.moveUp(3);
		System.out.println(p.toString() + "입니다.");
		
		p.moveDown(2);
		System.out.println(p.toString() + "입니다.");
		
		p.move(5, 5);
		System.out.println(p.toString() + "입니다.");
		
		p.move(100, 200, 300);
		System.out.println(p.toString() + "입니다.");
		
	}
}
