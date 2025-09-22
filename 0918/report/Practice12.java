package chapter3;

import java.util.Random;
import java.util.Scanner;

public class Practice12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();

		String boyMiddleList[] = { "기", "민", "용", "종", "현", "잔", "재", "승", "소", "상", "지" };
		String boyLastList[] = { "태", "잔", "광", "혁", "우", "철", "빈", "준", "구", "호", "석" };
		String girlMiddleList[] = { "은", "원", "경", "수", "현", "예", "여", "송", "서", "채", "하" };
		String girlLastList[] = { "진", "연", "경", "서", "리", "숙", "미", "원", "린", "회", "수" };
		System.out.println("***** 작명 프로그램이 실행됩니다. *****");

		while (true) {
			int random = r.nextInt(boyMiddleList.length - 1);
			String[] name = new String[3];
			System.out.print("남/여 선택>>");
			String sex = sc.next();
			
			if (sex.equals("그만")) {
				break;
			} else if (sex.equals("남")) {
				/* 남자 코드 실행 */
				System.out.print("성 입력>>");
				name[0] = sc.next();
				name[1] = boyMiddleList[random];
				name[2] = boyLastList[random];
				for (String val : name)
					System.out.print(val);
				System.out.println();
			} else if (sex.equals("여")) {
				/* 여자 코드 실행 */
				System.out.print("성 입력>>");
				name[0] = sc.next();
				name[1] = girlMiddleList[random];
				name[2] = girlLastList[random];
				for (String val : name)
					System.out.print(val);
				System.out.println();
			} else {
				System.out.println("남/여/그만 중에서 입력하세요 !");
				continue;
			}
		}
		sc.close();
	}
}
