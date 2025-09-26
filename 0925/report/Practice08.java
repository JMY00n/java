package intro;

class Account {
	int money;

	Account(int money) {
		this.money = money;
	}

	void deposit(int m) {
		// 통장에 예금
		money += m;
	}

	void deposit(int[] mrr) {
		// 배열로 받은 돈 예금
		for (int i = 0; i < mrr.length; i++) {
			money += mrr[i];
		}
	}

	int getBalance() {
		return money;
	}

	int withdraw(int m) {
		if (money >= m) {
			money -= m;
			return m;
		}

		return money;
	}

}

public class Practice08 {
	public static void main(String[] args) {
		Account a = new Account(100);
		a.deposit(5000);
		System.out.println("잔금은 " + a.getBalance() + "원입니다.");

		int bulk[] = { 100, 500, 200, 700 };
		a.deposit(bulk);
		System.out.println("잔금은 " + a.getBalance() + "원입니다.");

		int money = 1000; // 인출하는 금액
		int wMoney = a.withdraw(money); // 1000원 인출시도. wMoney는 실제 인출한 금액
		if (wMoney < money)
			System.out.println(wMoney + "원만 인출");
		else
			System.out.println(wMoney + "원 인출");

		System.out.println("잔금은 " + a.getBalance() + "원입니다.");
	}
}