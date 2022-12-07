package BaiTap.Day4;

import java.util.Scanner;

public class CountChar {
    public static void main(String[] args) {
        System.out.println("Nhập chuỗi: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("Nhập ký tự cần tìm: ");
        char a = scanner.nextLine().charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == a) {
                count += 1;
            }
        }
        System.out.println(count);
    }

    public static class Fan {
        final int slow = 1;
        final int medium = 2;
        final int fast = 3;
        private int speed;
        private boolean on;
        private double radius;
        private String color;

        public Fan() {
            this(1, false, 5, "blue");
        }

        public Fan(int speed, boolean on, double radius, String color) {
            this.speed = speed;
            this.on = on;
            this.radius = radius;
            this.color = color;
        }
    }
}
