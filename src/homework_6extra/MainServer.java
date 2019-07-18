package homework_6extra;

import java.net.*;
import java.io.*;

public class MainServer {
	public static ServerSocket ss;
	public static void main(String[] args) throws IOException{
		ss = new ServerSocket(6666);
		System.out.println("��������������");
		dispose user1 = new dispose(ss.accept());
		dispose user2 = new dispose(ss.accept());
		
		combine(user1,user2);
		
		user1.start();
		user2.start();
	}
	public static void combine(dispose user1,dispose user2) {
		user1.setSocket(user2.getSocket());
		user2.setSocket(user1.getSocket());
	}
}
class dispose extends Thread {
	private Socket s = null;
	private Socket other = null;
	private String message;
	dispose(Socket s){
		this.s = s;
		System.out.println("�ͻ���"+s.getPort()+"������");
	}
	public void setSocket(Socket s) {
		other = s;
	}
	public void convert(Socket s,String message) {
		if(s.isClosed()) {
			try {
				DataOutputStream out = new DataOutputStream(this.s.getOutputStream());
				out.writeUTF("(�Զ��ظ�)��ã����������²��ڣ�������Ӻ�����ϵ�ң�����һ����ڣ����ٿ�һ�����Ϣ��");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		try {
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			out.writeUTF(message);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public Socket getSocket() {
		return s;
	}
	public void run() {
		
		try {
			DataInputStream in = new DataInputStream(s.getInputStream());
			while(true) {
				String str = in.readUTF();
				message = str;
				if(str.equals("stop")) {
					in.close();
					break;
				}
				convert(other,message);
			}
		}catch(IOException e) {
			System.out.println("��������û�"+s.getPort()+"�������ѶϿ���");
		}
		try {
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}