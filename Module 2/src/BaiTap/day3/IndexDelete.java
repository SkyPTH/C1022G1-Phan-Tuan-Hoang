package BaiTap.day3;

import java.util.Arrays;
import java.util.Scanner;

public class IndexDelete {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số phần tử trong mảng: ");
        int n = scanner.nextInt();
        int[] Array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập phần tử thứ " + (i + 1) + " trong mảng");
            Array[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(Array));
        System.out.println("Nhập phần tử cần xóa");
        int x = scanner.nextInt();
        for (int j = 0; j < n - 1; j++) {
            if (Array[j] == x) {
                while (j < (n - 1)) {
                    Array[j] = Array[j + 1]; j++;
                }
                Array[n - 1] = 0;
            }
        }
        System.out.println(Arrays.toString(Array));
    }
}
