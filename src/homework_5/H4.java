package homework_5;

import java.text.SimpleDateFormat;
import java.util.*;

public class H4 {
	public static void main(String[] args) {
		new Timer().start();
	}
}
class Timer extends Thread{
	public void run() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		while(true) {
			try {
				System.out.println(sdf.format(new Date()));
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}