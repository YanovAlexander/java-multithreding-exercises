package ua.goit.online.exercise4;

import java.util.Objects;

public class Main {
    private static Object monitor = new Object();

    public void method() throws InterruptedException {
        synchronized (monitor) {
            System.out.println("Do something");
        }
    }


    public void method2() {
        synchronized (monitor) {
            System.out.println("Do something");
        }
    }
}


