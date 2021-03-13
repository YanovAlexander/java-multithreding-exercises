package ua.goit.online;

public class Hello {
    public static  void method1() {
        synchronized (Main.class) {

        }
    }


    public static void main(String[] args) {
        Main main1 = new Main();
        main1.method2();

        Main main2 = new Main();
        main2.method2();
    }
}
