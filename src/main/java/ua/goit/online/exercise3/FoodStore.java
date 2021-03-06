package ua.goit.online.exercise3;

public class FoodStore {
    private static int THREADS_AMOUNT = 0;
    private static int BLOCKED = 0;

    public FoodStore(int maximumNumberOfClients) {
        THREADS_AMOUNT = maximumNumberOfClients;
    }

    public synchronized void enterStore() throws InterruptedException {
        while (BLOCKED == THREADS_AMOUNT) {
            wait();
        }
        BLOCKED++;
        notifyAll();
    }

    public synchronized void exitStore() throws InterruptedException {
        while (BLOCKED == 0) {
            wait();
        }
        BLOCKED--;
        notifyAll();
    }
}
