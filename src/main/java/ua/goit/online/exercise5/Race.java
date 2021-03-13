package ua.goit.online.exercise5;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import static java.lang.Thread.sleep;

public class Race {
    private CountDownLatch countDownLatch;
    private int distance;
    private static int place = 1;
    private boolean isFinish = false;

    public Race(CountDownLatch countDownLatch, int distance) {
        this.countDownLatch = countDownLatch;
        this.distance = distance;
    }

    public void startRace(List<Car> cars) {
        cars.forEach(car -> {
                    createCarThread(car);
                }
        );
        System.out.println("GO!!!");
        startCountDown();
    }

    private void createCarThread(Car car) {
        new Thread(() -> {
            while (car.getPassed() < distance) {
                int speed = car.getRandomSpeed();
                car.setPassed(car.getPassed() + speed);
                System.out.println("Car name: " + car.getName() + " => " + "speed: " + car.getRandomSpeed());
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
                if (car.getPassed() >= distance) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (this) {
                        if (!isFinish) {
                            System.out.println("Finish");
                            isFinish = true;
                        }
                        System.out.println("car Place: " + place++ + " -> " + car.getName());
                    }
                }
            }
        }).start();
    }

    private void startCountDown() {
        try {
            sleep(1000);
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}