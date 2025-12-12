package com.endava.recursion;

public class ReverseNumber {

	static int result = 0;
	public static void main(String[] args) {
		
		reverseNumber(211);
		System.out.println("approach one : "+result);
		System.out.println("approach two tail recursion : "+reverseNumber(321 , 0));
		System.out.println("approach three return type : "+reverseNumbers(5432));
		System.out.print("approach fourth without return : ");
		reverseNumberWithoutReturn(1234 , 0);
	}

	private static void reverseNumber(int n) {
		if(n==0) {
			return;
		}
		result = result*10 + (n%10);
        reverseNumber(n/10);		
	}
	
	
	private static int reverseNumber(int n , int ans) {
		if(n==0) {
			return ans;
		}
        return reverseNumber(n/10 , ans*10+(n%10));		
	}
	
	
	private static int reverseNumbers(int n) {
		if(n<10) {
			return n;
		}
		int numDigits = (int)Math.log10(n);
		int lastDigit = n%10;
	    return (int)(lastDigit * Math.pow(10, numDigits)) + reverseNumbers(n / 10);
	}
	
	
	private static void reverseNumberWithoutReturn(int n , int ans) {
		if(n==0) {
			System.out.println(ans);
			return;
		}
        reverseNumberWithoutReturn(n/10, ans*10+n%10);		
	}
}
