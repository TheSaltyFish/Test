package practice;

import java.util.Scanner;

public class ThrowTest{
	int[] arr=new int[3];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			int a = in.nextInt();
			int b = in.nextInt();
			add(a,b);
		}catch(MyException e) {
			System.out.println(" ‰»Î¥ÌŒÛ£°");
		}
		in.close();
	}
	public static void add(int a, int b) throws MyException{
		if(a < 0 && b < 0) {
			throw new MyException();
		}else{
			System.out.println(a+b);
		}
	}
}
class MyException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}