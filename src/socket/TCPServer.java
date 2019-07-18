package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String args[]) {
		ServerSocket ss = null;
		BufferedReader in = null;
		try {
			ss = new ServerSocket(6688);
			System.out.println("服务器启动...");
			Socket s = ss.accept();
			System.out.println("有客户端请求连接，ip："
					+ s.getInetAddress().getHostAddress());

			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String clientStr;
			
			while(!(clientStr=in.readLine()).equals("aa."))
				System.out.println("输出客户端信息：" + clientStr);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (ss != null) {
					ss.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
