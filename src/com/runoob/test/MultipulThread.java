package com.runoob.test;
public class MultipulThread {
	public static void main(String[] args) {
		new Thread(()->{
			System.out.println("Thread-1 start.");
			for(int i = 0;i<4;i++) {
				try{
					System.out.println("Thread-1:"+i);
					Thread.sleep(50);
				}catch(InterruptedException e) {
					System.out.println("Thread-1 is interrupted.");
				}
			}
			System.out.println("Thread-1 exiting.");
		}).start();
		new Thread(()->{
			System.out.println("Thread-2 start.");
			for(int i = 0;i<4;i++) {
				try{
					System.out.println("Thread-2:"+i);
					Thread.sleep(50);
				}catch(InterruptedException e) {
					System.out.println("Thread-2 is interrupted.");
				}
			}
			System.out.println("Thread-2 exiting.");
		}).start();
	}
}