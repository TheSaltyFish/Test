package homework_3;

import java.io.*;

public class H1 {
	public static void main(String[] args) throws Exception{
		String line = "-----------------------------------";
		String path = "C:/";
		String[] fileName = getName(path);
		for(int i = 0; i<fileName.length; i++) {
			System.out.println("文件名："+fileName[i]);
			getPath(fileName[i],path);
			System.out.println(line);
		}
	}
	public static String[] getName(String path){
		File file = new File(path);
		String[] fileName = file.list();
		return fileName;
	}
	public static void getPath(String name,String path) {
		File f = new File(path+"/"+name);
		System.out.println("路径:"+f.getAbsolutePath());
	}
}
