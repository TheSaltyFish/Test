package homework_3;

import java.io.*;

public class H3 {
	public static void main(String[] args) throws Exception{
		String path1 = "C:/Users/27378/Desktop/";
		String path2 = "D:/io";
		File f1 = new File(path1+"test.txt");
		File f2 = new File(path2+"test.txt");
		if(!f1.exists()) {
			System.out.println("test�ļ������ڣ�");
			return;
		}
		if(!f2.exists()) {
			f1.createNewFile();
		}
		FileReader fr = new FileReader(f1);
		FileWriter fw = new FileWriter(f2);
		int c;
		while((c=fr.read())!=-1) {
			char c0 = (char)c;
			if(c0 == 'l')
				c0 = Character.toUpperCase(c0);
			fw.write(c0);
		}
		fw.flush();
		fw.close();
		
		FileReader fr1 = new FileReader(f1);
		FileReader fr2 = new FileReader(f2);
		
		System.out.print("���ļ�"+f1.getAbsolutePath()+"��ȡ�������ǣ�");
		while((c=fr1.read())!=-1) {
			System.out.print((char)c);
		}System.out.println();
		
		System.out.print("ͨ������д���ļ�"+f2.getAbsolutePath()+"�������ǣ�");
		while((c=fr2.read())!=-1) {
			System.out.print((char)c);
		}System.out.println();
		
		fr.close();
		fr1.close();
		fr2.close();
	}
}
