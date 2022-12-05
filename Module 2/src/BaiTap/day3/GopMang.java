package BaiTap.day3;

import java.util.Arrays;
import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số phần tử trong mảng 1: ");
        int n = scanner.nextInt();
        int[] Array1 = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập phần tử thứ " + (i + 1) + " trong mảng");
            Array1[i] = scanner.nextInt();
        }
        System.out.println("Nhập số phần tử trong mảng 2: ");
        int m = scanner.nextInt();
        int[] Array2 = new int[m];
        for (int j = 0; j < m; j++) {
            System.out.println("Nhập phần tử thứ " + (j + 1) + " trong mảng");
            Array2[j] = scanner.nextInt();
        }
        int[] Array = new int[n + m];
        for (int k = 0; k < (n + m); k++) {
            if (k < n) {
                Array[k] = Array1[k];
            } else {
                Array[k] = Array2[k - n];
            }
        }
        System.out.println(Arrays.toString(Array));
    }
}