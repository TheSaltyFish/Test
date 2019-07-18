package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class FileInputStreamDemo {
	private static FileInputStream fis;

	public static void main(String args[]) {
		try {
			 File f = new File("C:\\Users\\27378\\Desktop\\Code\\testdata\\data.txt");
			 fis = new FileInputStream(f);
			System.out.print((char)fis.read()+"\n");
			System.out.println(fis.available());
			byte b[] = new byte[fis.available()];
			fis.read(b);
			int j = 0;
			while (j < b.length) {
				System.out.print((char)b[j]);
				j++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
}