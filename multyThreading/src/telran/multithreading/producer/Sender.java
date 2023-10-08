package telran.multithreading.producer;

import telran.multithreading.messaging.MessageBox;

public class Sender extends Thread {
	private MessageBox messageBoxOdd;
	private MessageBox messageBoxEven;
	private int nMessages;
	public Sender(MessageBox messageBoxOdd, MessageBox messageBoxEven, int nMessages) {
		super();
		this.messageBoxOdd = messageBoxOdd;
		this.messageBoxEven = messageBoxEven;
		this.nMessages = nMessages;
	}


	@Override
	public void run() {
		MessageBox messageBox = null;
		for (int i = 1; i <= nMessages; i++) {
			try {
				messageBox = i % 2 == 0 ? messageBoxEven : messageBoxOdd;
				messageBox.put("message" + i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			try {
//				sleep(10);
//			} catch (InterruptedException e) {
//				
//			}
		}
	}
	
}