package app;

class Point {
	int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean eqauls(Object obj) {
		Point p = (Point)obj;
		
		if (this.x == p.x && this.y == p.y)
			return true;
		else
			return false;
	}
}

public class EqualsEx {
	public static void main(String[] args) {
		Point a = new Point(2, 3);
		Point b = new Point(2, 3);
		Point c = new Point(4, 5);
		
		if (a.eqauls(b))
			System.out.println("a is eqauls to b");
		else
			System.out.println("a is different to b");
		
		if (a.eqauls(c))
			System.out.println("a is eqauls to c");
		else
			System.out.println("a is different to c");
		
		if (b.eqauls(c))
			System.out.println("b is eqauls to c");
		else
			System.out.println("b is different to c");
	}
}
