package intro;

class ArrayUitl {
	public static int[] concat(int[] a, int[] b) {
		/* 배열 a와 b를 연결한 새로운 배열 리턴 */
		int[] arr = new int[a.length + b.length];

		for (int i = 0; i < a.length; i++) {
			arr[i] = a[i];
		}

		for (int j = 0; j < b.length; j++) {
			arr[a.length + j] = b[j];
		}

		return arr;
	}

	public static void print(int[] a) {
		/* 배열 a 출력 */
		System.out.print("[ ");
		for (int val : a) {
			System.out.print(val + " ");
		}
		System.out.println("]");
	}
}

public class Practice11 {
	public static void main(String[] args) {
		int[] array1 = { 1, 5, 7, 9 };
		int[] array2 = { 3, 6, -1, 100, 77 };
//		int[] array3 = ArrayUtil.concat(array1, array2);
//		ArrayUtil.print(array3);
		int[] array3 = ArrayUitl.concat(array1, array2);
		ArrayUitl.print(array3);
		
	}
}
