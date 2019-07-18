package homework_5;

public class H1 {
	public static boolean[] prime = new boolean[3001];
	public static void sheet(boolean[] prime) {
		for(int i = 3; i < 3001;i += 2) {
			prime[i] = true;
		}
		prime[2] = true;
		for(int i = 3; i*i < 3001; i += 2) {
			for(int j = i; j*i < 3001;j += 2) {
				prime[j*i] = false;
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		sheet(prime);
		Thread t1 = new Thread(()->{
			exe(1,1000);
		});
		Thread t2 = new Thread(()->{
			exe(1001,2000);
		});
		Thread t3 = new Thread(()->{
			exe(2001,3000);
		});
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
		int cnt = 0;
		for(int i = 1; i < 3001; i++){
			if(prime[i])
				cnt++;
		}
		System.out.println("::"+cnt);
	}
	public static void exe(int l,int r){
		for(int i = l;i<=r;i++) {
			if(prime[i])
				System.out.println(i);
		}
	}
}
