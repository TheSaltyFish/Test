package homework_6;

import java.io.*;
import java.util.*;
import java.net.*;

public class H1_Client {
	public static void main(String[] args) throws IOException{
		Socket s = new Socket("127.1.0.1",6666);
		DataOutputStream out = new DataOutputStream(s.getOutputStream());
		Scanner sc = new Scanner(System.in);
		System.out.println("输入一组数字：");
		String str = sc.nextLine();
		sc.close();
		out.writeUTF(str);
		out.flush();
		DataInputStream in = new DataInputStream(s.getInputStream());
		System.out.println(in.readUTF());
		out.close();
		in.close();
		s.close();
	}
}
