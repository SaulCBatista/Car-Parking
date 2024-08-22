package com.arapiraca.aracomp;

public class Vehicle extends Thread{

	private ParkingLot parkingLot;
	
	public Vehicle(ParkingLot parkingLot, String name) {
		super(name);
		this.parkingLot = parkingLot;
	}
	
	@Override
	public void run() {
		parkingLot.enterParkingLot();
		
		try {
			Thread.sleep((long) Math.random() * this.parkingLot.getMaxTime());
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		parkingLot.leaveParkingLot();
	}
	
}
