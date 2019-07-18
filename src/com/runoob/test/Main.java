package com.runoob.test;

public class Main {
	public static void main(String[] args) {
		student s = new student(23333);
		teacher t = new teacher(25000);
		s.findteacher(t);
		t.findstudent(s);
		s.study();
	}
}
class student{
	private teacher t;
	int id;
	student(int id){
		this.id = id;
	}
	void printID() {
		System.out.println(id);
	}
	void findteacher(teacher t) {
		this.t = t;
	}
	void study() {
		if(this.t != null)
			System.out.println(t.id);
		else
			System.out.println("你没有老师！");
	}
}
class teacher{
	private student s;
	int id;
	teacher(int id){
		this.id = id;
	}
	void printID() {
		System.out.println(id);
	}
	void findstudent(student s) {
		this.s = s;
	}
	void teach() {
		if(this.s != null)
			System.out.println(s.id);
		else
			System.out.println("你没有学生！");
	}
}
