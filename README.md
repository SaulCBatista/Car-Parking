# Parking Lot with Slot Management

## Problem Description

This project simulates the operation of a parking lot with a limited number of available slots. The main objective is to manage vehicle access to the parking lot, ensuring that:

- Vehicles cannot enter if all slots are occupied.
- Vehicles can exit the parking lot safely, and the availability of slots is updated correctly.
- The synchronization between vehicles entering and exiting is done to prevent race conditions and ensure the integrity of the data regarding the number of available slots.

## Project Structure

The project is implemented in Java and consists of the following main classes:

- **Semaphore**: Simulates the behavior of a counting semaphore, which manages the number of available slots in the parking lot. It controls access safely, ensuring that the number of slots is correctly decremented when a vehicle enters and incremented when a vehicle exits.
  
- **ParkingLot**: This class manages the parking lot's entry and exit operations. It uses the `Semaphore` to check if there are available slots and, if not, notifies the vehicle to "drive around the block" until a slot is available.
  
- **Vehicle**: Each vehicle is represented by a thread. When a vehicle tries to enter the parking lot, it checks if there are available slots. If there are, it occupies a slot; otherwise, it waits until a slot is available. After a period of time, the vehicle exits the parking lot, freeing up the slot.

- **Main**: The main class initializes the parking lot with a defined number of slots and simulates the entry and exit of multiple vehicles.

## Operation

- **Vehicle Entry**: When a vehicle tries to enter the parking lot, it checks if there are available slots. If the parking lot is full, it displays a message indicating "no available space" and that the vehicle is "driving around the block". The vehicle thread is blocked until a slot is available.

- **Vehicle Exit**: After a period of time, the vehicle exits the parking lot, freeing up the slot and allowing other vehicles to enter.

- **Synchronization**: The use of `Semaphore` and `synchronized` in the `ParkingLot` class ensures that vehicle entry and exit operations are synchronized, preventing race conditions and ensuring that the number of available slots is always accurate.

## How to Run

1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/SaulCBatista/Car-Parking.git
2. Navigate to the project directory:
   ```bash
   cd car-parking
3. Compile and run the project:
   ```bash
   javac Main.java
   java Main
4. The program will simulate the entry and exit of vehicles in the parking lot. Watch the console messages to see how the vehicles interact with the slot management system.
   ```bash
   Vehicle 1 attempting to enter...
   Vehicle 1 entered. Available slots: 2
   Vehicle 2 attempting to enter...
   Vehicle 2 entered. Available slots: 1
   Vehicle 3 attempting to enter...
   Vehicle 3 entered. Available slots: 0
   Vehicle 4 attempting to enter...
   Vehicle 4: No available space, vehicle driving around the block...
   Vehicle 1 exited. Available slots: 1
   Vehicle 4 entered. Available slots: 0

