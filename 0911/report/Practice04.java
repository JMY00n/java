package chapter2;

import java.util.Scanner;

public class Practice04 {
	public static void main(String[] args) {
		/* 여행 경비를 계산하는 프로그램을 작성한다. 방 하나에는 2명까지 투숙 가능하며 1명만 투숙해도 1방의 비용을 지불한다. */
		Scanner sc = new Scanner(System.in);
		System.out.print("여행지>>");
		String dest = sc.nextLine();

		System.out.print("인원수>>");
		int number = sc.nextInt();

		System.out.print("숙박일>>");
		int nights = sc.nextInt();

		System.out.print("1인당 항공료>>");
		int airfare = sc.nextInt();

		System.out.print("1방 숙박비>>");
		int charge = sc.nextInt();

		int total = 0; // 총 여행 경비

		// 인원수가 2로 나누었을 때 나머지가 1 이상이면 무조건 1방의 비용 지불
		int roomSize = 0;

		roomSize = number / 2;
		if (number % 2 != 0)
			roomSize++;

		// 1방 숙박비를 방 개수에 맞게 계산
		charge *= roomSize;

		// 총 여행 경비 = (방 개수에 맞는 숙박비 * 숙박일) + (인원수 * 항공료)
		total = (charge * nights) + (airfare * number);

		System.out.println(
				number + "명의 " + dest + " " + nights + "박 " + (nights + 1) + "일 여행에는 방이 " + roomSize + "개 필요하며 경비는 " + total +"원입니다.");

		sc.close();
	}
}
