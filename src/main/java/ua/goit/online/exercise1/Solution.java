package ua.goit.online.exercise1;

public class Solution {
    public static void main(String[] args) {
        getInfo();

        Thread firstThread = new Thread(Solution::getInfo);
        Thread secondThread = new Thread(new ThreadGroup("newGroup"), Solution::getInfo);

        firstThread.start();
        secondThread.start();
    }

    private static void getInfo() {
        System.out.println("Thread name : " + Thread.currentThread().getName());
        System.out.println("Thread group : " + Thread.currentThread().getThreadGroup().getName());
        boolean isMainThread = Thread.currentThread().getId() == 1L;
        System.out.println("Is main thread? : " + isMainThread);
    }
}
