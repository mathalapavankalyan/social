package com.endava.basic100codes;

import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();
		
		System.out.println(getReversedNumber(number));
		sc.close();
	}

	private static int getReversedNumber(int number) {
		
		int rev = 0;
		while (number > 0) {
			int l  = number%10;
			rev = rev*10+l;
			number/=10;
		}
		return rev;
	}

}
