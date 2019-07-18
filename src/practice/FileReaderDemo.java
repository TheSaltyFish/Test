package practice;

import java.io.*;

public class FileReaderDemo {
	public static void main(String[] args) {
		File f = new File("C:/Users/27378/Desktop/test.txt");
		FileReader fr = null;
		try {
			fr = new FileReader(f);
			int c;
			while((c=fr.read())!=-1) {
				System.out.println((char)c);
			}
		}catch(FileNotFoundException e) {
			System.out.println("Ҫ��ȡ���ļ�������");
		}catch(IOException e) {
			System.out.println("��ȡ����");
			e.printStackTrace();
		}finally {
			try {
				if(fr!=null)
					fr.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
