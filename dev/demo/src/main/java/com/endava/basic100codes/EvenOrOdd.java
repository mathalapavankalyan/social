package com.endava.basic100codes;

import java.util.Scanner;

public class EvenOrOdd {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();
		
		System.out.println(getEvenOrOdd(number));
		sc.close();
	}

	private static String getEvenOrOdd(int number) {
		
		return (number & 1) == 0? "even" :"odd";
	}

}
