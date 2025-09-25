package intro;

class Triangle {
	int width;
	int height; 
	
	double getArea() {
		return 0.5 * width * height;
	}
}

public class TriangleTest {
	public static void main(String[] args) {
		Triangle t1 = new Triangle();
		t1.width = 10;
		t1.height = 20;
		
		System.out.println("삼각형의 면적 = " + t1.getArea());
	}
}
