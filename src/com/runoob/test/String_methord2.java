package com.runoob.test;

import java.util.Scanner;

public class String_methord2 {
	public static void main(String[] args) {
		String A="bowl";
		String B="knife";
		String C="fork";
		String D="chopsticks";
		String X;
		String[] ch=new String[4];
		int n,i,j;
		Scanner in = new Scanner(System.in);
		while(in.hasNextInt()) {
			n = in.nextInt();
			for(i=0,j=0;i<n;i++) {
				X = in.next();
				if(X.equals(A)||X.equals(B)||X.equals(C)||X.equals(D)){
					ch[j++]=X;
				}
			}
			for(i=0;i<j;i++) {
				if(i!=j-1) {
					System.out.print(ch[i]+" ");
				}
				else {
					System.out.println(ch[i]);
				}
			}
		}
		in.close();
	} 
}
