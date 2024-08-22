package com.arapiraca.aracomp;

public class Main {
	
	public static void main(String[] args) {
		ParkingLot parkingLot = new ParkingLot(3, 10000);
		
		for(int i = 1; i < 10; i++) {
			new Vehicle(parkingLot, "Veículo " + i).start();
		}
	}
}
