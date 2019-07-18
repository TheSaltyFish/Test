package com.runoob.test;

import java.util.Scanner;

public class Sample0 {
	int foot;
	double inch;
	Scanner in = new Scanner(System.in);
	public void setfoot() {
		System.out.print("请输入身高(英尺部分)：");
		int foot=in.nextInt();
		this.foot=foot;
	}
	public void setinch() {
		System.out.print("请输入身高(英寸部分)：");
		Double inch = in.nextDouble();
		this.inch=inch;
	}
	public void print() {
		System.out.println("foot="+foot);
		System.out.println("inch="+inch);
		System.out.printf("(foot+inch/12)*0.3048=%f\n",(foot+inch/12)*0.3048);
		System.out.println((foot+inch/12)*0.3048);
	}
    public static void main(String[] args) {
        Sample0 p1 = new Sample0();
        p1.setfoot();
        p1.setinch();
        p1.print();
        p1.in.close();
    }
}