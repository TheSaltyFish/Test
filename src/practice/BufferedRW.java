package practice;

import java.io.*;

public class BufferedRW {
	public static void main(String[] args) {
		BufferedWriter bw = null;BufferedReader br = null;
		try {
			File file = new File("C:/Users/27378/Desktop/test.txt");
			FileReader fr = new FileReader(file);
			br = new BufferedReader(fr);
			FileWriter fw = new FileWriter("C:/Users/27378/Desktop/data.txt");
			bw = new BufferedWriter(fw);
			// 读一个字符
//			System.out.println((char) br.read());
//			System.out.println((char) br.read());
//			// 读一行字符
//			System.out.println(br.readLine());
//			//复制文件
			String str;
			while ((str = br.readLine()) != null) {
				bw.write(str);
				bw.newLine();
			}
			bw.flush();
			bw.close();
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("文件复制成功");
	}
}
