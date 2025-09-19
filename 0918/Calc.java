package chapter3;

public class Calc {
	public static void main(String[] args) {
		double sum = 0.0;
		
		for (int s = 0; s < args.length; s++) {
			sum += Double.parseDouble(args[s]);
		}
		
		System.out.println(sum);
	}
}
