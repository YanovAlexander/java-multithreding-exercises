package ua.goit.online.exercise3;

public class Solution {
    private static FoodStore foodStore = new FoodStore(10);

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    storeArea();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    private static void storeArea() throws InterruptedException {
        System.out.println("Ready to enter a food store " + Thread.currentThread().getName());
        foodStore.enterStore();
        System.out.println("Buy some goods " + Thread.currentThread().getName());
        Thread.sleep(1000);
        foodStore.exitStore();
        System.out.println("Left food store " + Thread.currentThread().getName());
    }
}
