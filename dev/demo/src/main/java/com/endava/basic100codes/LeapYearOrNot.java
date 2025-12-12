package com.endava.basic100codes;

import java.util.Scanner;

public class LeapYearOrNot {

	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		
		int number = sc.nextInt();
		
		System.out.println(isLeapYear(number));
		
		sc.close();
		

	}

	private static String isLeapYear(int number) {
		
		return (number %400 ==0 || (number %4 ==0 && number %100 !=0)) ? "Yes" : "No";
	}

}
