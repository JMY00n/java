package chapter5;

import java.util.Scanner;

public class SortedArray extends BaseArray {

	public SortedArray(int size) {
		super(size);
	}
	
	 @Override
	    public void add(int n) {
	        if (nextIndex == array.length)
	            return;

	        int insertIndex = nextIndex;
	        for (int i = nextIndex - 1; i >= 0; i--) {
	            if (array[i] > n) {
	                array[i + 1] = array[i];
	                insertIndex = i;
	            } else {
	                break;
	            }
	        }

	        array[insertIndex] = n;
	        
	        nextIndex++;
	    }
	
	public static void main(String[] args) {
		SortedArray sArray = new SortedArray(10);
		Scanner sc = new Scanner(System.in);
		System.out.print(">>");
		for (int i = 0; i < sArray.length(); i++) {
			int n = sc.nextInt();
			sArray.add(n);
		}
		sArray.print();
		sc.close();
	}
	
}
