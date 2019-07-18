package socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClient {

	private static Scanner sc;

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = null;
		BufferedWriter out = null;
		s = new Socket("127.0.0.1", 6688);
		System.out.println("与服务器端建立连接...");
		System.out.println("客户端输入信息：");

		sc = new Scanner(System.in);
		String clientStr;
		out = new BufferedWriter(
				new OutputStreamWriter(s.getOutputStream()));
		while(!(clientStr=sc.nextLine()).equals("..")) {
			//String clientStr="hello";
			
			out.write(clientStr);
			out.flush();
		}
		s.close();
	}
}

