package ua.goit.online.exercise2;

public class Solution implements Runnable {
    private int counter;
    private String message;

    public Solution(String message, int counter) {
        this.message = message;
        this.counter = counter;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public void run() {
        while (--counter >= 0) {
            System.out.println(Thread.currentThread().getName() + " " + getMessage() + " counter = " + counter);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Runnable first = new Solution("I am the best", 20);

        new Thread(first).start();
        new Thread(first).start();
        new Thread(first).start();

        System.out.println("Main thread finished " + Thread.currentThread().getName());
    }
}
