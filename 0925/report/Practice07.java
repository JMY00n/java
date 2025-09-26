package intro;

class Memo {
	String name;
	String time;
	String content;
	
	Memo(String name, String time, String content) {
		this.name = name;
		this.time = time;
		this.content = content;
	}
	
	boolean isSameName(Memo name) {
		// 메모 작성자가 같으면 true, 아니면 false
		if (this.name == name.name)
			return true;
		
		return false;
	}
	
	String getName() {
		// 메모 작성자 이름 리턴
		return name;
	}
	
	void show() {
		// 메모 출력
		System.out.println(name + ", " + time + " " + content);
	}
	
	int length() {
		// 메모 텍스트의 길이 리턴
		return content.length();
	}
}

public class Practice07 {
	public static void main(String[] args) {
		Memo a = new Memo("유송연", "10:10", "자바 과제 있음");
		Memo b = new Memo("박채원", "10:15", "시카고로 어학 연수가요!");
		Memo c = new Memo("김경미", "11:30", "사랑하는 사람이 생겼어요.");
		
		a.show();
		if (a.isSameName(b))
			System.out.println("동일한 사람입니다.");
		else
			System.out.println("다른 사람입니다.");
		
		System.out.println(c.getName() + "가 작성한 메모의 길이는 " + c.length());
	}
}
