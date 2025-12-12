package com.endava.recursion;

public class PrintNto1 {
public static void main(String[] args) {
	fun(5);
}

static void fun(int n) {
	if (n==1) {
		print(1);
		return;
	}
	print(n);
	fun(n-1);
}

static void print(int n) {
	System.out.println(n);
}
}
