package com.endava.recursion;

public class Palindrome {

	public static void main(String[] args) {
				
		if(palindrome(121)) {
			
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}
	
	

	static  boolean palindrome(int n) {
		return (n== reverseNumber(n));
	}

	private static int reverseNumber(int n) {
		if(n<10) {
			return n;
		}
		int numDigits = (int)Math.log10(n);
		int lastDigit = n%10;
	    return (int)(lastDigit * Math.pow(10, numDigits)) + reverseNumber(n / 10);
	}
}
