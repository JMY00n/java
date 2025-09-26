package intro;

class Average {
	int[] arr = new int[10];
	private int nextIndex = 0;
	double avg;

	void put(int a) {
		arr[nextIndex++] = a;
	}

	void showAll() {
		for (int i = 0; i < nextIndex; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	double getAvg() {
		int sum = 0;
		for (int i = 0; i < nextIndex; i++) {
			sum += arr[i];
		}

		avg = (double)sum / nextIndex;

		return avg;
	}
}

public class Practice04 {
	public static void main(String[] args) {
		Average avg = new Average();
		avg.put(10);
		avg.put(15);
		avg.put(100);
		avg.showAll();
		System.out.print("평균은 " + avg.getAvg());
	}
}
