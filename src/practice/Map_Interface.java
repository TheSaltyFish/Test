package practice;

import java.util.*;

public class Map_Interface {
	public static void main(String[] args) {
		Map<String,Integer> m1 = new HashMap<>();
		Map<String,Integer> m2 = new TreeMap<>();
		m1.put("one",1);
		m1.put("two",2);
		m1.put("Three",3);
		m2.put("A", 1);
		m2.put("B",2);
		System.out.println(m1.size());
		System.out.println(m1.containsKey("one"));
		System.out.println(m2.containsValue(1));
		if(m1.containsKey("two")) {
			int i = ((Integer)m1.get("two")).intValue();
			System.out.println(i);
		}
		Map<String,Integer> m3 = new HashMap<>(m1);
		m3.putAll(m2);
		System.out.println(m3);
	}
}
