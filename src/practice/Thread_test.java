package practice;

public class Thread_test {
	public static void main(String[] args) {
		Object x = new Object();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (x) {
					for(int i = 1;i <= 100;i+=2) {
						x.notify();
						System.out.println("t1:"+i);
						try {
							x.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (x) {
					for(int i = 2;i <= 100;i+=2) {
						x.notify();
						System.out.println("t2:"+i);
						try {
							x.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		t1.start();
		t2.start();
	}
}
