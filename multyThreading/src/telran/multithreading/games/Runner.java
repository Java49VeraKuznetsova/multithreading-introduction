package telran.multithreading.games;

import java.util.concurrent.atomic.AtomicInteger;

public class Runner extends Thread {
private Race race;
private int runnerId;
private static AtomicInteger winnerID = new AtomicInteger(0);
public Runner(Race race, int runnerId) {
	this.race = race;
	this.runnerId = runnerId;
}
@Override
public void run() {
	int sleepRange = race.getMaxSleep() - race.getMinSleep() + 1;
	int minSleep = race.getMinSleep();
	int distance = race.getDistance();
	for (int i = 0; i < distance; i++) {
		try {
			sleep((long) (minSleep + Math.random() * sleepRange));
		} catch (InterruptedException e) {
			throw new IllegalStateException();
		}
		System.out.println(runnerId);
	}
	winnerID.set(runnerId);
	race.setWinner(winnerID.get());
	
	//race.setWinner(runnerId);
}
}
