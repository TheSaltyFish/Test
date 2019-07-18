package homework_1;

import java.util.Scanner;

public class CountE {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String x = in.next();
		int cnt = countE(x);
		System.out.println(cnt);
		in.close();
	}
	public static int countE(String x) {
		int cnt = 0;
		for(int i = 0;i<x.length();i++) {
			if(x.charAt(i) == 'e'){
				cnt++;
			}
		}
		return cnt;
	}
}
