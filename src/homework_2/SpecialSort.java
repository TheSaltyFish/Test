package homework_2;

import java.util.*;

public class SpecialSort {
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<>();
		Scanner in = new Scanner(System.in);
		String x;
		System.out.println(" ‰»Î»Ù∏…µ•¥ £∫");
		x = in.nextLine();
		String[] y = x.split(" ");
		for(String s:y) {
			arr.add(s);
		}
		sort(arr);
		System.out.println(arr);
		in.close();
	}
	public static void sort(ArrayList<String> arr) {
		Collections.sort(arr, new cmp1());
	}
}
class cmp1 implements Comparator<String>{
	@Override
	public int compare(String x, String y) {
		String x0 = x.toLowerCase();
		String y0 = y.toLowerCase();
		return x0.compareTo(y0);
	}
}
