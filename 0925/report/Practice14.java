package intro;

class VArray {
	int[] a;
	private int size = 0;
	private int capacityValue;

	VArray(int num) {
		a = new int[num];
		this.capacityValue = num;
	}

	void add(int num) { /* 정수 저장 */
		if (size == a.length) {
			// 1. 새롭게 크기 계산
			int newCapacity = a.length * 2;
			this.capacityValue = newCapacity;
			// 2. 새롭게 배열 생성
			int[] newArray = new int[newCapacity];
			// 3. 기존 데이터 복사 (size 개수만큼만)
			System.arraycopy(a, 0, newArray, 0, size);
			a = newArray;

		}
		a[size] = num;
		size++;
	}

	void insert(int index, int value) { /* 정수 삽입 */
		for (int i = size; i > index; i--) {
			a[i] = a[i - 1];
		}
		a[index] = value;
		size++;
	}

	void remove(int value) {
		int indexToRemove = -1;

		// 삭제할 값의 인덱스 찾기
		for (int i = 0; i < size; i++) {
			if (a[i] == value) {
				indexToRemove = i;
				break;
			}
		}
		// 데이터 왼쪽으로 이동
		for (int i = indexToRemove; i < size - 1; i++) {
			a[i] = a[i + 1]; // a[i+1]의 값을 a[i]로 덮어씀
		}

		size--;

	}

	public int capacity() {
		return a.length;
	}

	public int size() {
		return size;
	}

	void printAll() {
		for (int i = 0; i < size; i++) {
			System.out.print(this.a[i] + " ");
		}
		System.out.println();
	}
}

public class Practice14 {
	public static void main(String[] args) {
		VArray v = new VArray(5);
		System.out.println("용량 : " + v.capacity() + ", 저장된 개수 : " + v.size());

		for (int i = 0; i < 7; i++)
			v.add(i);

		System.out.println("용량 : " + v.capacity() + ", 저장된 개수 : " + v.size());
		v.printAll();

		v.insert(3, 100);
		v.insert(5, 200);
		System.out.println("용량 : " + v.capacity() + ", 저장된 개수 : " + v.size());
		v.printAll();

		v.remove(1);
		System.out.println("용량 : " + v.capacity() + ", 저장된 개수 : " + v.size());
		v.printAll();

	}
}
