package com.endava.basic100codes;

import java.util.Scanner;

public class GreatestOfThreeNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int firstNumber = sc.nextInt();
		int secondNumber = sc.nextInt();
		int thirdNumber = sc.nextInt();
		
		System.out.println(getLargestOfThreeNumbers(firstNumber ,secondNumber , thirdNumber) );
		sc.close();
	}

	private static int getLargestOfThreeNumbers(int firstNumber, int secondNumber, int thirdNumber) {
		
		return Math.max(firstNumber, Math.max(secondNumber, thirdNumber));
	}

}
