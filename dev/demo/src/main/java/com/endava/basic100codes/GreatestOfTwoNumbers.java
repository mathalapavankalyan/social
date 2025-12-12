package com.endava.basic100codes;

import java.util.Scanner;

public class GreatestOfTwoNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int firstNumber = sc.nextInt();
		int secondNumber = sc.nextInt();
		
		System.out.println(getLargestOfTwoNumbers(firstNumber ,secondNumber) );
		sc.close();
	}

	private static int getLargestOfTwoNumbers(int firstNumber , int secondNumber) {
		
		return Math.max(firstNumber, secondNumber);
	}
}
