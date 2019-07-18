package practice;

import java.util.*;

public class List_Interface {
	public static void main(String[] args) {
		List<Object> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add(3);
		list.add(new Float(4.0F));
		list.add("two");
		list.add(new Integer(3));
		System.out.println(list);
		List<Object> li = new LinkedList<Object>();
		for(int i = 0; i<=5; i++) {
			li.add("a"+i);
		}
		System.out.println(li);
		li.add(3,"a100");
		System.out.println(li);
	}
}
