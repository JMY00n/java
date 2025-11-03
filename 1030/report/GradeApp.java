package practice;

import java.util.Scanner;

public class GradeApp {
	public static void main(String[] args) {
		
		while (true) {
			double sum = 0;
			double avg = 0;
			Scanner sc = new Scanner(System.in);
			
			System.out.print("여러 과목의 학점을 빈 칸으로 분리 입력 >>");
			String line = sc.nextLine();
			if (line.equals("그만"))
				return;
			
			String[] gradeArray = line.split(" ");
			
			for (int i = 0; i < gradeArray.length; i++) {
				if (gradeArray[i].equals("A") || gradeArray[i].equals("a"))
					sum += 100;
				else if (gradeArray[i].equals("B") || gradeArray[i].equals("b"))
					sum += 90;
				else if (gradeArray[i].equals("C") || gradeArray[i].equals("c"))
					sum += 80;
				else if (gradeArray[i].equals("D") || gradeArray[i].equals("d"))
					sum += 70;
				else
					sum += 0;
			}
			
			avg = sum / gradeArray.length;
			System.out.println("펑균은 " + avg);
		}

	}
}
