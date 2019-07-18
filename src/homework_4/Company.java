package homework_4;

import java.io.Serializable;
import java.util.*;

class Company implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vector<Employee> v = new Vector<>();
	private Vector<DakaInfo> d = new Vector<>();
	public void add(Employee emp) {
		v.add(emp);
		d.add(new DakaInfo(emp));
		System.out.println("员工"+emp.getName()+"的信息添加成功！");
	}
	public void remove(Employee emp) {
		int index = findEMP(emp);
		if(index != -1) {
			System.out.println("员工"+v.get(index).getName()+"已被移除！");
			v.remove(index);
		}else {
			empNotFound();
		}
	}
	public void findEmployeeByID(int ID) {
		Employee temp = IDFind(ID);
		if(temp != null) {
			printInfor(temp);
		}else
			empNotFound();
	}
	public void findEmployeeByName(String name) {
		Employee temp = NameFind(name);
		if(temp != null) {
			printInfor(temp);
		}else
			empNotFound();
	}
	public void getAllInfor() {
		Employee emp;
		for(int i = 0; i < v.size();i++) {
			emp = v.get(i);
			printInfor(emp);
			emp.printDakaInfo();
		}
		System.out.println("已获取所有员工的信息！");
	}
	public void clockIn(Employee emp) {
		int index = findEMP(emp);
		if(index != -1) {
			d.get(index).clockIn();
		}else {
			empNotFound();
		}
	}
	public void clockOut(Employee emp) {
		int index = findEMP(emp);
		if(index != -1) {
			d.get(index).clockOut();
		}else {
			empNotFound();
		}
	}
	private void empNotFound() {
		System.err.println("该员工不存在！");
	}
	private void printInfor(Employee emp) {
		System.out.println();
		System.out.println("以下为员工"+emp.getName()+"的个人信息");
		System.out.println(emp.toString());
	}
	public Employee NameFind(String name) {
		int cnt = 0;
		Employee temp = null;
		for(int i = 0; i < v.size(); i++) {
			if(name.equals(v.get(i).getName())) {
				cnt++;
				temp = v.get(i);
			}
		}
		if(cnt == 1)
			return temp;
		else if(cnt == 0)
			return null;
		else {
			System.out.println("本公司存在多个姓名为" + name + "的员工，请使用ID查找！");
			System.out.print("请输入该员工的ID：");
			int ID = Main.in.nextInt();
			return IDFind(ID);
		}
	}
	public Employee IDFind(int ID) {
		for(int i = 0; i < v.size(); i++) {
			if(ID == v.get(i).getID()) {
				return v.get(i);
			}
		}
		return null;
	}
	public int findEMP(Employee emp) {
		for(int i = 0; i < v.size(); i++) {
			if(emp == v.get(i)) {
				return i;
			}
		}
		return -1;
	}
}
