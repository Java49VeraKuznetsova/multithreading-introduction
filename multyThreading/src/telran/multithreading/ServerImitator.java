package telran.multithreading;

import java.util.concurrent.*;

public class ServerImitator extends Thread {
BlockingQueue<Request> queue;
ExecutorService threadPool = Executors.newFixedThreadPool(10);

public ServerImitator(BlockingQueue<Request> queue) {
	super();
	this.queue = queue;
}
 public void shutdown() throws InterruptedException {
	 threadPool.awaitTermination(10, TimeUnit.SECONDS);
	 threadPool.shutdownNow();
 }
@Override
public void run() {
	while (true) {
		try {
			Request request = queue.take();
			/*
			Thread thread = new Thread(request);
			thread.start();
			*/
			threadPool.execute(request);
			
		} catch (InterruptedException e) {
			Request remainedReq = null;
			while((remainedReq = queue.poll()) != null) {
				/*
				Thread thread = new Thread(remainedReq);
				thread.setDaemon(true);
				thread.start();	
				*/
				threadPool.execute(remainedReq);
			}
			break;
		}
	}
}
}
