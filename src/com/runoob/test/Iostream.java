package com.runoob.test;

import java.io.*;

public class Iostream {
	public static void main(String[] args) throws IOException{
		char c;
		BufferedReader br = new BufferedReader(new 
				InputStreamReader(System.in));
		System.out.println("ÊäÈë×Ö·û£¬°´¡®q¡¯ÍË³ö¡£");
		do {
			c = (char) br.read();
			System.out.println(c);
		}while(c!='q');
	}
}
