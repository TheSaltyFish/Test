package practice;

import java.util.*;

public class Iterator_Interface {
	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<>();
		for(int i = 1; i < 6; i++) {
			set.add(new Integer(i));
		}
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
			//it.remove();
		}
		for(Object x:set) {
			System.out.print(x+" ");
		}
		System.out.println();
		set.forEach(e->System.out.println(e));
		System.out.println(set);
	}
}
