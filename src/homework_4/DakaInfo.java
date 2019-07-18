package homework_4;

import java.io.*;
import java.text.*;
import java.util.*;

class DakaInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date clockIn = null;
	private Date clockOut = null;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��  HH:mm:ss");
	private String name;
	private int ID;
	
	public DakaInfo(Employee emp){
		name = emp.getName();
		ID = emp.getID();
		emp.setDaka(this);
	}
	public void clockIn() {
		File f = new File("D:/io/checkin.txt");
		try {
			FileWriter fw = new FileWriter(f,true);
			BufferedWriter bos = new BufferedWriter(fw);
			if(clockIn != null && clockOut == null) {
				System.out.println("����ǩ����������ǩ�ˣ�");
				fw.close();
				bos.close();
				return;
			}
			clockIn = new Date();
			System.out.println("ǩ���ɹ���ǩ��ʱ��Ϊ��" + sdf.format(clockIn));
			bos.append("������" +name+ ",ID:" +ID+"ǩ��ʱ�䣺"+ sdf.format(clockIn) + "\r\n");
			bos.flush();
			bos.close();
			fw.close();
			clockOut = null;
		}catch(IOException e) {
			System.out.println("IOException!");
		}
	}
	public void clockOut() {
		File f = new File("D:/io/checkin.txt");
		try {
			FileWriter fw = new FileWriter(f,true);
			BufferedWriter bos = new BufferedWriter(fw);
			if(clockIn == null) {
				System.err.println("ǩ��ʧ�ܣ��㲻������ǩ��֮ǰǩ�ˣ�");
				bos.close();
				fw.close();
				return;
			}else if(clockOut != null) {
				System.out.println("ǩ��ʧ�ܣ������ظ�ǩ�ˣ�");
				bos.close();
				fw.close();
				return;
			}
			clockOut = new Date();
			System.out.println("ǩ�˳ɹ���ǩ��ʱ��Ϊ��" + sdf.format(clockOut));
			bos.append("������" +name+ ",ID:" +ID+"ǩ��ʱ�䣺"+ sdf.format(clockOut) + "\r\n");
			bos.flush();
			bos.close();
			fw.close();
		}catch(IOException e) {
			System.out.println("IOException!");
		}
	}
	public String getName() {
		return name;
	}
	public int getID() {
		return ID;
	}
	public void printDakaInfo() {
		System.out.print("Ա��ǩ�����Ϊ��");
		if(clockIn != null) {
			System.out.println(sdf.format(clockIn)+" ---ǩ��");
		}else {
			System.out.println("δǩ��!");
		}
		System.out.print("Ա��ǩ�����Ϊ��");
		if(clockOut != null) {
			System.out.println(sdf.format(clockOut)+" ---ǩ��");
		}else {
			System.out.println("δǩ�ˣ�");
		}
	}
}
