package intro;

public class ReferencePassing {
	public static void main(String[] args) {
		Circle pizza = new Circle(10);
		
		increasePizza(pizza);
		System.out.println(pizza.radius);
	}

	private static void increasePizza(Circle pizza) {
		pizza.radius++;
	}
}
