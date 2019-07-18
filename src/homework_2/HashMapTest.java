package homework_2;

import java.util.*;

public class HashMapTest {
	private static Scanner scanner;

	public static void main(String[] args) {
		Map<Integer,person> m = new HashMap<>();
		m.put(1,new person("a",55.5));
		m.put(2,new person("b",66.66));
		m.put(3,new person("c",77.7));
		scanner = new Scanner(System.in);
		int index = scanner.nextInt();
		person p = m.get(index);
		System.out.println(index+":Ãû×Ö£º"+p.getName());
		System.out.println(index+":Óà¶î£º"+p.getMoney());
	}
}
class person{
	private String name;
	private double money;
	person(String name,double money){
		this.name = name;
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public double getMoney() {
		return money;
	}
	
}