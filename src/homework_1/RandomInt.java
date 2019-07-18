package homework_1;

public class RandomInt {
	public static void main(String[] args) {
		int[] x = new int[10];
		for(int i = 0; i < x.length; i++) {
			x[i] = (int)(Math.random()*100);
		}
		qsort(x,0,x.length-1);
		for(int i = 0; i < x.length;i++) {
			System.out.print(x[i]+" ");
		}
		System.out.println();
	}
	public static void qsort(int[] x,int l,int r) {
		if(l>=r) return;
		int i = l, j = r;
		int temp = x[l];
		while(i<j) {
			while(i<j && x[j] >= temp)j--;
			if(i<j)x[i++] = x[j];
			while(i<j && x[i] <= temp)i++;
			if(i<j)x[j--] = x[i];
		}
		x[i] = temp;
		qsort(x,l,i-1);
		qsort(x,i+1,r);
	}
}
