package practice;

import java.io.Serializable;

class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1721181373930393309L;
	String name;
	int age;
	transient String password;
	//String password;
    // double money;
	double money;

	Customer(String name, int age, String password, double money) {
		this.name = name;
		this.age = age;
		this.password = password;
		this.money = money;
	}

	public String toString() {
		return "name=" + name + " age=" + age + " password=" + password
				+ " money=" + money;

	}

}

