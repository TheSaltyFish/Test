package com.runoob.test;

public class Sample1 {
	int puppyAge;
	public Sample1(String name) {
		System.out.println("С���������ǣ�"+name);
	}
	public void setAge(int age) {
		puppyAge=age;
	}
	public void getAge() {
		System.out.println("С��������Ϊ��"+puppyAge);
	}
	public static void main(String []args) {
		Sample1 myPuppy =new Sample1("tommy");
		myPuppy.setAge(2);
		myPuppy.getAge();
		System.out.println("����ֵ��"+myPuppy.puppyAge);
	}
}
