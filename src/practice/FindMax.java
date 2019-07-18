package practice;

public class FindMax {
	public static void main(String[] args) {
		int[] x = {4,2,1,7,4,66,3,7,9,5,10,21,44,22,11,88};
//		bubbleSort(x,0,x.length-1);
		insertSort(x,0,0);
		for(int i = 0; i < x.length; i++) {
			System.out.print(x[i]+" ");
		}
		System.out.println();
	}
	public static void insertSort(int[] x,int l,int r) {
		if(r == x.length)return;
		int temp = x[r];
		int i;
		for(i = r; i > 0 && x[i-1] > temp; i--) {
			x[i] = x[i-1];
		}
		x[i] = temp;
		insertSort(x,l,r+1);
	}
	public static void bubbleSort(int[] x,int l, int r) {
		if(l==r) return;
		for(int i = l+1;i <= r;i++) {
			if(x[i] < x[i-1]) {
				int temp = x[i];
				x[i] = x[i-1];
				x[i-1] = temp;
			}
		}
		bubbleSort(x,l,r-1);
	}
	public static int max(int[] x,int l,int r) {
		int temp;
		if(l==r)return x[l];
		if(x[l] > (temp = max(x,l+1,r))) {
			return x[l];
		}else {
			return temp;
		}
	}
}
