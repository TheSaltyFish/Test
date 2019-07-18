package homework_5;

public class H2 {
	public static boolean[] prime = new boolean[3001];
	public static void main(String[] args) {
		H1.sheet(prime);
		new Thread(new exe(1,1000)).start();
		new Thread(new exe(1001,2000)).start();
		new Thread(new exe(2001,3000)).start();
	}
}

class exe implements Runnable{
	int l,r;
	exe(int l,int r){
		this.l = l;
		this.r = r;
	}
	@Override
	public void run() {
		for(int i = l;i<=r;i++) {
			if(H2.prime[i])
				System.out.println(i);
		}
	}
}