package chapter5;

import java.util.Scanner;

abstract class Calc {
	int a, b;

	abstract String errorMsg();

	abstract void setValue(int a, int b);

	abstract int calculate();
}

class Add extends Calc {
	@Override
	String errorMsg() { return null; }

	@Override
	void setValue(int a, int b) { super.a = a; super.b = b; }

	@Override
	int calculate() { return super.a + super.b; }
}

class Sub extends Calc {
	@Override
	String errorMsg() { return null; }

	@Override
	void setValue(int a, int b) { super.a = a; super.b = b; }

	@Override
	int calculate() { return super.a - super.b; }
}

class Mul extends Calc {
	@Override
	String errorMsg() { return null; }

	@Override
	void setValue(int a, int b) { super.a = a; super.b = b; }

	@Override
	int calculate() { return super.a * super.b; }
}

class Div extends Calc {
    private boolean error = false;
    
	@Override
	String errorMsg() {
        return error ? "0으로 나눌 수 없습니다." : null;
    }

	@Override
	void setValue(int a, int b) {
		super.a = a;
		super.b = b;
        this.error = (b == 0);
	}

	@Override
	int calculate() {
        if (super.b == 0) {
            return 0;
        }
		return super.a / super.b;
	}
}

//---------------------------------------------------------

public class Calculator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.print("두 정수와 연산자를 입력하시오 (예: 10 20 +)>> ");
            
            if (!sc.hasNextInt()) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            
			int a = sc.nextInt();
			int b = sc.nextInt();
			String sign = sc.next();
			
			Calc cal = null; 
			
			switch (sign) {
				case "+":
					cal = new Add();
					break;
				case "-":
					cal = new Sub();
					break;
				case "*":
					cal = new Mul();
					break;
				case "/":
					cal = new Div();
					break;
				default:
					System.out.println("지원하지 않는 연산자입니다.");
					continue;
			}
			
			cal.setValue(a, b);
			
            String error = cal.errorMsg();
            
            if (error != null) {
                System.out.println(error);
            } else {
                int result = cal.calculate(); 
                System.out.println("계산 결과: " + result);
            }
		}
        sc.close();
	}
}