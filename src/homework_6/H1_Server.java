package homework_6;

import java.io.*;
import java.net.*;

public class H1_Server {
	public static void main(String[] args) throws IOException{
		ServerSocket server = new ServerSocket(6666);
		Socket s = server.accept();
		DataInputStream in = new DataInputStream(s.getInputStream());
		DataOutputStream out = new DataOutputStream(s.getOutputStream());
		String x = in.readUTF();
		if(dispose(x)) {
			out.writeUTF(sort(x));
			out.flush();
		}else {
			out.writeUTF("∏Ò Ω¥ÌŒÛ£°");
		}
		server.close();
	}
	public static String sort(String x) {
		String[] y = x.split(" ");
		qsort(y,0,y.length-1);
		String temp = "";
		for(int i = 0;i < y.length;i++) {
			temp += y[i];
			if(i != y.length-1)
				temp += " ";
		}
		return temp;
	}
	public static int cmp(String s1,String s2) {
		if(s1.length() == s2.length()){
			return s1.compareTo(s2);
		}else {
			return s1.length() - s2.length();
		}
	}
	public static void qsort(String[] y,int l,int r) {
		int i = l,j = r;
		if(i>=j)
			return;
		String temp = y[i];
		while(i<j) {
			while(i<j && cmp(temp,y[j]) <= 0) j--;
			if(i<j) y[i++] = y[j];
			while(i<j && cmp(temp,y[i]) >= 0)i++;
			if(i<j) y[j--] = y[i];
		}
		y[i] = temp;
		qsort(y,l,i-1);
		qsort(y,i+1,r);
	}
	public static boolean dispose(String x) {
		int len = x.length();
		for(int i = 0; i < len; i++) {
			char c = x.charAt(i);
			if(error(c))
				return false;
		}
		return true;
	}
	public static boolean error(Character c) {
		if(Character.isDigit(c)||c == ' ')
			return false;
		return true;
	}
}