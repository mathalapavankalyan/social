package com.endava.recursion;

public class ProductOfDigits {
	static int result = 1;

	public static void main(String[] args) {
		productOfDigits(123);
		
		System.out.println("way 1 : " +result);
		
		System.out.println("way 2 return type : "+productOfDigitss(123));
		
		System.out.println("way 3 parameterized : ");
		productOfDigits(4321, 1);
		
		
		System.out.println("Way 4 tail recursion : "+productOfDigitss(89 , 1));

	}

	private static void productOfDigits(int n) {
		if(n==n%10) {
			return;
		}
		
		result *= n%10;
		productOfDigits(n/10);
		
	}
	
	private static int productOfDigitss(int n) {
		if(n==n%10) {
			return n;
		}
		
		return n%10 * productOfDigitss(n/10);
		
	}
	
	private static void productOfDigits(int n , int ans) {
		if(n==n%10) {
			ans*=n;
			System.out.println(ans);
			return;
		}
		
		productOfDigits(n/10 , ans*n%10);
		
	}
	
	
	
	// tail recursion 
	private static int productOfDigitss(int n , int sol) {
		if(n==n%10) {
			return sol*n;
		}
		
		return productOfDigitss(n/10 , sol*(n%10));
		
	}

}
