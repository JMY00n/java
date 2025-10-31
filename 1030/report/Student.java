package practice;

public class Student {
	@Override
	public String toString() {
		return "학번이 " + this.id + "인 " + this.name;
	}

	private String name;
	private int id;
	

	public Student() { }
	
	public Student(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		Student st = (Student)obj;
		if (this.name == st.getName() && this.id == st.getId())
			return true;
		else
			return false;
		
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
