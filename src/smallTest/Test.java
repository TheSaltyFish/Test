package smallTest;

import java.io.*;

public class Test {
	public static void main(String[] args) throws Exception {
		File f = new File("C:/Users/27378/Desktop/data.txt");
		if(!f.exists()) {
			f.createNewFile();
		}
		
		FileOutputStream fos = new FileOutputStream(f,true);
		
		byte[] b = {65,66,67,68,69,79,'\r','\n'};
		
		fos.write(b);
		fos.flush();
		fos.close();
	}
}
