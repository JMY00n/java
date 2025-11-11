package chapter7;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("*** 명품 은행에 오신 것을 환영합니다. ***");
		HashMap<String, Integer> hm = new HashMap<String, Integer>();

		while (true) {
			System.out.print("입금:1, 출금:2, 조회:3, 전체 조회:4, 종료:5>>");
			int answer = sc.nextInt();

			switch (answer) {
			case 1: // 입금
				String depositName;
				int depositMoney;

				System.out.print("계좌명과 액수>>");
				depositName = sc.next();
				depositMoney = sc.nextInt();
				if (hm.containsKey(depositName)) { // 이미 한 번 입금한 사람이면 원래 money에서 더해서 갱신
					int currentMoney = hm.get(depositName);
					int newMoney = currentMoney + depositMoney;

					hm.put(depositName, newMoney);
				} else { // 처음 입금하는 사람이면
					hm.put(depositName, depositMoney);
				}

				break;
			case 2: // 출금
				System.out.print("계좌명과 액수>>");
				String withdrawName = sc.next();
				int withdrawMoney = sc.nextInt();

				if (hm.containsKey(withdrawName)) {
					int currentMoney = hm.get(withdrawName);
					if (currentMoney > withdrawMoney) {
						int newMoney = currentMoney - withdrawMoney;
						hm.put(withdrawName, newMoney);
					} else {
						System.out.println("잔액이 부족하여 출금할 수 없음!!");
					}
				}

				break;
			case 3: // 조회
				System.out.print("계좌명>>");
				String searchName = sc.next();
				if (hm.containsKey(searchName)) {
					System.out.println("(" + searchName + ":" + hm.get(searchName) + ")");
				} else {
					System.out.println("없는 이름입니다. 다시 조회해 주세요.");
				}

				break;
			case 4: // 전체 조회
				for (Map.Entry<String, Integer> entry : hm.entrySet()) {
					System.out.print("(" + entry.getKey() + ":" + entry.getValue() + ")");
				}
				
				System.out.println();
				break;
			case 5: // 종료
				sc.close();
				System.exit(0);
			}

		}
	}
}
