package telran.multithreading.games;

import java.util.concurrent.atomic.AtomicInteger;

public class Race {
	private int distance;
	private int minSleep;
	private int maxSleep;
	//private int winner = -1;
	private static AtomicInteger winnerID = new AtomicInteger(-1);
	public Race(int distance, int minSleep, int maxSleep) {
		this.distance = distance;
		this.minSleep = minSleep;
		this.maxSleep = maxSleep;
	}
	public int getWinner() {
		//return winner;
		return winnerID.get();
	}
	public void setWinner(int winner) {
		/*
		if (this.winner == -1) {
			this.winner = winner;
			
		}
		*/
		winnerID.compareAndSet(winnerID.get(), winner);
 
	}
	public int getDistance() {
		return distance;
	}
	public int getMinSleep() {
		return minSleep;
	}
	public int getMaxSleep() {
		return maxSleep;
	}
	
}
