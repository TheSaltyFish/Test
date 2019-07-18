package homework_1;

import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String x = in.next();
		if(check(x)) {
			System.out.println("是回文数！");
		}else
			System.out.println("不是回文数！");
		in.close();
	}
	public static boolean check(String x) {
		String y = "";
		for(int i = x.length()-1; i >= 0; i--) {
			y += x.charAt(i);
		}
		for(int i = 0; i < x.length(); i++) {
			if(x.charAt(i) != y.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}
