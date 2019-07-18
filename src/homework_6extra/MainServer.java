package homework_6extra;

import java.net.*;
import java.io.*;

public class MainServer {
	public static ServerSocket ss;
	public static void main(String[] args) throws IOException{
		ss = new ServerSocket(6666);
		System.out.println("服务器已启动。");
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
		System.out.println("客户端"+s.getPort()+"已连接");
	}
	public void setSocket(Socket s) {
		other = s;
	}
	public void convert(Socket s,String message) {
		if(s.isClosed()) {
			try {
				DataOutputStream out = new DataOutputStream(this.s.getOutputStream());
				out.writeUTF("(自动回复)你好，我现在有事不在，请五分钟后再联系我，如果我还不在，请再看一遍此消息。");
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
			System.out.println("服务端与用户"+s.getPort()+"的连接已断开！");
		}
		try {
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}