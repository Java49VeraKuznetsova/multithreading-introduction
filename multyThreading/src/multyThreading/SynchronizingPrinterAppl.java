package multyThreading;

public class SynchronizingPrinterAppl {

	private static final int N_PRINTERS = 4;
private static final int N_NUMBERS = 20;
private static final int N_POSITION = 5;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SynchronizingPrinter [] printers = new SynchronizingPrinter [N_PRINTERS];
		printers = createPrinters(printers);
		
		printers[0].interrupt();
	}
	
	private static SynchronizingPrinter[] createPrinters(SynchronizingPrinter [] printers) {
		// TODO Auto-generated method stub
		
		printers[0] = new SynchronizingPrinter(N_POSITION, N_NUMBERS, 1, null);
		for(int i = 1; i<printers.length; i++) {
			
		
			printers[i] = new SynchronizingPrinter(N_POSITION, N_NUMBERS, i+1, null);
			printers[i-1].printerNext = printers[i];
			printers[i-1].start();
			
		}
		
		printers[printers.length-1] =  new SynchronizingPrinter(N_POSITION, N_NUMBERS, 
				printers.length, printers[0]);
		
		printers[printers.length-1].start();
		
		
		
		return printers;
	}


}
