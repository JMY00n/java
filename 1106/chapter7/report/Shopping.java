package chapter7;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Shopping {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> hm = new HashMap<String, Integer>(); // 현재 쇼핑 목록
		
		hm.put("고추장", 3000);
		hm.put("만두", 500);
		hm.put("새우깡", 1500);
		hm.put("콜라", 600);
		hm.put("참치캔", 2000);
		hm.put("치약", 1000);
		hm.put("연어", 2500);
		hm.put("삼겹살", 2500);

		Set keys = hm.keySet();
		Iterator<String> iterator = keys.iterator();

		System.out.println("쇼핑 비용을 계산해드립니다. 구입 가능 물건과 가격은 다음과 같습니다.");

		while (iterator.hasNext()) {
			String item = iterator.next();
			System.out.print("[" + item + ", " + hm.get(item) + "] ");
		}
		System.out.println();
		while (true) {
			long totalCost = 0;
			System.out.print("물건과 개수를 입력하세요>>");
			String answer = sc.nextLine();
			String[] parts = answer.trim().split("\\s+");
			
			if (answer.trim().equalsIgnoreCase("그만")) {
				System.out.println("프로그램을 종료합니다...");
				break;
			}
			for (int i = 0; i < parts.length; i += 2) {
				if (i + 1 < parts.length) {
					String product = parts[i];
					String countString = parts[i + 1];

					if (hm.containsKey(product)) {
						try {
						int count = Integer.parseInt(countString);
						int pricePerUnit = hm.get(product);

						totalCost += (long) pricePerUnit * count;
						} catch (NumberFormatException e) {
							System.out.println("입력에 문제가 있습니다!");
						}
					} else {
						System.out.println(product + "은 없는 상품입니다!");
					}
				}
			}
			System.out.println("전체 비용은 " + totalCost + "입니다.");
		}

	}
}
