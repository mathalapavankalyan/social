package com.endava.recursion;

public class SumOfNumbers {

	static int result = 0;
	public static void main(String[] args) {
//		 int res = sumOfNumbers(10);
		 
		 sumOfNumberss(10);
//		 System.out.println(res);
	}

//	private static int sumOfNumbers(int n) {
//		if (n==1) {
//			
//			return 1;
//		}
//		
//		return n+sumOfNumbers(n-1);
//		
//		
//	}
	
	private static void sumOfNumbers(int n , int result) {
		if (n==1) {
			result+=n;
			System.out.println(result);
			return;
		}
		
		sumOfNumbers(n-1 , result+n);
		try {
			Thread.sleep(700);
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally {
			System.out.println("call back happening...");

		}
	}

	
	// sum of n numbers without extra variable
	private static void sumOfNumberss(int n) {
		if (n==1) {
			result+=n;
			System.out.println(result);
			return;
		}
		
		sumOfNumbers(n-1 , result+n);
		try {
			Thread.sleep(700);
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally {
			System.out.println("call back happening...");

		}
	}
}
