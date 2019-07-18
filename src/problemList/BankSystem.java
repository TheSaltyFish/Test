package problemList;
import java.util.*;
public class BankSystem {
	public static void printAllAccount(Vector<Cust> v) {
		for(int i = 0;i<v.size();i++) {
			System.out.print(v.get(i).name+"��ID:"+v.get(i).ID+" ");
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
			pt("�������¼��ݣ�\n1.����Ա\n2.�û�\n0.�˳�\n");
			pt("*****************");
			int login = in.nextInt();
			
			int account;
			switch(login) {
			case 0:
				flag = false;
				break;
			case 1:
				pt("���������Ա�˺ţ�");
				account = in.nextInt();
				if(account==GM.ID) {
					pt("���������Ա���룺");
					String password = in.next();
					if(password.equals(GM.password)) {
						GMlogin(GM,v,in);
					}else {
						pt("�������");
					}
				}else
					pt("���˺Ų�����");
				break;
			case 2:
				printAllAccount(v);
				pt("�������û��˺ţ�");
				account = in.nextInt();
				int index = check(v,account);
				if(index != -1) {
					if(v.get(index).usable == false) {
						System.out.println("�㱻����Ա����ˣ�");
					}else {
						pt("���������룺");
						String password = in.next();
						if(password.equals(v.get(index).password)) {
							Cust c = v.get(index);
							AClogin(v,c,in);
						}else {
							pt("�������,�������������룡");
							int cnt = 0;
							do {
								cnt++;
								password = in.next();
								if(cnt>=3)
									break;
							}while(!password.equals(v.get(index).password));
							if(cnt>=3) {
								v.get(index).usable = false;
								pt("������󳬹����Σ�����˺��ѱ����ᣡ");
							}else {
								Cust c = v.get(index);
								AClogin(v,c,in);
							}
						}
					}
				}else {
					pt("���û������ڣ�");
				}
				break;
			default:
				pt("�ò���������");
			}
		}
		
		pt("�˳��ɹ���");
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
		pt("��ӭ��¼��");
		pt("��ѡ����Ҫ�Ĳ�����");
		boolean flag = true;
		while(flag) {
			pt("1.��ѯ���");
			pt("2.��Ǯ");
			pt("3.ȡǮ");
			pt("4.ת��");
			pt("5.�޸�����");
			pt("0.�˳���¼");
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
				pt("�ò��������ڣ�");
			}
			if(!c.usable)
				return;
		}
	}
	public static void GMlogin(monitor GM,Vector<Cust> v,Scanner in) {
		pt("��ӭ����Ա���˵�¼��");
		boolean flag = true;
		while(flag) {
			pt("��ѡ����������");
			pt("1.����¿ͻ�");
			pt("2.���������ų��û�˳��");
			pt("3.����洢�ܽ��");
			pt("4.�˻�����");
			pt("5.Э�������û�����");
			pt("0.�˳���¼");
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
				System.out.println("�ò��������ڣ�");
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
		p("������������֣�");
		name = i.next();
		p("��������ĳ�ʼ���룺");
		password = i.next();
		int ID = (int)(Math.random()*1000000);
		this.ID  = ID;
		p("���������µ��˺�ID�����Ժ�");
		for(int j = 0; j<3; j++) {
			try {
				Thread.sleep(100);
				System.out.print("��");
			}catch(Exception e) {
				System.out.println("���г���");
			}
		}
		pt("");
		pt("���˺�IDΪ��"+ID);
		this.money = money;
		pt("ϵͳ����"+money+"Ԫ��ʼ��");
	}
	private static void pt(String x) {
		System.out.println(x);
	}
	private static void p(String x) {
		System.out.print(x);
	}
	public void deposit() {
		p("�������Ǯ��");
		int m = i.nextInt();
		if(m>0) {
			money += m;
			pt("��Ǯ�ɹ���");
		}else {
			pt("���Ǯ����˱��٣���ȷ��Ҫ���븺���Ľ���𣿣�����1ȷ��������2ȡ����");
			int flag = i.nextInt();
			if(flag==1){
				money += m;
				pt("����˻�����"+m+"Ԫ��ʧ��");
			}else
				pt("���ѡ������ǣ��ֶ���������");
		}
	}
	public void draw() {
		p("������ȡ����");
		int m = i.nextInt();
		if(money-m<0) {
			System.out.println("ȡǮʧ�ܣ���ֻ��"+money+"ԪǮ��");
			return;
		}
		if(m>=100000) {
			System.out.print("�漰���������������������֤�������㱾�˵Ĳ�����");
			if(!name.equals(new Scanner(System.in).next())) {
				System.out.println("��֤ʧ�ܣ�����ȡ����");
				return;
			}
		}
		money-=m;
		System.out.println("��ȡ����"+m+"Ԫ�����Ϊ��"+money+"Ԫ��");
	}
	public void printInfor() {
		pt(name+"����,����˻����Ϊ��"+money+"Ԫ��");
	}
	public void resetPasswrod() {
		p("���������������֤�������㱾�˵Ĳ�����");
		String name = i.next();
		if(name.equals(this.name)) {
			pt("�����֤�ɹ���");
			pt("��������ľ����롣");
			String password = i.next();
			int time = 3;
			if(password.equals(this.password)) {
				p("��������������룺");
				password = i.next();
				this.password = password;
				pt("�������óɹ���");
			}else do{
				time--;
				if(time==0)
					break;
				pt("����������������룡");
				System.out.println("�㻹��"+time+"�λ��ᡣ");
				password = i.next();
			}while(!password.equals(this.password));
			if(time == 0) {
				pt("����Ϊ�������������ţ�");
				this.usable = false;
			}
		}else {
			pt("�����֤ʧ�ܣ�");
		}
	}
	public void transfer(Vector<Cust> v) {
		for(int j = 0;j<v.size();j++) {
			p(v.get(j).name+"ID��"+v.get(j).ID+" ");
		}
		pt("");
		p("����ת�˶����ID:");
		int ID = i.nextInt();
		if(ID == this.ID) {
			pt("�㲻��ת�˸��Լ���");
		}else if(BankSystem.check(v,ID) != -1) {
			int flag = BankSystem.check(v,ID);
			if(v.get(flag).usable) {
				p("������ת�˽��:");
				double money = i.nextDouble();
				if(money<=this.money && money>0) {
					this.money -= money;
					v.get(flag).money += money;
					pt("ת�˳ɹ����˻����Ϊ"+this.money+"Ԫ��");
				}else if(money > 0){
					pt("���㣬ת��ʧ�ܣ�");
				}else if(money == 0) {
					pt("�㲻��ת��0Ԫ��");
				}else {
					pt("���������");
				}
			}else {
				pt("���˺��ѱ����÷�ţ�ת��ʧ�ܣ�");
			}
		}else {
			pt("���˻������ڣ�");
		}
	}
}
class VIPCust extends Cust{
	VIPCust(int money){
		super(money);
	}
	public void draw() {
		System.out.println("������ȡ����");
		int m = i.nextInt();
		if(money-m<-1000) {
			System.out.println("ȡǮʧ�ܣ���ֻ��"+money+"ԪǮ��");
			return;
		}
		if(m>=100000) {
			System.out.print("�漰���������������������֤�������㱾�˵Ĳ�����");
			if(!name.equals(new Scanner(System.in).next())) {
				System.out.println("��֤ʧ�ܣ�����ȡ����");
				return;
			}
		}
		money-=m;
		System.out.println("��ȡ����"+m+"Ԫ�����Ϊ��"+money+"Ԫ��");
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
		System.out.println("�Ƿ񴴽�VIP�˺ţ�(1:��/0:��)");
		int vip = sc.nextInt();
		if(vip==0)
			v.add(new Cust(200));
		else
			v.add(new VIPCust(200));
		System.out.println("���˺Ŵ����ɹ���");
	}
	public void sort(Vector<Cust> v) {
		if(v.size() == 0) {
			System.out.println("��ǰ�������κ��û���");
			return;
		}
		Comparator<Cust> cmp = new CustComparator();
		Collections.sort(v,cmp);
		System.out.println("����ɹ���");
		System.out.println("���水�������г��û���˳��");
		for(int i = 0;i<v.size();i++) {
			System.out.println(v.get(i).name+"��"+v.get(i).money+"Ԫ");
		}
	}
	public void countMoney(Vector<Cust> v) {
		if(v.size() == 0) {
			System.out.println("��ǰ�������κ��û���");
			return ;
		}
		double money = 0;
		for(int i = 0; i<v.size(); i++) {
			money += v.get(i).money;
		}
		System.out.println("�����ܹ�����"+money+"ԪǮ��");
	}
	public void freeze(Vector<Cust> v) {
		if(v.size() == 0) {
			System.out.println("��ǰ�������κ��û���");
			return;
		}
		printAllAccount(v);
		System.out.println("��������Ҫ��ɱ���˺ţ�");
		int account = sc.nextInt();
		int index = BankSystem.check(v,account);
		if(index != -1) {
			v.get(index).usable = false;
			System.out.println("IDΪ:"+v.get(index).ID+"���˺��Ѷ��ᣡ");
		}else {
			System.out.println("���˺Ų����ڣ�");
		}
	}
	public void resetPassword(Vector<Cust> v) {
		if(v.size() == 0) {
			System.out.println("��ǰ�������κ��û���");
			return;
		}
		printAllAccount(v);
		System.out.println("����Ҫ����������˺ţ�");
		int account = sc.nextInt();
		int index = BankSystem.check(v, account);
		if(index != -1) {
			System.out.println("�������µ�����");
			String password = sc.next();
			v.get(index).password = password;
			System.out.println("�������óɹ���");
		}else {
			System.out.println("���˺Ų����ڣ�");
		}
	}
	public static void printAllAccount(Vector<Cust> v) {
		for(int i = 0;i<v.size();i++) {
			System.out.print(v.get(i).name+"��ID:"+v.get(i).ID+" ");
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