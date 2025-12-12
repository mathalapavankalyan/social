package com.endava.basic100codes;

import java.util.Scanner;

public class PalindromeNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();
		
		System.out.println(isPalindrome(number));
		sc.close();
	}

	private static String isPalindrome(int number) {
		int rev = 0;
		int original = number;
		while (number > 0) {
			int l  = number%10;
			rev = rev*10+l;
			number/=10;
		}
		
		return (original == rev)?"Yes":"No";
	}

}
