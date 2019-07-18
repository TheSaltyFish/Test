package homework_4;

import java.io.Serializable;

class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ID;
	private String name;
	private DakaInfo daka;
	Employee(int ID,String name){
		this.ID = ID;
		this.name = name;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public int getID() {
		return ID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public String toString() {
		return "员工ID为：" + ID + ",员工姓名为：" + name;
	}
	public void setDaka(DakaInfo daka) {
		this.daka = daka;
	}
	public DakaInfo getDaka() {
		return this.daka;
	}
	public void printDakaInfo() {
		daka.printDakaInfo();
	}
}
