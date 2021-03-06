package ua.goit.online.exercise2;

public class SolutionDataRace {
    //    private static Object monitor = new Object();
    private static int count = 0; // shared state

    static class MyRunnable implements Runnable {
        public void run() {
//            synchronized (monitor) {
            print("Enter: " + count);

            int y = count;

            print("Read: " + y);

            count = y + 1;

            print("Sum: " + count);
//            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable target = new MyRunnable();
        Thread thread1 = new Thread(target);
        Thread thread2 = new Thread(target);
        Thread thread3 = new Thread(target);
        Thread thread4 = new Thread(target);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        print("Total: " + count);
    }

    public static synchronized void print(String message) {
        long id = Thread.currentThread().getId();
        System.out.println(id + ": " + message);
    }
}
