package chapter3;

import java.util.Scanner;

public class ArrayExam01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		int[] intArray = new int[5];
		
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = sc.nextInt();
			sum += intArray[i];
		}
		
//		for (int i = 0; i < intArray.length; i++)
//			System.out.println("intArray["+i+"] = "+ intArray[i]);
		
		for (int val : intArray)
			System.out.println(val);
		
		System.out.println("Sum = " + sum);
		System.out.println("Avg = " + (double)sum/intArray.length);
		
		sc.close();
	}
}
