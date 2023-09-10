/*
package telran.multithreading;

public class Printer extends Thread {
private char symbol;
private int nSymbols;
public Printer(char symbol, int nSymbols) {
		this.symbol = symbol;
	this.nSymbols = nSymbols;
}
@Override
public void run() {
	for (int i= 0; i < nSymbols; i++) {
		System.out.println(symbol);
		try {
			sleep(10);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}


*/
/*
public class Printer extends Thread {
	private char []  symbols;
	private boolean running = true;

	public void stopPrinter() {
		this.running = false;
	}
	public Printer(String symbols) {
		
		this.symbols = symbols.toCharArray();
	}
	@Override
	public void run() {
		
		int index = 0;
		while(running) {
			System.out.print(symbols[index]);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				index++;
				if(index==symbols.length) {
					index=0;
				}
			}
			
		}
	}
	
}
*/
// HW 44
package telran.multithreading;

public class Printer extends Thread {
	private static final long SLEEPING_TIME = 100;
	int printerNumber;
	Printer next;
	private int inLine;
	static int overall;
	static int nPartitions;

	public Printer(int printerNumber) {
		this.printerNumber = printerNumber;
		inLine = overall / nPartitions;
	}

	public void setNext(Printer next) {
		this.next = next;
	}

	public static void setOverall(int overall) {
		Printer.overall = overall;
	}

	public static void setPartitions(int nPartitions) {
		Printer.nPartitions = nPartitions;

	}

	@Override
	public void run() {
		int count = 0;
		String line = (" " + printerNumber).repeat(inLine);
		while (count < nPartitions) {
			try {
				join();

			} catch (InterruptedException e) {
				System.out.println(line);
				next.interrupt();
				count++;
			}
		}

	}

}
