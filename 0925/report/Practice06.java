package intro;

class Rectangle1 {
	int x;
	int y;
	int width;
	int height;

	Rectangle1(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	boolean isSquare() {
		// 가로 세로가 같으면 정사각형
		if (width == height) {
			return true;
		}

		return false;
	}

	// contains 로직 다시 짜기	
	boolean contains(Rectangle1 r) {
		// this의 좌상단, 우하단 좌표
	    int thisRight = this.x + this.width;
	    int thisBottom = this.y + this.height;

	    // r의 좌상단, 우하단 좌표
	    int rRight = r.x + r.width;
	    int rBottom = r.y + r.height;

	    // 포함 조건: r의 좌상단이 this 안쪽에 있고, r의 우하단도 this 안쪽에 있어야 함
	    return this.x <= r.x && this.y <= r.y
	        && thisRight >= rRight && thisBottom >= rBottom;
	}
	
	void show() {
		System.out.println("("+x+","+y+")에서 크기가 " + width + "x" + height + "인 사각형");
	}
}

public class Practice06 {
	public static void main(String[] args) {
		Rectangle1 a = new Rectangle1(3, 3, 6, 6);
		Rectangle1 b = new Rectangle1(5, 5, 5, 5);
		
		a.show();
		
		if (a.isSquare()) 
			System.out.println("a는 정사각형입니다.");
		else
			System.out.println("a는 직사각형입니다.");
		
		if (a.contains(b))
			System.out.println("a는 b를 포함합니다.");
		else
			System.out.println("a는 b를 포함하지 않습니다.");
		
	}
}
