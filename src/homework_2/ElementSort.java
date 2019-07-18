package homework_2;

import java.util.*;

public class ElementSort {
	public static void main(String[] args) {
		ArrayList<String> l = new ArrayList<>();
		l.add("apple");
		l.add("grape");
		l.add("banana");
		l.add("pear");
		System.out.println("最大的元素为："+findMax(l));
		System.out.println("排序结果为：");
		sort(l);
		for(int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}
	}
	public static String findMax(ArrayList<String> l) {
		String s = l.get(0);
		for(int i = 0; i < l.size(); i++) {
			if(s.compareTo(l.get(i)) < 0) {
				s = l.get(i);
			}
		}
		return s;
	}
	public static void sort(ArrayList<String> l) {
		Collections.sort(l, new cmp());
	}
}
class cmp implements Comparator<String>{
	@Override
	public int compare(String s1, String s2) {
		return s1.compareTo(s2);
	}
}
