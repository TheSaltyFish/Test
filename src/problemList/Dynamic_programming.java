package problemList;

import java.util.Scanner;

public class Dynamic_programming {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a,b;
		int n = in.nextInt();
		while(n != 0) {
			a = in.next();
			b = in.next();
			memo(a,b);
			n--;
		}
		in.close();
	}
	public static void memo(String a,String b) {
		int len_a = a.length();
		int len_b = b.length();
		int[][] arr = new int [len_a+1][len_b+1];
		for(int i = 0; i <= len_a; i++) {
			for(int j = 0; j <= len_b; j++) {
				if(i == 0|| j == 0) {
					arr[i][j] = 0;
				}
				else if(a.charAt(i-1)==b.charAt(j-1)) {
					arr[i][j] = arr[i-1][j-1]+1;
				}else {
					arr[i][j] = Math.max(arr[i-1][j],arr[i][j-1]);
				}
			}
		}
		System.out.println(arr[len_a][len_b]);
	}
}
