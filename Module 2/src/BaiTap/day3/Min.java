package BaiTap.day3;

import java.util.Scanner;

public class Min {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số phần tử trong mảng : ");
        int n = scanner.nextInt();
        int[] Array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập phần tử thứ " + (i + 1) + " trong mảng");
            Array[i] = scanner.nextInt();
        }
        int min = Array[0];
        for (int i = 0; i < n; i++) {
            if (Array[i] < min) {
                min = Array[i];
            }
        }
        System.out.println(min);
    }
}
