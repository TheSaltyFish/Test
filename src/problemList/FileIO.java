package problemList;

import java.io.*;
import java.util.*;

public class FileIO {
	public static void main(String[] args) throws Exception{
		FileReader reader = new FileReader("C:\\Users\\27378\\Desktop\\input.txt");
		Scanner in = new Scanner(reader);
		String x = in.next();
		System.out.println(x);
		in.close();
		FileWriter w = new FileWriter("C:\\Users\\27378\\Desktop\\output.txt");
		w.append("ªÕ÷æ±ø±øﬂ’");
		w.close();
		PrintWriter pw = new PrintWriter("C:\\Users\\27378\\Desktop\\output.txt");
		pw.println();
		pw.close();
	}
}

