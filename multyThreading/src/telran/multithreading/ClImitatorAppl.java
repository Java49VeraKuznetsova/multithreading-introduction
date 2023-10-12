package telran.multithreading;

import java.util.concurrent.*;


public class ClImitatorAppl {

	private static final int N_REQUEST = 1000000;
	private static final long RUNNING_TIME = 1;

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Request> queue =  new LinkedBlockingQueue<>();
		
ClientImitator client = new ClientImitator(N_REQUEST, RUNNING_TIME, queue);
ServerImitator server = new ServerImitator(queue);
client.start();
server.start();
client.join(5000);
//client.interrupt();
server.interrupt();
server.shutdown();
System.out.printf("number off all requests %d\n", N_REQUEST);
System.out.printf("number of processed requests %d\n", Request.getActualRequestAmount());
	}

}
