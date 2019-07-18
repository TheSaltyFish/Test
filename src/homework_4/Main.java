package homework_4;

import java.io.*;
import java.util.*;

public class Main {
	private static boolean[] IdUsed = new boolean[100000];
	public static Scanner in = new Scanner(System.in);
	public static Company company = new Company();
	public static void main(String[] args) {
		File f = new File("C:/Users/27378/Desktop/Message.txt");
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("首次使用，请设置所有成员信息！");
			System.out.println("下面开始添加员工！");
			addEmployee();
		}
		try {
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			company = (Company) ois.readObject();
			ois.close();
			fis.close();
		}catch(IOException e) {
			System.out.println("文件读取出现异常！");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("找不到对象！");
			e.printStackTrace();
		}finally {
			System.out.println("员工信息文件读取成功！");
		}
		EmployeeClockSystem();
	}
	public static void EmployeeClockSystem() {
		System.out.println("----员工打卡系统----");
		while(true) {
			System.out.println("输入 0--------退出");
			System.out.println("输入 1--------签到");
			System.out.println("输入 2--------签退");
			System.out.println("输入 3--------查看签到信息");
			int log = in.nextInt();
			switch(log) {
			case 0:
				try {
					save();
				}catch(Exception e) {
					System.out.println("修改保存失败！");
				}
				System.err.println("系统退出成功！");
				return;
			case 1:
				clockIn();
				break;
			case 2:
				clockOut();
				break;
			case 3:
				company.getAllInfor();
				break;
			}
		}
	}
	public static void clockIn() {
		System.out.print("请输入签到员工的姓名：");
		String name = in.next();
		Employee emp = company.NameFind(name);
		company.clockIn(emp);
	}
	public static void clockOut() {
		System.out.print("请输入签退员工的姓名：");
		String name = in.next();
		Employee emp = company.NameFind(name);
		company.clockOut(emp);
	}
	public static void addEmployee() {
		System.out.println("请输入要添加员工的数量：");
		int number = in.nextInt();
		for(int i = 0; i < number; i++) {
			String name;
			int ID;
			System.out.print("请输入第"+(i+1)+"个员工的姓名：");
			name = in.next();
			System.out.print("请输入第"+(i+1)+"个员工的ID:");
			do{
				ID = in.nextInt();
				}while(conflict(ID));
			IdUsed[ID] = true;
			company.add(new Employee(ID,name));
		}
		try {
			save();
			System.out.println("信息保存成功！");
		}catch(Exception e) {
			System.out.println("信息保存时出现异常！");
		}
	}
	public static void save() throws Exception {
		FileOutputStream fos = new FileOutputStream("C:/Users/27378/Desktop/Message.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(company);
		oos.flush();
		oos.close();
		fos.close();
	}
	private static boolean conflict(Integer ID) {
		if(IdUsed[ID] == true){
			System.out.println("该ID已经被使用，请重新输入ID！");
			return true;
		}
		return false;
	}
}
