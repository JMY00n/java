package chapter7;

import java.util.Scanner;
import java.util.Vector;

class Student {
	String name;
	String major;
	int stuID;
	double grade;

	public Student() {
		
	}
	
	public Student(String name, String major, int stuID, double grade) {
		this.name = name;
		this.major = major;
		this.stuID = stuID;
		this.grade = grade;
	}
	
	public String toString() {
		return "이름:" + this.name + "\t" + "전공:" + this.major + "\t" + this.stuID + "\t" + this.grade;
	}
	
	public String search() {
		return this.name + ", " + this.major + ", " + this.stuID + ", " + this.grade;
	}
}

public class StudentMange {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Vector<Student> students = new Vector<Student>();

		System.out.println("4명 이름, 전공, 학번, 학점 입력");
		for (int i = 0; i < 4; i++) { // 4명의 학생
			String inputLine = sc.nextLine();
			String[] parts = inputLine.trim().split(",\\s*");

			if (parts.length != 4) {
				System.out.println("입력 형식이 올바르지 않습니다. 다시 시도해 주세요.");
				i--;
				continue;
			}

			String name = parts[0];
			String major = parts[1];

			try {
				int stuID = Integer.parseInt(parts[2].trim());
				double grade = Double.parseDouble(parts[3].trim());

				Student newStudent = new Student(name, major, stuID, grade);
				students.add(newStudent);

			} catch (NumberFormatException e) {
				System.out.println("학번과 학점은 숫자로만 입력해주세요.");
				i--;
			}

		}
		
		// 학생 모두 출력
		System.out.println("---------------------------------------");
		for (Student stu : students) {
			System.out.println(stu.toString());
		}
		System.out.println("---------------------------------------");
		
		// 장학생 출력
		double scholarshipStu = 4.0;
		System.out.print("장학생 : ");
		for (Student stu : students) {
			if (scholarshipStu <= stu.grade) {
				System.out.print(stu.name + " ");
			}
		}
		System.out.println();
		
		// 학생 조회
		while (true) {
			System.out.print("학생 이름 >> ");
			String name = sc.next();
			if (name.equals("그만")) {
				sc.close();
				return;
			}
			
			boolean found = false;
			
			for (int i = 0; i < students.size(); i++) {
				Student searchStu = students.get(i);
				if (searchStu.name.equals(name)) {
					System.out.println(searchStu.search());
					found = true;
					break;
				}
			}
			
			if (!found)
				System.out.println(name + "은(는) 없는 학생입니다. 다시 시도해 주세요. ");
			
		}
		
		
	}
}
