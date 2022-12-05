package BaiTap.day3;

import java.util.Arrays;
import java.util.Scanner;

public class IndexAdd {
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
        System.out.println("Nhập phần tử cần thêm ");
        int x = scanner.nextInt();
        System.out.println("Nhập Index chèn thêm phần tử: ");
        int Index = scanner.nextInt();
        if (Index < -1 || Index > n) {
            System.out.println("Không chèn được vào mảng");
        }
        int[] Array2 = new int[n + 1];
        for (int j = 0; j < (n + 1); j++) {
            Array2[Index] = x;
            if (j < Index) {
                Array2[j] = Array[j];
            } else {
                if (j > Index) {
                    Array2[j] = Array[j - 1];
                }
            }
        }
        System.out.println(Arrays.toString(Array2));
    }
}
