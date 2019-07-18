package homework_1;

import java.util.Scanner;

public class CountChar {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String test = in.next();
		count(test);
		in.close();
	}
	public static void count(String test) {
		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		for(int i = 0; i < test.length(); i++) {
			Character c = test.charAt(i);
			if((c>='A'&&c<='Z')||(c>='a'&&c<='z')) {
				cnt2++;
			}else if(Character.isDigit(c)) {
				cnt3++;
			}else
				cnt1++;
		}
		System.out.println("中文字符个数："+cnt1);
		System.out.println("英文字符个数："+cnt2);
		System.out.println("数字字符个数："+cnt3);
	}
}
