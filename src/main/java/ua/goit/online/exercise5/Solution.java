package ua.goit.online.exercise5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Solution {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Ford Mustang Shelby GT500", 300));
        cars.add(new Car("Chevrolet Camaro  ZL1", 321));
        cars.add(new Car("Nissan GT-R", 315));
        cars.add(new Car("Nissan 370Z", 270));
        cars.add(new Car("Toyota Supra", 280));
        cars.add(new Car("Mazda RX7", 251));
        cars.add(new Car("Honda S2000", 241));
        CountDownLatch countDownLatch = new CountDownLatch(cars.size());
        Race race = new Race(countDownLatch, 400);
        race.startRace(cars);
    }
}
