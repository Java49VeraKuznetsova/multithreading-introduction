package telran.multithreading.games;

import java.util.concurrent.atomic.AtomicInteger;

public class Race {
	private int distance;
	private int minSleep;
	private int maxSleep;
	//private int winner = -1;
	private static AtomicInteger winnerID = new AtomicInteger();
	public Race(int distance, int minSleep, int maxSleep) {
		this.distance = distance;
		this.minSleep = minSleep;
		this.maxSleep = maxSleep;
		winnerID.set(-1);
	}
	public int getWinner() {
		//return winner;
		return winnerID.get();
	}
	public void setWinner(int winner) {
	
		//winnerID.compareAndSet(winnerID.get(), winner);
 Race.winnerID.compareAndSet(Race.winnerID.get(), winner);
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
