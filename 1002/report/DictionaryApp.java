package chapter5;

abstract class PairMap {
	protected String keyArray[];
	protected String valueArray[];

	abstract public String get(String key);

	abstract public void put(String key, String value);

	abstract public String delete(String key);

	abstract public int length();
}

class Dictionary extends PairMap {
	int size;
	int topIndex;

	public Dictionary(int size) {
		// TODO Auto-generated constructor stub
		this.size = size;
		this.topIndex = 0;
		super.keyArray = new String[size];
		super.valueArray = new String[size];
	}

	@Override
	public String get(String key) {
		// TODO key 값으로 value 검색
		for (int i = 0; i < topIndex; i++) {
			if (super.keyArray[i] != null) {
				if (super.keyArray[i].equals(key))
					return super.valueArray[i];
			}
		}

		return null;
	}

	@Override
	public void put(String key, String value) {
		// TODO key와 value를 쌍으로 저장, key가 이미 저장되어 있으면 값을 value로 수정
		for (int i = 0; i < topIndex; i++) {
			if (super.keyArray[i] != null && super.keyArray[i].equals(key)) {
				super.valueArray[i] = value;
				return;
			}
		}
		if (topIndex == size) {
			System.out.println("딕셔너리가 가득 찼습니다.");
			return;
		}

		super.keyArray[topIndex] = key;
		super.valueArray[topIndex] = value;
		topIndex++;
	}

	@Override
	public String delete(String key) {
		// TODO key값을 가진 아이템(value와 함께) 삭제. 삭제된 value 값 리턴
		for (int i = 0; i < topIndex; i++) {
			if (super.keyArray[i].equals(key)) {
				super.keyArray[i] = null;
				String tmp = super.valueArray[i];
				super.valueArray[i] = null;

				return tmp;
			}
		}

		return null;
	}

	@Override
	public int length() {
		// TODO 현재 저장된 아이템 개수 리턴
		return topIndex;
	}

}

public class DictionaryApp {
	public static void main(String[] args) {
		Dictionary dic = new Dictionary(10);
		dic.put("황기태", "자바");
		dic.put("이재문", "파이썬");
		dic.put("이재문", "C++");

		System.out.println("이재문의 값 " + dic.get("이재문"));
		System.out.println("황기태의 값 " + dic.get("황기태"));
		dic.delete("황기태");
		System.out.println("황기태의 값 " + dic.get("황기태"));
	}
}
