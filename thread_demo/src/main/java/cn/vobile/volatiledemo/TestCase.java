package cn.vobile.volatiledemo;

public class TestCase {
    public static int number;
    public static boolean isinited;
    public static void main(String[] args) {
        new Thread(
                () -> {
                    while (!isinited) {
                        Thread.yield();
                    }
                    System.out.println(number);
                }
        ).start();
        number = 20;
        isinited = true;
    }
}