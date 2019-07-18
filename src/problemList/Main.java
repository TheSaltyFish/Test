package problemList;
import java.util.Scanner;;
public class Main {
	public static void main(String[] args) {
		int a,b;
		
		Scanner in = new Scanner(System.in);
		
		while(in.hasNextInt()) {
			a = in.nextInt();
			b = in.nextInt();
			System.out.println(a*b/gcd(a,b));
		}
		in.close();
	}
	public static int gcd(int a, int b) {
		return (b!=0)?gcd(b,a%b):a;
	}
}
