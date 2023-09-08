package telran.multithreading;

import java.time.format.DateTimeFormatter;

public class TimerControllerAppl {

	public static void main(String[] args) throws InterruptedException {
		//Timer timer = new Timer(DateTimeFormatter.ISO_TIME, 1000);
		//timer.setDaemon(true);
		Timer timer = new Timer();
		timer.start();
		System.out.println("Doing smth un the application with timer");
		Thread.sleep(5000);
		timer.interrupt();
		System.out.println("Doing smth un the application without timer");
		Thread.sleep(10000);
	}

}
