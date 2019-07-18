package homework_1;

import java.util.Scanner;

public class CountSon {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String father = in.next();
		String son = in.next();
		System.out.println(count(father,son));
		in.close();
	}
	public static int count(String father,String son) {
		int cnt = 0;
		for(int i = 0;i < father.length();i++) {
			if(father.charAt(i) == son.charAt(0)) {
				if(check(i,father,son)) {
					cnt++;
					i += son.length()-1;
					continue;
				}
			}
		}
		return cnt;
	}
	private static boolean check(int index,String father,String son) {
		for(int i = 0;i < son.length(); i++,index++) {
			if(index>=father.length())return false;
			if(son.charAt(i) != father.charAt(index)) {
				return false;
			}
		}
		return true;
	}
}
