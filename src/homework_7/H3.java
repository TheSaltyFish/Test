package homework_7;

public class H3 {
	public static void main(String[] args) {
		int[] arr = {1,5,6,8,9,11,50,55,97,100};
		int index = bsearch(arr,0,arr.length-1,6);
		System.out.println(index);
	}
	public static int bsearch(int[] arr,int l,int r,int key) {
		if(l>r)return -1;
		int i = l,j = r;
		int mid = (i+j)>>1;
		if(arr[mid] == key)return mid;
		else if(arr[mid] > key)return bsearch(arr,l,mid-1,key);
		else return bsearch(arr,mid+1,r,key);
	}
}
