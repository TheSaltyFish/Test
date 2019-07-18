package homework_6extra;

import java.io.IOException;
import java.net.Socket;

public class Client2 {
	private static Socket s = null;
	public static void main(String[] args) throws IOException{
		s = new Socket("127.1.0.2",6666);
		System.out.println("Client2-成功连接服务器");
		new InputThread(s).start();
		new OutputThread(s).start();
		
	}
}
