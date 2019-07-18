package com.runoob.test;

public class Test {
	public static void main(String[] args) {   
		new A().print(2);
		new B().fun();
	}   
}
interface P{
	void fun();
	void f();
}
abstract class Q implements P{
	
	
}
class A {
	A(){
		
	}
	static int x = 1;
	void print(int x) {
		System.out.println(A.x);
	}
	void fun() {
		System.out.println(123);
	}
}
class B extends A{
	void fun() {
		System.out.println(111);
	}
	
}