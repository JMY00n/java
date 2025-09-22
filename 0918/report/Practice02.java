package chapter3;

public class Practice02 {
	public static void main(String[] args) {
		int n[] = { 1, -2, 6, 20, 5, 72, -16, 256 };
//		for (int i = 0; i < n.length; i++) {
//			if (n[i] > 0 && n[i] % 4 == 0) {
//				System.out.println(n[i] + " ");
//			}
//		}

		// 1. 0보다 큰 4의 배수만 출력하는 코드.
		// 2.

		// 3. while문을 이용하여 동일하게 작성
//		int i = 0;
//		while (i < n.length) {
//			if (n[i] > 0 && n[i] % 4 ==0) {
//				System.out.println(n[i] + " ");
//			}
//			i++;
//		}

		// 4. do-while 문을 이용하여 동일하게 작성
		int i = 0;
		do {
			if (n[i] > 0 && n[i] % 4 == 0) {
				System.out.println(n[i] + " ");
			}
			i++;
		} while (i < n.length);
	}
}
