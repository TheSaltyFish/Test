package homework_2;

import java.util.*;

public class ByteException {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		try {
			check(x);
		}catch(ByteSizeException e) {
			e.printStackTrace();
		}
		in.close();
	}
	public static void check(int x) throws ByteSizeException{
		if(x>127||x<-127) {
			throw new ByteSizeException();
		}else {
			System.out.println("未出现异常！");
		}
	}
}

class ByteSizeException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ByteSizeException(){
		super("输入的数字不是Byte类型！");
	}
}
