package multyThreading;

public class SynchronizingPrinter extends Thread{
	
	int N_POSITION;
	int N_NUMBERS;
	SynchronizingPrinter printerNext;
	int printerNumber;
	private int n_portion;
	
	public SynchronizingPrinter(int N_POSITION, int N_NUMBERS, int printerNumber, 
			SynchronizingPrinter printerNext) {
		
		this.N_POSITION = N_POSITION;
		this.N_NUMBERS = N_NUMBERS;
		this.printerNumber = printerNumber;
		this.printerNext = printerNext;
		n_portion = N_NUMBERS/N_POSITION;
	}
	
	
	@Override
	public void run() {
		int index = 0;
		//int n_portion = N_NUMBERS/N_POSITION;
		
		while (index < N_POSITION) {
			
			try {
				sleep(100);
			} catch (InterruptedException e) {
				System.out.print(("" + printerNumber).repeat(n_portion));
				System.out.println();
				printerNext.interrupt();
				index++;
			}
		}
	}
	

}
