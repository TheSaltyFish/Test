package socket2;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(1234);
		System.out.println("等待连接。。。");
		Socket s = ss.accept();
		System.out.println("IP为"+s.getPort()+"的用户已连接。");
		Thread rec = new Sreceive(s,ss);
		Thread sen = new Ssend(s);
		((Sreceive) rec).set(sen);
		((Ssend) sen).set(rec);
		sen.start();
		rec.start();
		
	}
}
class Ssend extends Thread{
	private Socket s;
	private Thread t1 = null;
	private Scanner sc = new Scanner(System.in);
	Ssend(Socket s){
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
				DataOutputStream out = new DataOutputStream(s.getOutputStream());
				System.out.println("请输入信息：");
				String str = sc.next();
				out.writeUTF(str);
				out.flush();
				if(str.equals("stop")) {
					t1.interrupt();
					s.close();
					out.close();
					break;
				}
			}catch(IOException e) {
				break;
			}
		}
		System.out.println("连接已断开！");
	}
}
class Sreceive extends Thread{
	private ServerSocket ss;
	private Socket s;
	private Thread t1 = null;
	Sreceive(Socket s,ServerSocket ss){
		this.s = s;
		this.ss = ss;
	}
	public void set(Thread t) {
		t1 = t;
	}
	public void run() {
		while(true) {
			try {
				DataInputStream in = new DataInputStream(s.getInputStream());
				String str;
				if(s.isClosed())
					break;
				else
					str = in.readUTF();
				
				System.out.println("来自客户端的信息：" + str);
				
				if(str.equals("stop")) {
					t1.interrupt();
					s.close();
					ss.close();
					in.close();
					break;
				}
			}catch(IOException e) {
				break;
			}
		}
		System.out.println("连接已断开。");
	}
}