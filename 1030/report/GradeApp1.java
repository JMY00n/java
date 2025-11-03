package practice;

import java.util.Scanner;
import java.util.StringTokenizer;

public class GradeApp1 {
	public static void main(String[] args) {

		while (true) {
			double sum = 0;
			double avg = 0;
			Scanner sc = new Scanner(System.in);
			System.out.print("여러 과목의 학점을 빈 칸으로 분리 입력>>");
			String line = sc.nextLine();
			if (line.equals("그만"))
				return;

			StringTokenizer st = new StringTokenizer(line, " ");
			int count = st.countTokens();
	
			while (st.hasMoreTokens()) {
				String token = st.nextToken();

				if (token.equals("A"))
					sum += 100;
				else if (token.equals("B"))
					sum += 90;
				else if (token.equals("C"))
					sum += 80;
				else if (token.equals("D"))
					sum += 70;
				else
					System.out.println("입력 오류 : " + token);
					break;
			}
			avg = sum / count;
			System.out.println("평균은 : " + avg);
			
		}
	}
}
