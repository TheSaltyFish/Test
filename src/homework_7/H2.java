package homework_7;

public class H2 {
	public static void main(String[] args) {
		int[] arr = {7,1,2,6,7,3,9,10,20,4,6,3,7,8,9};
		insertSort(arr);
		for(int i = 0;i < arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void insertSort(int[] arr) {
		int temp;
		int i,j;
		for(i = 1; i < arr.length; i++) {
			temp = arr[i];
			for(j = i; j > 0 && arr[j-1] > temp; j--) {
				arr[j] = arr[j-1];
			}
			arr[j] = temp;
		}
	}
}
