package practice;

public class Thread01 extends Thread{
	String name;
	Thread01(String name){
		this.name = name;
	}
	public void run() {
		for(int i = 0; i < 20; i++) {
			System.out.println(name + ":" + i);
		}
	}
}
