package com.arapiraca.aracomp;

public class ParkingLot {
	private Semaphore availableSpaces;
	private long maxTime;
	
	public ParkingLot(int totalSpaces, long maxTime) {
		this.availableSpaces = new Semaphore(totalSpaces);
		this.maxTime = maxTime;
	}
	
	public void enterParkingLot() {
		System.out.println(Thread.currentThread().getName() + " Tentado entrar no estacionamento...");
		
		 synchronized(this) {
	        if (availableSpaces.getCount() == 0) {
	            System.out.println(Thread.currentThread().getName() + ": Sem espaço disponível, veículo dando uma volta no quarteirão...");
	        }
	     }
		
		this.availableSpaces.acquire();
		System.out.println(Thread.currentThread().getName() + " entrou no estacionamento. Vagas disponíveis: " + this.availableSpaces.getCount());
	}
	
	public void leaveParkingLot() {
		this.availableSpaces.release();
		System.out.println(Thread.currentThread().getName() + " saiu do estacionamento. Vagas disponíveis: " + this.availableSpaces.getCount());
	}
	
	public long getMaxTime() {
		return maxTime;
	}
}
