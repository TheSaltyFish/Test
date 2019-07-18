package com.runoob.test;

import java.io.*;

public class FileStream {
	public static void main(String[] args) throws IOException{
		char num[] = {1, 21, 3, 40, 5};
		OutputStream os = new FileOutputStream ("C:/Users/27378/Desktop/text.txt");
		for(int x=0;x<num.length;x++) {
			os.write(num[x]);
		}
		os.write('\n');
		os.close();
		
		InputStream is = new FileInputStream("C:/Users/27378/Desktop/text.txt");
		int size = is.available();
		
		for(int i = 0; i < size; i++) {
			System.out.print((char)is.read()+" ");
		}
		is.close();
	}
}
