package Concurrency_Library;

class TicketCounter {
    private int availableSeats = 1;

    // 'synchronized' locks this method per object so two threads cannot book the same seat simultaneously
    public synchronized void bookSeat(String customerName) {
        if (availableSeats > 0) {
            System.out.println(customerName + " is booking the seat...");
            try {
                Thread.sleep(200); // Simulating payment delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            availableSeats--;
            System.out.println("SUCCESS: Seat booked for " + customerName + ". Remaining seats: " + availableSeats);
        } else {
            System.out.println("FAILED: Sorry " + customerName + ", no seats left!");
        }
    }
}

public class SynchronizationDemo {

    public static void main(String[] args) {
        TicketCounter sharedCounter = new TicketCounter();

        // Two users trying to book the last remaining seat at the exact same moment
        Thread user1 = new Thread(() -> sharedCounter.bookSeat("Vishal"));
        Thread user2 = new Thread(() -> sharedCounter.bookSeat("Rohan"));

        user1.start();
        user2.start();
    }
}