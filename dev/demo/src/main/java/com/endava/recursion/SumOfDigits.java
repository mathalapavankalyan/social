package com.endava.recursion;

public class SumOfDigits {

	static int result = 0;
	public static void main(String[] args) {
		
	    sumOfDigits(19123);
	    System.out.println(result);
        
	    System.out.println(sumOfDigitss(4536));
	    sumOfDigits(234, 0);
	}
	
	// way -1
	private static void sumOfDigits(int n) {
		
		if (n==0) {
			return;
		}
		result += (n%10);
		sumOfDigits(n/10);
	    
	}
	

   // way-2
   private static int sumOfDigitss(int n) {
		
		if (n==0) {
			return n;
		}
		
		return (n%10) + sumOfDigitss(n/10);
	    
	}
   
   // way-3
   private static void sumOfDigits(int n , int ans) {
		
		if (n==0) {
			System.out.println(ans);
			return;
		}
		
		sumOfDigits(n/10 , ans+n%10);
	    
	}

}
