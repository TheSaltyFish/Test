package homework_7;

public class H1 {
	public static void main(String[] args) {
		int[] arr = {7,89,2,6,7,3,9,10,20,4,6,3,7,8,9};
		bubblesort(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void bubblesort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				int temp;
				if(arr[i]>arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
