package com.runoob.test;

public class Sample1 {
	int puppyAge;
	public Sample1(String name) {
		System.out.println("小狗的名字是："+name);
	}
	public void setAge(int age) {
		puppyAge=age;
	}
	public void getAge() {
		System.out.println("小狗的年龄为："+puppyAge);
	}
	public static void main(String []args) {
		Sample1 myPuppy =new Sample1("tommy");
		myPuppy.setAge(2);
		myPuppy.getAge();
		System.out.println("变量值："+myPuppy.puppyAge);
	}
}
