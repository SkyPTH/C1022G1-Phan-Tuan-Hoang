package BaiTap.Day14;

import java.util.Arrays;
import java.util.Scanner;

public class CaiDatChen {
    public static void insertionSort(int[] list) {

        for (int i = 1; i < list.length; i++) {
            int x = list[i];
            while (i > 0 && list[i] < list[i - 1]) {
                list[i] = list[i - 1];
                i--;
                list[i] = x;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập độ dài mảng");
        int length = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.println("Nhập phần tử arr[" + i + "]");
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
