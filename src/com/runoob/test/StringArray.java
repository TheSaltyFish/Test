package com.runoob.test;

import java.util.Scanner;

public class StringArray {
	public static void main(String[] args) {
		int t;
		int i,j,k;
		int count;
		String[] X= new String[3];
		X[0]="one";X[1]="two";X[2]="three";
		String text;
		Scanner in = new Scanner(System.in);
		t = in.nextInt();
		for(i=0;i<t;i++) {
			text = in.next();
			for(j=0;j<3;j++) {
				for(k=0,count=0;k<X[j].length();k++) {
					if(text.charAt(k)!=X[j].charAt(k)){
						count++;
					}
				}
				if(count<=1) {
					System.out.println(j+1);
					break;
				}
			}
		}
		in.close();
	} 
}
