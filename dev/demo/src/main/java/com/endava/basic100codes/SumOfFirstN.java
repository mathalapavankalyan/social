package com.endava.basic100codes;

import java.util.Scanner;

public class SumOfFirstN {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();
		
		System.out.println(getSumOfNumbers(number));
		sc.close();
	}

	private static int getSumOfNumbers(int number) {
		return (number *(number +1))/2;
	}

}
