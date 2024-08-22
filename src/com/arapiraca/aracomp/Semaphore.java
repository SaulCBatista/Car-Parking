package com.arapiraca.aracomp;

public class Semaphore {
	private int count;
	
	public Semaphore(int initialCount) {
		this.count = initialCount;
	}
	
	public synchronized void acquire() {
		while(count <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		
		count--;
	}
	
	public synchronized void release() {
		count++;
		notify();
	}
	
	public int getCount() {
		return count;
	}
}
