package com.runoob.test;

public class Lambda {
	public static void main(String[] args) {
		Lambda test = new Lambda();
		MathOperation add = (a, b) -> a+b;
		MathOperation sub = (a, b) -> a-b;
		MathOperation mul = (a, b) -> a*b;
		MathOperation dev = (a, b) -> a/b;
		System.out.println(test.operate(1, 2, add));
		System.out.println(test.operate(1, 2, sub));
		System.out.println(test.operate(1, 2, mul));
		System.out.println(test.operate(1, 2, dev));
		System.out.println(test.operate(3, 2, (a, b)->{
			int base = a;
			int ans = 1;
			while(b!=0) {
				if(b%2!=0) {
					ans*=base;
				}
				base*=base;
				b>>=1;
			}
			return ans;
		}));
	}
	
	interface MathOperation{
		int operation(int a, int b);
	}
	
	private int operate(int a, int b, MathOperation op){
		return op.operation(a, b);
	}
}
