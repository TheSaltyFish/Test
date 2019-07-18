package homework_6extra;

import java.io.*;
import java.net.*;

class InputThread extends Thread{
	Socket s = null;
	InputThread(Socket s){
		this.s = s;
	}
	public void run() {
		try {
			DataInputStream in = new DataInputStream(s.getInputStream());
			String str;
			while(!(str=in.readUTF()).equals("stop")) {
				System.out.print("�Է�������Ϣ��");
				System.out.println(str);
			}
			in.close();
		}catch(IOException e) {
			System.out.println("��������������ѶϿ���");
		}
	}
}
