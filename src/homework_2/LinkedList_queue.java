package homework_2;

import java.util.*;

public class LinkedList_queue {
	public static void main(String[] args) {
		link<Object> li = new link<>();
		li.put(1);
		li.put("aaa");
		li.put(1.5);
		while(!li.isEmpty()) {
			System.out.println(li.get());
		}
	}
}
@SuppressWarnings("hiding")
class link<Object> extends LinkedList<Object>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void put(Object o) {
		this.add(o);
	}
	public Object get() {
		Object o = this.get(0);
		this.remove(0);
		return o;
	}
}
