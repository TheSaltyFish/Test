package problemList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestDateTime {
	public static void main(String[] args) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Scanner in = new Scanner(System.in);
		System.out.println("��������Ʒ���������ڣ�(yyyy-MM-dd)");
		String date1 = in.next();
		System.out.println("�����뱣����(��)��");
		int d = in.nextInt();
		Date now  = new Date();
		sdf.format(now);
		System.out.println("��������Ϊ��" + sdf.format(now));
		Date b = sdf.parse(date1);
		long day = (now.getTime() - b.getTime())/(1000*3600*24);
		String s1;
		if(day < d) {
			s1 = "����"+(d-day)+"�����";
		}else {
			s1 = "����Ʒ�Ѿ�����";
		}
		System.out.println(s1);
		in.close();
	}
}
