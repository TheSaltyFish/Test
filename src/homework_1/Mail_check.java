package homework_1;

import java.util.Scanner;

public class Mail_check {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String mail = in.next();
		if(MailTest.testmail(mail)) {
			System.out.println("���������ȷ��");
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
				System.out.println("'.'������'@'ǰ�棡");
				return false;
			}
		}
		if(cnt1!=1||cnt2!=1) {
			System.out.println("'.'��'@'���������붼ֻ��һ����");
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
				System.out.println("�û������зǷ��ַ���");
				return false;
			}
		}
		return true;
	}
}