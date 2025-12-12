package com.endava.basic100codes;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();
		
		System.out.println(isPrime(number));
		sc.close();
	}

	private static String isPrime(int number) {
	    if (number < 2) return "No";
	    for (int i = 2; i * i <= number; i++) {
	        if (number % i == 0) return "No";
	    }
	    return "Yes";
	}
}
