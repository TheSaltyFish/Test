package homework_5;

public class H3 {
	public static void main(String[] args) {
		Thread t1 = new T("线程1");
		Thread t2 = new T("线程2");
		t1.setPriority(10);
		t2.setPriority(6);
		
		t1.start();
		t2.start();
	}
}
class T extends Thread{
	String name;
	T(String name){
		this.name = name;
	}
	public void run() {
		for(int i = 0; i < 200; i++) {
			System.out.println(name+"正在运行");
		}
	}
}
