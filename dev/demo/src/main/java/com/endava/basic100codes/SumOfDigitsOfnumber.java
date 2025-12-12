package com.endava.basic100codes;

import java.util.Scanner;

public class SumOfDigitsOfnumber {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();
		
		System.out.println(getSumOfDigitsOfNumbers(number));
		sc.close();
	}

	private static int getSumOfDigitsOfNumbers(int number) {
		int sum = 0;
		while (number>0) {
			int l = number%10;
			sum+=l;
			number/=10;
		}
		
		return sum;
	}

}
