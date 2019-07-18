package homework_2;

public class StringException {
	public static void main(String[] args) {
		String s1 = "wasd";
		String s2 = "";
		compare(s1,s2);
	}
	public static void compare(String s1, String s2) {
		try {
			check(s1);
			check(s2);
			System.out.println("无异常发生！");
		}catch(NullPointerException e) {
			System.out.println("NullPointerException!");
			e.printStackTrace();
		}
	}
	public static boolean check(String s) throws NullPointerException{
		if(s.length() == 0)
			throw new NullPointerException();
		else
			return true;
	}
}
class NullPointerException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
