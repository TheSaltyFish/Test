package com.runoob.test;

import java.util.Scanner;

public class String_methord {
	public static void main(String[] args) {
		long pro1,pro2;
		int i;
		int num=1;
		Scanner in= new Scanner(System.in);
        while(in.hasNext()) {
        	
        	String string1=in.next();
        	String string2=in.next();
        	
        	for(i=0,pro1=1;i<string1.length();i++) {
        		int c=string1.charAt(i)-'A'+1;
        		pro1*=c;
        	}
        	
        	for(i=0,pro2=1;i<string2.length();i++) {
        		int c=string2.charAt(i)-'A'+1;
        		pro2*=c;
        	}
        	if(pro1%47==pro2%47) {
        		System.out.println("CASE"+num+": GO");
        	}
        	
        	else {
        		System.out.println("CASE"+num+": STAY");
        	}
        	num++;
        }
        in.close();
    }
}
