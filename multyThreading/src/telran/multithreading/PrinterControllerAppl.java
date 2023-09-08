package telran.multithreading;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
/*
public class PrinterControllerAppl {

	public static void main(String[] args) throws InterruptedException {
		Printer printer1 = new Printer('#', 100);
		Printer printer2 = new Printer('*', 100);
		Instant start = Instant.now();
		printer1.start();
		printer2.start();
		printer1.join();
		printer2.join();
		
		System.out.printf("running time is %dMs \n",
				ChronoUnit.MILLIS.between(start, Instant.now()));

	}
	

}
*/
public class PrinterControllerAppl {

	public static void main(String[] args)   {
		//Interview question: how to join itself
		//in the main thread
		//Thread.currentThread().join();
		//Thread.currentThread().interrupt();
		Printer printer = new Printer(".*#$%&");
		Scanner scanner = new Scanner(System.in);
		printer.start();
		while(true) {
			String line = scanner.nextLine();
			if(line.equals("q")) {
				break;
			}
			printer.interrupt();
		}
		printer.stopPrinter();
	}
	}