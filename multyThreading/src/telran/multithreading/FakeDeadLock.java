package telran.multithreading;

public class FakeDeadLock {

	//MY CODE
	private static final int PARAM = 10;
	private static Object mutex1 = new Object();
	private static Object mutex2 = new Object();
	
	public static void main(String[] args) throws InterruptedException {
		//Thread.currentThread().join();
		
		Thread1 thread1= new Thread1();
		Thread2 thread2= new Thread2();
		thread1.start();
		thread2.start();
		
	}
	
	
private static class Thread1 extends Thread {
	@Override	
	public void run() {
			synchronized (mutex1) {
				
								try {
					Thread.sleep(PARAM);
					
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				 
								synchronized (mutex2) {
				
				}
			}
		}
	}
private static class Thread2 extends Thread {
	@Override
	public void run() {
		synchronized (mutex2) {
			
			try {
		
				Thread.sleep(PARAM);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
	
			synchronized (mutex1) {
				
			}
			
		}
	}
}
}
