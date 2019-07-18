package homework_1;

import java.util.Scanner;

public class String_add {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String x = in.next();
		String y = in.next();
		int xi = toInt(x);
		int yi = toInt(y);
		System.out.println(xi+yi);
		in.close();
	}
	public static int toInt(String x) {
		int temp = 1;
		int sum = 0;
		for(int i = x.length()-1; i>=0;i--) {
			sum += (x.charAt(i)-'0')*temp;
			temp *= 10;
		}
		return sum;
	}
}
