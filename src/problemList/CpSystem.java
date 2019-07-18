package problemList;

import java.util.*;

public class CpSystem {
	public static void main(String[] args) {
		System.out.println("彩票系统启动！");
		Scanner in = new Scanner(System.in);
		cpCompany Company = new cpCompany();
		Vector<cpMan> v = new Vector<cpMan>();
		boolean flag = true;
		while(flag) {
			System.out.println("请选择：\n1.彩民来了\n2.开奖了");
			int login = in.nextInt();
			switch(login) {
			case 1:
				cpMan fool = new cpMan();
				v.add(fool);
				ImcpMan(in,fool,Company);
				break;
			case 2:
				if(v.size() == 0) {
					System.out.println("还没人买彩票，开个屁奖。。");
				}else{
					Company.createResult();
					Result(Company,in,v);
					flag = false;
				}
				break;
			default:
				System.out.println("没有这种操作！");
				break;
			}
		}
	}
	
	public static void Result(cpCompany Company,Scanner in,Vector<cpMan> v) {
		Result1(Company);
		Result2(Company,in,v);
	}
	public static void Result1(cpCompany Company) {
		System.out.println("开奖了！谁会是幸运儿？");
		pause(1500);
		System.out.println("一等奖（50000元）号码是："+Company.result[0]);
		System.out.print("二等奖（10000元）号码是：");
		for(int i = 1;i<3;i++) {
			System.out.print(Company.result[i]+"  ");
		}
		System.out.println();
		System.out.print("三等奖（3000元）号码是：");
		for(int i = 3;i<6;i++) {
			System.out.print(Company.result[i]+"  ");
		}
		System.out.println();
	}
	public static void Result2(cpCompany Company,Scanner in,Vector<cpMan> v) {
		System.out.println("下面宣布获奖得主！");
		System.out.print("一等奖：");
		if(!Company.visit[Company.result[0]]) {
			System.out.println("无人获得。。");
		}else {
			for(int i = 0;i<=100;i++) {
				if(Company.result[0] == Company.list.get(i).number) {
					System.out.println(Company.list.get(i).lord.name);
					Company.list.get(i).lord.money += 50000;
					break;
				}
			}
		}
		System.out.print("二等奖：");
		if( (!Company.visit[Company.result[1]]) && 
			(!Company.visit[Company.result[2]]) ) {
			System.out.println("无人获得。。");
		}
		else{
			for(int i = 1; i<3; i++) {
				if(Company.visit[Company.result[i]]) {
					for(int j = 0; j<=100;j++) {
						if(Company.result[i] == Company.list.get(j).number) {
							System.out.print(Company.list.get(j).lord.name+" ");
							Company.list.get(i).lord.money += 10000;
							break;
						}
					}
				}
			}
			System.out.println();
		}
		System.out.print("三等奖：");
		if( (!Company.visit[Company.result[3]]) && 
				(!Company.visit[Company.result[4]]) &&
				(!Company.visit[Company.result[5]]) ) {
				System.out.println("无人获得。。");
		}else{
			for(int i = 3; i<6; i++) {
				if(Company.visit[Company.result[i]]) {
					for(int j = 0; j<=100;j++) {
						if(Company.result[i] == Company.list.get(j).number) {
							System.out.print(Company.list.get(j).lord.name+" ");
							Company.list.get(i).lord.money += 3000;
							break;
						}
					}
				}
			}
			System.out.println();
		}
	}
	public static void pause(int time) {
		try{
			Thread.sleep(time);
		}catch(InterruptedException e) {
			
		}
	}
	public static void ImcpMan(Scanner in,cpMan fool,cpCompany Company) {
		System.out.println("请问您叫什么？");
		fool.name = in.next();
		System.out.println(fool.name+"先生，欢迎您来到无尽深渊！");
		boolean flag = true;
		while(flag) {
			System.out.println("请选择:\n1.买彩票\n2.走人");
			int login = in.nextInt();
			switch(login) {
			case 1:
				fool.buy(in, Company);
				break;
			case 2:
				if(fool.cpNum == 0) {
					System.out.println("您还没有买彩票，不许走！");
				}else {
					System.out.println("谢谢惠顾！");
					flag = false;
				}
				break;
			default:
				System.out.println("没有这种操作！");
				break;
			}
		}
	}
}
class cp{
	int number;
	cpMan lord;
}
class cpMan{
	String name;
	int money;
	int cpNum;
	Vector<cp> list;
	cpMan(){
		list = new Vector<cp>();
	}
	public void buy(Scanner in,cpCompany Company) {
		System.out.print("请选择您的幸运号码(0-100)：");
		int number = in.nextInt();
		while(Company.visit[number]) {
			System.out.println("这个号码已经被买走了，请选择其它的号码：");
			number = in.nextInt();
		}
		Company.visit[number] = true;
		cp x = new cp();
		x.number = number;
		x.lord = this;
		list.add(x);
		Company.list.add(x);
		cpNum++;
	}
}
class cpCompany{
	int[] result;
	boolean[] visit;
	Vector<cp> list;
	cpCompany(){
		list = new Vector<cp>();
		result = new int[6];
		visit = new boolean[101];
		for(int i = 0;i<visit.length;i++) {
			visit[i] = false;
		}
	}
	public void createResult() {
		for(int i = 0; i<6;i++)
			this.result[i] = (int)(100*Math.random());
	}
}
