package com.endava.recursion;

public class Print1ToN {
   public static void main(String[] args) {
	
	   printNumbers(5);
	   
}
   
   static void printNumbers(int n) {
	   if(n==0) {
		   return;
	   }
	   printNumbers(n-1);
	   print(n); 
   }
   
   
   static void print(int n) {
		System.out.println(n);
	}
}
