package chapter3;

public class Practice01 {
	public static void main(String[] args) {
		int sum = 0;

//		while (true) {
//			if (i > 50)
//				break;
//			
//			sum = sum + i;
//			i += 3;
//		}
//		
//		System.out.println(sum);

		// 1. i는 1부터 3씩 늘어나면서 sum에 덧셈 결과를 누적하여 sum을 출력하는 코드, 실행 결과는 425
		// 2. for 문으로 동일하게 실행되는 ForLoop 클래스 작성
		// 3. do-While Loop 클래스 작성
		
		// ForLoop
//		for (int i = 1; i < 50; i+=3) {
//			sum += i;
//		}
		
		// do-While Loop
		int i = 1;
		do {
			sum += i;
			i += 3;
		} while (i < 50);
		System.out.println(sum);
	}
}
