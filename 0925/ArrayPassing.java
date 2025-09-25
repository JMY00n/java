package intro;

public class ArrayPassing {
	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40 };

		increase(arr);

		for (int val : arr) {
			System.out.print(val + " ");
		}

	}

	public static void increase(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i]++;
		}
	}
}
