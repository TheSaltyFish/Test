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
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
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
				System.out.println("您已签到过，请先签退！");
				fw.close();
				bos.close();
				return;
			}
			clockIn = new Date();
			System.out.println("签到成功！签到时间为：" + sdf.format(clockIn));
			bos.append("姓名：" +name+ ",ID:" +ID+"签到时间："+ sdf.format(clockIn) + "\r\n");
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
				System.err.println("签退失败！你不可以在签到之前签退！");
				bos.close();
				fw.close();
				return;
			}else if(clockOut != null) {
				System.out.println("签退失败，不能重复签退！");
				bos.close();
				fw.close();
				return;
			}
			clockOut = new Date();
			System.out.println("签退成功！签退时间为：" + sdf.format(clockOut));
			bos.append("姓名：" +name+ ",ID:" +ID+"签退时间："+ sdf.format(clockOut) + "\r\n");
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
		System.out.print("员工签到情况为：");
		if(clockIn != null) {
			System.out.println(sdf.format(clockIn)+" ---签到");
		}else {
			System.out.println("未签到!");
		}
		System.out.print("员工签退情况为：");
		if(clockOut != null) {
			System.out.println(sdf.format(clockOut)+" ---签退");
		}else {
			System.out.println("未签退！");
		}
	}
}
