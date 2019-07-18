package practice;

public class ThreadTest implements Runnable{
	Timer timer = new Timer();
	public static void main(String[] args) {
		ThreadTest test = new ThreadTest();
		Thread t1 = new Thread(test);
		Thread t2 = new Thread(test);
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
	}
	public void run() {
		timer.add(Thread.currentThread().getName());
	}
}
//class Timer{
//	private static int num = 0;
//	public synchronized void add(String name) {
//		num++;
//		try {
//			Thread.sleep(1);
//		}catch(InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println("你是第"+num+"个使用Timer的线程");
//	}
//}
class Timer{
	private static int num =  0;
	public void add(String name) {
		num++;
		try {
			Thread.sleep(1);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("你是第"+num+"个使用Timer的线程");
	}
}




class T1 extends Thread{
	private boolean timeout = false;
	public void run() {
		while(!timeout) {
			for(int i = 0;i<20;i++) {
				System.out.println("--t1--:" + i);
			}
		}
	}
	public void stopThread() {
		this.timeout = true;
	}
}
class T2 extends Thread{
	public void run() {
		for(int i = 0;i < 20;i++){
			System.out.println("--t2--:"+i);
		}
	}
}