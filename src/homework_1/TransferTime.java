package homework_1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TransferTime {
	public static void main(String[] args) throws ParseException {
		Scanner in = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		System.out.println("输入北京时间：(yyyy-MM-dd HH:mm)");
		String date_s = in.nextLine();
		Date date = sdf.parse(date_s);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.HOUR_OF_DAY, +7);
		System.out.println("巴黎时间是："+sdf.format(c.getTime()));
		c.add(Calendar.HOUR_OF_DAY, +5);
		System.out.println("纽约时间是："+sdf.format(c.getTime()));
		in.close();
	}
}
