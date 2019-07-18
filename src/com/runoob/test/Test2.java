package com.runoob.test;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		shape a = new circle();
		shape b = new triangle();
		Draw(a);
		Draw(b);
		
		((circle) a).setr(in.nextInt());
		((circle) a).getr();

		while(!(((triangle) b).setlen(in.nextInt(), in.nextInt(), in.nextInt()))) {
			((triangle)b).getlen();
		}
		
		in.close();
	}
	public static void Draw(shape x) {
		if(x instanceof circle) {
			((circle) x).draw();
		}else if(x instanceof triangle) {
			((triangle) x).draw();
		}
	}
}
abstract class shape {
	abstract void draw();
}
final class circle extends shape{
	double radius;
	void draw() {
		System.out.println("Draw a circle.");
	}
	void setr(int radius) {
		this.radius=radius;
	}
	void getr() {
		System.out.println("The radius is "+radius+".");
	}
}
final class triangle extends shape{
	double a, b, c;
	void draw() {
		System.out.println("Draw a triangle.");
	}
	boolean setlen(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
		if(a+b<=c||a+c<=b||b+c<=a) {
			System.out.println("Invalid input,can not construct a triangle.");
			System.out.println("Please enter the lenth again:");
			return false;
		}
		return true;
	}
	void getlen() {
		System.out.println("a = "+a+","+"b = "+b+","+"c = "+c);
	}
}

