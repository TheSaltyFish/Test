package com.runoob.test;

import java.util.Scanner;
import java.util.Arrays;

public class Sort_And_Function_Use {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] num= {1,6,4,5,9,7,8,3,2,0};
		Arrays.sort(num);
		
		for(int i=0;i<10;i++) {
			System.out.print(num[i]);
		}
		System.out.println();
		int x=in.nextInt();
		int n=in.nextInt();	
		int ans = power(x,n);
		System.out.println(ans);
		in.close();
	}
	public static int power(int x,int n) {
		int ans=1,base=x;
		while(n!=0) {
			if((n&1)!=0) {
				ans*=base;
			}
			base*=base;
			n>>=1;
		}
		return ans;
	}
}
