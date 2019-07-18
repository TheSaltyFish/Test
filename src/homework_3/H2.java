package homework_3;

import java.io.*;

public class H2 {
	public static void main(String[] args) throws Exception {
		String path = "C:/Users/27378/Desktop/";
		File f1 = new File(path+"f1.txt");
		File f2 = new File(path+"f2.txt");
		if(!f1.exists()) {
			System.out.println("f1文件不存在");
			return;
		}
		if(!f2.exists()) {
			f2.createNewFile();
		}
		FileInputStream fis = new FileInputStream(f1);
		FileOutputStream fos = new FileOutputStream(f2);
		byte[] b = new byte[fis.available()];
		fis.read(b);
		fos.write(b);
		fos.flush();
		System.out.println("文件复制成功！");
		fis.close();
		fos.close();
	}
}
