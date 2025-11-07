package main;

import java.util.Iterator;
import java.util.Vector;

public class IteratorEx {
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();
		v.add(5);
		v.add(4);
		v.add(-1);
		v.add(2, 100); // 4와 -1 사이에 정수 100 삽입
		
		Iterator<Integer> it = v.iterator(); // v의 Iterator 객체 얻기
		while (it.hasNext()) {
			int n = it.next();
			System.out.println(n);
		}
		
		// 모든 정수 더하기
		int sum = 0;
		it = v.iterator();
		while (it.hasNext()) {
			int n = it.next();
			sum += n;
		}
		
		System.out.println("벡터에 있는 정수 합 : " + sum);
	}
}
