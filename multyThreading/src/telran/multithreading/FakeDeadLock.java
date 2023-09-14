package telran.multithreading;

public class FakeDeadLock {

	
	private static final int PARAM = 10;
	private static int value = 0;
	private static Object mutex1 = new Object();
	private static Object mutex2 = new Object();
	
	public static void main(String[] args) throws InterruptedException {
		//Thread.currentThread().join();

//		FakeDeadLock thread1 = new FakeDeadLock(PARAM);
	//	FakeDeadLock thread2 = new FakeDeadLock(PARAM);
		
		Thread1 thread1= new Thread1();
		Thread2 thread2= new Thread2();
		thread1.start();
		thread2.start();
		/*
	for (int i=0; i<2; i++) {
		thread1();
	thread2();
	}
	*/
	//System.out.println(value);
	}
	/*
	private static synchronized  void thread1() {
		value++;
		thread2();
	}
	
	private static void thread2() {
		synchronized (mutex1) {
			value++;
			thread1();
		}
	
	}
	*/
private static class Thread1 extends Thread {
	@Override	
	public void run() {
			synchronized (mutex1) {
				
				//	System.out.println("thread1 - mutex1");
					try {
					Thread.sleep(PARAM);
					//	value+=1;
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				 				
				//	System.out.println("thread1 - catch");
					//*/
								synchronized (mutex2) {
					//System.out.println("thread1 - mutex2");
				}
			}
		}
	}
private static class Thread2 extends Thread {
	@Override
	public void run() {
		synchronized (mutex2) {
			
			try {
			//	System.out.println("thread2 - mutex2");
				Thread.sleep(PARAM);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		//	*/
			//value+=1;
			//System.out.println("thread2 - catch");
			synchronized (mutex1) {
				
			}
			
		}
	}
}
}
