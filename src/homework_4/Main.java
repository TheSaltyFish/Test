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
			System.out.println("�״�ʹ�ã����������г�Ա��Ϣ��");
			System.out.println("���濪ʼ���Ա����");
			addEmployee();
		}
		try {
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			company = (Company) ois.readObject();
			ois.close();
			fis.close();
		}catch(IOException e) {
			System.out.println("�ļ���ȡ�����쳣��");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("�Ҳ�������");
			e.printStackTrace();
		}finally {
			System.out.println("Ա����Ϣ�ļ���ȡ�ɹ���");
		}
		EmployeeClockSystem();
	}
	public static void EmployeeClockSystem() {
		System.out.println("----Ա����ϵͳ----");
		while(true) {
			System.out.println("���� 0--------�˳�");
			System.out.println("���� 1--------ǩ��");
			System.out.println("���� 2--------ǩ��");
			System.out.println("���� 3--------�鿴ǩ����Ϣ");
			int log = in.nextInt();
			switch(log) {
			case 0:
				try {
					save();
				}catch(Exception e) {
					System.out.println("�޸ı���ʧ�ܣ�");
				}
				System.err.println("ϵͳ�˳��ɹ���");
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
		System.out.print("������ǩ��Ա����������");
		String name = in.next();
		Employee emp = company.NameFind(name);
		company.clockIn(emp);
	}
	public static void clockOut() {
		System.out.print("������ǩ��Ա����������");
		String name = in.next();
		Employee emp = company.NameFind(name);
		company.clockOut(emp);
	}
	public static void addEmployee() {
		System.out.println("������Ҫ���Ա����������");
		int number = in.nextInt();
		for(int i = 0; i < number; i++) {
			String name;
			int ID;
			System.out.print("�������"+(i+1)+"��Ա����������");
			name = in.next();
			System.out.print("�������"+(i+1)+"��Ա����ID:");
			do{
				ID = in.nextInt();
				}while(conflict(ID));
			IdUsed[ID] = true;
			company.add(new Employee(ID,name));
		}
		try {
			save();
			System.out.println("��Ϣ����ɹ���");
		}catch(Exception e) {
			System.out.println("��Ϣ����ʱ�����쳣��");
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
			System.out.println("��ID�Ѿ���ʹ�ã�����������ID��");
			return true;
		}
		return false;
	}
}
