package intro;

class Tv {
	String brand;
	int inch;
	int price;
	
	Tv() {
		
	}
	
	Tv(String brand, int inch, int price) {
		this.brand = brand;
		this.inch = inch;
		this.price = price;
	}
	
	void show() {
		System.out.println(price + "만원짜리 " + brand + "에서 만든 " + inch + "인치 TV");
	}
}

public class Practice01 {
	public static void main(String[] args) {
		Tv tv = new Tv("Samsung", 50, 300);
		tv.show();
	}
}
