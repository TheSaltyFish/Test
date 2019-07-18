package practice;

import java.util.HashSet;
import java.util.Set;

public class Set_Interface {
	public static void main(String[] args) {
		Set<String> s = new HashSet<String>();
		s.add("hello");
		s.add("world");
		s.add("132");
		s.add("123");
		s.add("123");
		s.add("123");
		s.add("123");
		System.out.println(s);
	}
}
