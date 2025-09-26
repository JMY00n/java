package intro;

class Cube {
	int width;
	int height;
	int length;
	
	Cube() {
		
	}
	
	Cube(int width, int height, int length) {
		this.width = width;
		this.height = height;
		this.length = length;
	}
	
	int getVolume() {
		return (width * height * length);
	}
	
	boolean isZero() {
		if (width * height * length != 0) {
			return false;
		}
		
		return true;
	}
	
	void increase(int widthUp, int heightUp, int lengthUp) {
		width += widthUp;
		height += heightUp;
		length += lengthUp;
	}
}

public class Practice02 {
	public static void main(String[] args) {
		Cube cube = new Cube(1, 2, 3);
		System.out.println("큐브의 부피는 " + cube.getVolume());
		cube.increase(1, 2, 3);
		System.out.println("큐브의 부피는 " + cube.getVolume());
		
		if (cube.isZero())
			System.out.println("큐브의 부피는 0");
		else
			System.out.println("큐브의 부피는 0이 아님");
	}
}
