package problemList;
import java.util.*;
public class BankSystem {
	public static void printAllAccount(Vector<Cust> v) {
		for(int i = 0;i<v.size();i++) {
			System.out.print(v.get(i).name+"的ID:"+v.get(i).ID+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		monitor GM = new monitor(10086,"2018");
		Vector<Cust> v = new Vector<Cust>();
		boolean flag = true;
		while(flag) {
			pt("*****************");
			pt("请输入登录身份：\n1.管理员\n2.用户\n0.退出\n");
			pt("*****************");
			int login = in.nextInt();
			
			int account;
			switch(login) {
			case 0:
				flag = false;
				break;
			case 1:
				pt("请输入管理员账号：");
				account = in.nextInt();
				if(account==GM.ID) {
					pt("请输入管理员密码：");
					String password = in.next();
					if(password.equals(GM.password)) {
						GMlogin(GM,v,in);
					}else {
						pt("密码错误！");
					}
				}else
					pt("该账号不存在");
				break;
			case 2:
				printAllAccount(v);
				pt("请输入用户账号：");
				account = in.nextInt();
				int index = check(v,account);
				if(index != -1) {
					if(v.get(index).usable == false) {
						System.out.println("你被管理员封号了！");
					}else {
						pt("请输入密码：");
						String password = in.next();
						if(password.equals(v.get(index).password)) {
							Cust c = v.get(index);
							AClogin(v,c,in);
						}else {
							pt("密码错误,请重新输入密码！");
							int cnt = 0;
							do {
								cnt++;
								password = in.next();
								if(cnt>=3)
									break;
							}while(!password.equals(v.get(index).password));
							if(cnt>=3) {
								v.get(index).usable = false;
								pt("密码错误超过三次，你的账号已被冻结！");
							}else {
								Cust c = v.get(index);
								AClogin(v,c,in);
							}
						}
					}
				}else {
					pt("该用户不存在！");
				}
				break;
			default:
				pt("该操作不存在");
			}
		}
		
		pt("退出成功！");
		in.close();
		return;
	}
	public static int check(Vector<Cust> v,int ID) {
		for(int i=0; i<v.size(); i++) {
			if(ID == v.get(i).ID)
				return i;
		}
		return -1;
	}
	public static void pt(String x) {
		System.out.println(x);
	}
	public static void p(String x) {
		System.out.print(x);
	}
	public static void AClogin(Vector<Cust> v,Cust c,Scanner in) {
		pt("欢迎登录！");
		pt("请选择需要的操作：");
		boolean flag = true;
		while(flag) {
			pt("1.查询余额");
			pt("2.存钱");
			pt("3.取钱");
			pt("4.转账");
			pt("5.修改密码");
			pt("0.退出登录");
			int login = in.nextInt();
			switch(login) {
			case 1:
				c.printInfor();
				break;
			case 2:
				c.deposit();
				break;
			case 3:
				c.draw();
				break;
			case 4:
				c.transfer(v);
				break;
			case 5:
				c.resetPasswrod();
				break;
			case 0:
				flag = false;
				break;
			default:
				pt("该操作不存在！");
			}
			if(!c.usable)
				return;
		}
	}
	public static void GMlogin(monitor GM,Vector<Cust> v,Scanner in) {
		pt("欢迎管理员大人登录！");
		boolean flag = true;
		while(flag) {
			pt("请选择管理操作：");
			pt("1.添加新客户");
			pt("2.按存款金额降序排出用户顺序");
			pt("3.计算存储总金额");
			pt("4.账户冻结");
			pt("5.协助重置用户密码");
			pt("0.退出登录");
			int login = in.nextInt();
			switch(login) {
			case 1:
				GM.addaccount(v);
				break;
			case 2:
				GM.sort(v);
				break;
			case 3:
				GM.countMoney(v);
				break;
			case 4:
				GM.freeze(v);
				break;
			case 5:
				GM.resetPassword(v);
				break;
			case 0:
				flag = false;
				break;
			default:
				System.out.println("该操作不存在！");
				break;
			}
		}
	}
}
class Cust{
	String name;
	int ID;
	double money;
	String password;
	boolean usable;
	Scanner i;
	Cust(double money){
		usable = true;
		i = new Scanner(System.in);
		p("请输入你的名字：");
		name = i.next();
		p("请设置你的初始密码：");
		password = i.next();
		int ID = (int)(Math.random()*1000000);
		this.ID  = ID;
		p("正在生成新的账号ID，请稍候");
		for(int j = 0; j<3; j++) {
			try {
				Thread.sleep(100);
				System.out.print("。");
			}catch(Exception e) {
				System.out.println("运行出错！");
			}
		}
		pt("");
		pt("新账号ID为："+ID);
		this.money = money;
		pt("系统赠送"+money+"元初始存款！");
	}
	private static void pt(String x) {
		System.out.println(x);
	}
	private static void p(String x) {
		System.out.print(x);
	}
	public void deposit() {
		p("请输入存钱金额：");
		int m = i.nextInt();
		if(m>0) {
			money += m;
			pt("存钱成功。");
		}else {
			pt("你的钱会因此变少，你确定要存入负数的金额吗？（输入1确定，输入2取消）");
			int flag = i.nextInt();
			if(flag==1){
				money += m;
				pt("你的账户中有"+m+"元消失了");
			}else
				pt("你的选择很明智（手动滑稽）。");
		}
	}
	public void draw() {
		p("请输入取出金额：");
		int m = i.nextInt();
		if(money-m<0) {
			System.out.println("取钱失败，你只有"+money+"元钱！");
			return;
		}
		if(m>=100000) {
			System.out.print("涉及金额过大，请输入你的姓名来证明这是你本人的操作：");
			if(!name.equals(new Scanner(System.in).next())) {
				System.out.println("认证失败，交易取消！");
				return;
			}
		}
		money-=m;
		System.out.println("你取出了"+m+"元，余额为："+money+"元。");
	}
	public void printInfor() {
		pt(name+"先生,你的账户余额为："+money+"元。");
	}
	public void resetPasswrod() {
		p("请输入你的姓名来证明这是你本人的操作：");
		String name = i.next();
		if(name.equals(this.name)) {
			pt("身份验证成功！");
			pt("请输入你的旧密码。");
			String password = i.next();
			int time = 3;
			if(password.equals(this.password)) {
				p("请输入你的新密码：");
				password = i.next();
				this.password = password;
				pt("密码重置成功！");
			}else do{
				time--;
				if(time==0)
					break;
				pt("密码错误，请重新输入！");
				System.out.println("你还有"+time+"次机会。");
				password = i.next();
			}while(!password.equals(this.password));
			if(time == 0) {
				pt("你因为多次作死而被封号！");
				this.usable = false;
			}
		}else {
			pt("身份验证失败！");
		}
	}
	public void transfer(Vector<Cust> v) {
		for(int j = 0;j<v.size();j++) {
			p(v.get(j).name+"ID："+v.get(j).ID+" ");
		}
		pt("");
		p("输入转账对象的ID:");
		int ID = i.nextInt();
		if(ID == this.ID) {
			pt("你不能转账给自己！");
		}else if(BankSystem.check(v,ID) != -1) {
			int flag = BankSystem.check(v,ID);
			if(v.get(flag).usable) {
				p("请输入转账金额:");
				double money = i.nextDouble();
				if(money<=this.money && money>0) {
					this.money -= money;
					v.get(flag).money += money;
					pt("转账成功，账户余额为"+this.money+"元。");
				}else if(money > 0){
					pt("余额不足，转账失败！");
				}else if(money == 0) {
					pt("你不能转入0元！");
				}else {
					pt("你想得美！");
				}
			}else {
				pt("该账号已被永久封号，转账失败！");
			}
		}else {
			pt("该账户不存在！");
		}
	}
}
class VIPCust extends Cust{
	VIPCust(int money){
		super(money);
	}
	public void draw() {
		System.out.println("请输入取出金额：");
		int m = i.nextInt();
		if(money-m<-1000) {
			System.out.println("取钱失败，你只有"+money+"元钱！");
			return;
		}
		if(m>=100000) {
			System.out.print("涉及金额过大，请输入你的姓名来证明这是你本人的操作：");
			if(!name.equals(new Scanner(System.in).next())) {
				System.out.println("认证失败，交易取消！");
				return;
			}
		}
		money-=m;
		System.out.println("你取出了"+m+"元，余额为："+money+"元。");
	}
}
class monitor{
	int ID;
	Scanner sc;
	String password;
	monitor(int ID,String password){
		this.ID = ID;
		this.password = password;
		sc = new Scanner(System.in);
	}
	public void addaccount(Vector<Cust> v) {
		System.out.println("是否创建VIP账号？(1:是/0:否)");
		int vip = sc.nextInt();
		if(vip==0)
			v.add(new Cust(200));
		else
			v.add(new VIPCust(200));
		System.out.println("新账号创建成功！");
	}
	public void sort(Vector<Cust> v) {
		if(v.size() == 0) {
			System.out.println("当前不存在任何用户！");
			return;
		}
		Comparator<Cust> cmp = new CustComparator();
		Collections.sort(v,cmp);
		System.out.println("排序成功！");
		System.out.println("下面按存款金额降序列出用户的顺序。");
		for(int i = 0;i<v.size();i++) {
			System.out.println(v.get(i).name+"有"+v.get(i).money+"元");
		}
	}
	public void countMoney(Vector<Cust> v) {
		if(v.size() == 0) {
			System.out.println("当前不存在任何用户！");
			return ;
		}
		double money = 0;
		for(int i = 0; i<v.size(); i++) {
			money += v.get(i).money;
		}
		System.out.println("银行总共存有"+money+"元钱。");
	}
	public void freeze(Vector<Cust> v) {
		if(v.size() == 0) {
			System.out.println("当前不存在任何用户！");
			return;
		}
		printAllAccount(v);
		System.out.println("请输入你要封杀的账号：");
		int account = sc.nextInt();
		int index = BankSystem.check(v,account);
		if(index != -1) {
			v.get(index).usable = false;
			System.out.println("ID为:"+v.get(index).ID+"的账号已冻结！");
		}else {
			System.out.println("该账号不存在！");
		}
	}
	public void resetPassword(Vector<Cust> v) {
		if(v.size() == 0) {
			System.out.println("当前不存在任何用户！");
			return;
		}
		printAllAccount(v);
		System.out.println("请需要更改密码的账号：");
		int account = sc.nextInt();
		int index = BankSystem.check(v, account);
		if(index != -1) {
			System.out.println("请输入新的密码");
			String password = sc.next();
			v.get(index).password = password;
			System.out.println("密码重置成功！");
		}else {
			System.out.println("该账号不存在！");
		}
	}
	public static void printAllAccount(Vector<Cust> v) {
		for(int i = 0;i<v.size();i++) {
			System.out.print(v.get(i).name+"的ID:"+v.get(i).ID+" ");
		}
		System.out.println();
	}
}
class CustComparator implements Comparator<Cust>{
	public int compare(Cust a,Cust b) {
		if(a.money < b.money)return 1;
		else if(a.money == b.money)return 0;
		else return -1;
	}
}