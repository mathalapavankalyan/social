package com.endava.basic100codes;

import java.util.Scanner;

public class PositiveOrNegative {
   
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();
		
		System.out.println(getPositiveOrNegative(number));
		sc.close();
	}

	private static String getPositiveOrNegative(int number) {
		
		return number>0 ? "positive" :number==0?"neutral":"negative";
	}
	
}
