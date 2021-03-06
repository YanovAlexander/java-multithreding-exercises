package ua.goit.online.exercise4;

import java.util.LinkedList;
import java.util.List;

public class Main {
    private static List<String> list = new LinkedList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            list.add(String.valueOf(i));
        }

        new Thread(() -> {
            for (String string : list) {

            }
        }).start();
        new Thread(() -> list.remove(20)).start();
    }
}


