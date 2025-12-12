package com.endava.recursion;

public class CountZeroesNumber {
 public static void main(String[] args) {
	System.out.println(countZeroes(100 , 0));
}

 private static int countZeroes(int n, int c) {
	if (n==0) {
		return c;
	}
	int l = n%10;
	if (l==0) {
		c+=1;
	}
	
	return countZeroes(n/10 , c);
 }
}
