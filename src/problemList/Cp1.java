package problemList;

import java.util.Scanner;

public class Cp1 {
	public static void main(String[] args) {
		boolean visit[] = new boolean[36];
		init(visit);
		double x;
		int num;
		int ticket[] = new int[7];
		for(int i=0;i<7;i++){
			do {
				x = Math.random();
				num = (int)(x*35 + 1);
			}while(visit[num]);
			visit[num]=true;
			ticket[i]=num;
		}
		qsort(ticket,0,ticket.length-1);
		Scanner in = new Scanner(System.in);
		System.out.println("先说好，你（们）有几个人在抽奖？(输入人数)");
		int n = in.nextInt();
		player p[] = new player[n];
		for(int i=0;i<n;i++) {
			p[i] = new player(in,ticket);
		}
		for(int i=0;i<n;i++) {
			System.out.println("输入第"+(i+1)+"个人的幸运号码（7个数字）：");
			p[i].input();
		}

		System.out.println("开奖了！中奖号码是。。。");
		for(int i=0;i<7;i++) {
			try {
				System.out.print(ticket[i]+" ");
				Thread.sleep(500);
			}catch(Exception e){
				System.out.println("程序运行出错！");
			}
		}
		System.out.println();
		for(int i=0;i<n;i++) {
			System.out.println("第"+(i+1)+"个人的中奖情况是：");
			p[i].out(ticket);
		}
		in.close();
	}
	public static void init(boolean[] visit) {
		for(int i = 0; i<36; i++) {
			visit[i] = false;
		}
	}
	public static void qsort(int[] x, int l, int r) {
		if(l>=r)
			return;
		int temp = x[l];
		int i=l,j=r;
		while(i<j) {
			while(i<j && temp <= x[j])j--;
			if(i<j)x[i++] = x[j];
			while(i<j && temp >= x[i])i++;
			if(i<j)x[j--] = x[i];
		}
		x[i] = temp;
		qsort(x,l,i-1);
		qsort(x,i+1,r);
	}
}
class player{
	public boolean flag;
	public int cnt;
	public int mine[] = new int[7];
	public int[] ticket;
	public Scanner in;
	player(Scanner in,int[] ticket) {
		this.in=in;
		this.ticket=ticket;
	}
	public void input() {
		boolean used[] = new boolean[36];
		for(int i=0;i<35;i++) {
			used[i] = false;
		}
		for(int i=0;i<7;i++) {
			try {
				mine[i] = in.nextInt();
			}catch(Exception e){
				System.out.print("非法输入!");
				i--;
				continue;
			}
			if(mine[i]>36||mine[i]<1) {
				System.out.println("请输入范围在1~35的号码！");
				i--;
				continue;
			}else if(used[mine[i]]) {
				System.out.println("请不要输入重复的号码！");
				i--;
			}else {
				used[mine[i]] = true;
			}
		}
	}
	public void out(int ticket[]) {
		flag=false;
		cnt=0;
		for(int i=0;i<7;i++) {
			for(int j=0;j<7;j++){
				if(mine[i]==ticket[j]) {
					flag=true;
					cnt++;
					System.out.print(mine[i]+" ");
					break;
				}
			}
		}
		if(!flag) {
			System.out.println("抱歉你没有中奖。");
		}else {
			System.out.println("你中奖号码的个数为:"+cnt);
		}
	}
}
