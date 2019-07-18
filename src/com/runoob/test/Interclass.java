package com.runoob.test;

public class Interclass{
	public class operation implements Operation{
		public void op1(){
			System.out.println("operation1.");
			doit();
		}
		public void op2() {
			System.out.println("operation2.");
			doit();
		}
		
	}
	public static void main(String[] args) {
		Interclass.operation x = new Interclass().new operation();
		x.op1();
		x.op2();
		aba a = new aba();
		a.op1();
		a.op2();
		aba.in b = a.new in();
		a.op();
		b.op();
	}
	public static void doit() {
		System.out.println("doit");
	}
}
interface Operation{
	void op1();
	void op2();
}
class aba implements Operation{
	public void op1() {
		System.out.println("test1");
	}
	public void op2() {
		System.out.println("test2");
	}
	public void op() {
		System.out.println("out");
	}
	class in{
		public void op(){
			System.out.println("in");
		}
	}
}