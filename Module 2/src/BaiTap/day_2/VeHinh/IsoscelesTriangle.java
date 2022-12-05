package BaiTap.day_2.VeHinh;

import java.util.Scanner;

public class IsoscelesTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chiều cao: ");
        int h = scanner.nextInt();
        int max = h ;
        int min = h ;
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= (2*h-1); j++) {
                if (j >= min && j <= max) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            min--;
            max++;
            System.out.println();
        }
    }
}