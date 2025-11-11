package chapter7;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AirportApp {
	public static void main(String[] args) {
		System.out.println("*** 마일리지 관리 프로그램입니다.***");
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		while (true) {
			System.out.print("이름과 마일리지>>");
			String input = sc.nextLine();

			if (input.trim().equalsIgnoreCase("그만"))
				break;

			String[] parts = input.split("\\s+");

			String name = parts[0];
			String pointString = parts[1];
			int point = Integer.parseInt(pointString);

			hm.put(name, point);
		}

		Set keys = hm.keySet();
		Iterator<String> keyName = keys.iterator();

		while (keyName.hasNext()) {
			String name = keyName.next();
			int mileage = hm.get(name);

			System.out.print("(" + name + ":" + mileage + ")");
		}

		String maxName = null;
		int max = Integer.MIN_VALUE;

		for (Map.Entry<String, Integer> entry : hm.entrySet()) {
			String currentName = entry.getKey();
			int currentMileage = entry.getValue();

			if (currentMileage > max) {
				max = currentMileage;
				maxName = currentName;
			}
		}
		
		System.out.println();
		System.out.println("가장 마일리지가 높은 고객은 " + maxName + "입니다.");
		System.out.println("프로그램을 종료합니다.");
		sc.close();

	}
}
