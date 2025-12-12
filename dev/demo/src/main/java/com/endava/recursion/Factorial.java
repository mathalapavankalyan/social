package com.endava.recursion;
//import java.util.*;

public class Factorial {
public static void main(String[] args) {
	
	 factVoid(5, 1);
	
}

//private static int fact(int n) {
//	if (n==1) {
//		return 1;
//	}
//	
//	return n*fact(n-1);
//}

private static void  factVoid(int n ,int result) {
	if (n==0) {
		System.out.println(result);
		return;
	}
	
	factVoid(n-1 , result*n);
	try {
		Thread.sleep(500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("call back coming...");
	
}
}
