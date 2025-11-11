package chapter7;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class StockApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		System.out.println("주식 종목과 주가를 입력하세요(예:삼송전자 75000)");

		while (true) {
			System.out.print("종목, 주가>>");
			String inputLine = sc.nextLine();

			if (inputLine.trim().equalsIgnoreCase("그만"))
				break;

			String[] parts = inputLine.split("\\s+");

			if (parts.length != 2) {
				System.out.println("입력 형식이 올바르지 않습니다.");
				continue;
			}

			String stockName = parts[0];
			String priceString = parts[1];

			try {
				int price = Integer.parseInt(priceString);
				hm.put(stockName, price);
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력해주세요.");
			}
		}

		System.out.println("주가를 검색합니다.");

		while (true) {
			System.out.print("종목>>");
			String event = sc.next();

			if (event.trim().equalsIgnoreCase("그만"))
				break;

			if (hm.containsKey(event))
				System.out.println(event + "의 주가는 " + hm.get(event));
			else
				System.out.println("등록되지 않은 종목입니다.");
		}
		sc.close();
		System.out.println("프로그램을 종료합니다.");

	}
}
