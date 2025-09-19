package chapter3;

public class DoWhileExam01 {
	public static void main(String[] args) {
		char c = 'A';
		
		do {
			System.out.print(c + " ");
			c = (char)(c + 1);
		} while (c <= 'Z');
	}
}
