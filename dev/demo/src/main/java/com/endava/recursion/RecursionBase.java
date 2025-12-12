package com.endava.recursion;

public class RecursionBase {

	public static void main(String[] args) {
		
		// write a function that takes in a number and prints it
		// print first 5 numbers: 1 2 3 4 5
		print(1);
	}
	
	public static void print(int n) {
		
		if(n==5) {
			return;
		}
		System.out.println("Hello world!");
		print(n+1);
	}

	
}
