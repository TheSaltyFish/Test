package homework_1;

import java.util.Scanner;

public class Mail_check {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String mail = in.next();
		if(MailTest.testmail(mail)) {
			System.out.println("邮箱测试正确！");
		}
		in.close();
	}
}
class MailTest{
	static String mail;
	public static boolean testmail(String mail) {
		MailTest.mail = mail;
		if(!check1())
			return false;
		return check2();
	}
	private static boolean check1(){
		int cnt1 = 0;
		int cnt2 = 0;
		for(int i = 0;i<mail.length();i++) {
			if(mail.charAt(i) == '@') {
				cnt1++;
			}else if(mail.charAt(i) == '.') {
				cnt2++;
			}
			if(cnt2>cnt1 && cnt1 == 0) {
				System.out.println("'.'不能在'@'前面！");
				return false;
			}
		}
		if(cnt1!=1||cnt2!=1) {
			System.out.println("'.'或'@'的数量必须都只有一个！");
			return false;
		}
		return true;
	}
	private static boolean check2() {
		String name = "";
		for(int i = 0; i < mail.length() && mail.charAt(i)!='@'; i++) {
			name += mail.charAt(i);
		}
		for(int i = 0; i < name.length();i++) {
			char c = name.charAt(i);
			if(c<'0'||c>'z'||(c>'9'&&c<'A')||(c>'Z'&&c<'a')) {
				System.out.println("用户名中有非法字符！");
				return false;
			}
		}
		return true;
	}
}