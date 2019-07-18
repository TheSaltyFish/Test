package practice;

import java.io.*;

public class FileOutputStreamDemo {
	public static void main(String[] args) {
		FileOutputStream fout = null;

		try {
			//fout = new FileOutputStream("d:/io/c.txt");
			fout = new FileOutputStream("C:/Users/27378/Desktop/c.txt",true);
			/*byte[] c = { 'a', 'b', 'c' };
			fout.write(c);
			fout.write(97);*/
			
			byte[] ch = {'d','e','f','a','b'};
			fout.write(ch);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("文件写入成功");
	}
}
