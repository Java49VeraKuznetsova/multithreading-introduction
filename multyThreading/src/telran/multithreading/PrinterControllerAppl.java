/*
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
/*
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
*/
// HW 44 YURI
package telran.multithreading;
import java.lang.Thread.State;

public class PrinterControllerAppl {

	private static final int N_THREADS = 50;
	private static final int N_NUMBERS = 100;
	private static final int N_PARTITIONS = 10;
	
	

	public static void main(String[] args) {
		Printer.setPartitions(N_PARTITIONS);
		Printer.setOverall(N_NUMBERS);
		Printer[] printers=new Printer[N_THREADS];
		creatingPrinters(printers);
		
		printers[0].interrupt();
		
	}

	

	private static void creatingPrinters(Printer[] printers) {
		printers[0]=new Printer(1);
		for(int i=1; i<printers.length; i++){
			printers[i]=new Printer(i+1);
			printers[i-1].setNext(printers[i]);
			printers[i-1].start();
		}
		printers[printers.length-1].setNext(printers[0]);
		printers[printers.length-1].start();
	}

}