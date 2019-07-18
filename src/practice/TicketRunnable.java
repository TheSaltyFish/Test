package practice;

public class TicketRunnable implements Runnable{
	private int ticket = 50;
	public void run() {
		while(true) {
			if(ticket > 0) {
				System.out.println(Thread.currentThread().getName()+
						" is saling ticket " + ticket);
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				ticket--;
			}else break;
		}
	}
	public int getTickets() {
		return ticket;
	}
}
