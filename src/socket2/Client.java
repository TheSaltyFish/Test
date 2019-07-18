package socket2;

import java.util.*;
import java.io.*;
import java.net.*;

public class Client {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("127.0.0.1",1234);
		System.out.println("已连接服务器。");
		Thread sen = new Csend(s);
		Thread rec = new Creceive(s);
		((Creceive) rec).set(sen);
		((Csend) sen).set(rec);
		rec.start();
		sen.start();
	}
}
class Creceive extends Thread{
	private Socket s;
	private Thread t1 = null;
	
	Creceive(Socket s){
		this.s = s;
	}
	public void set(Thread t) {
		t1 = t;
	}
	public void run() {
		while(true) {
			try {
				if(s.isClosed())
					break;
				else {
					DataInputStream in = new DataInputStream(s.getInputStream());
					String str;
					if(s.isClosed())
						break;
					else
						str = in.readUTF();
					System.out.println("来自客户端的信息：" + str);
	
					if(str.equals("stop")) {
						s.close();
						in.close();
						if(t1 != null) {
							t1.interrupt();
						}
						break;
					}
				}
			}catch(IOException e) {
				break;
			}
		}
	}
}
class Csend extends Thread{
	private Socket s;
	private Scanner sc = new Scanner(System.in);
	private Thread t1;
	Csend(Socket s){
		this.s = s;
	}
	public void set(Thread t) {
		t1 = t;
	}
	public void run() {
		while(true) {
			try {
				DataOutputStream out = new DataOutputStream(s.getOutputStream());
				System.out.println("请输入信息：");
				String str = sc.next();
				out.writeUTF(str);
				out.flush();
				if(str.equals("stop")) {
					s.close();
					out.close();
					t1.interrupt();
					break;
				}
			}catch(IOException e) {
				break;
			}
		}
		System.out.println("连接已断开！");
	}
}
