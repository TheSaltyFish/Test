package homework_6extra;

import java.io.*;
import java.net.*;
import java.util.*;

class OutputThread extends Thread{
	Socket s = null;
	private Scanner sc = new Scanner(System.in);
	OutputThread(Socket s){
		this.s = s;
	}
	public void run() {
		try {
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			String str;
			while(!(str=sc.nextLine()).equals("stop")) {
				out.writeUTF(str);
				out.flush();
			}
			out.close();
		}catch(IOException e) {
			System.out.println("与服务器的连接已断开");
		}
	}
}
