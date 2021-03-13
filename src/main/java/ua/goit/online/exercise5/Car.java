package ua.goit.online.exercise5;

import java.util.Random;

public class Car {

    private int passed;
    private String name;
    private int maxSpeed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Car(String name, int maxSpeed) {
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    public int getRandomSpeed() {
        int min = getMaxSpeed() / 2;
        int max = getMaxSpeed();
        Random r = new Random();
        int speed = r.nextInt((max - min) + 1) + min;
        return speed;
    }

    public int getPassed() {
        return passed;
    }

    public void setPassed(int passed) {
        this.passed = passed;
    }
}
