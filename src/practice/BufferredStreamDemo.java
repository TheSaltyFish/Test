package practice;

import java.io.*;

public class BufferredStreamDemo {
	public static void main(String[] agrs) {
		try {
			byte[] bytes = {1,2,3,4,5};
			ByteArrayInputStream in = new ByteArrayInputStream(bytes);
			BufferedInputStream bis = new BufferedInputStream(in,2);
			System.out.print(bis.read() + ",");
			System.out.println("mark");
			bis.mark(1);
			System.out.print(bis.read() + ",");
			System.out.print(bis.read() + ",");
			System.out.println("reset");
			bis.reset();
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
