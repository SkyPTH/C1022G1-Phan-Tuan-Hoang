package BaiTap.Day5;

import java.util.Arrays;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số nguyên");
        int numbInput = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[numbInput + 1];
        int[] arr2 = new int[numbInput + 1];
        arr2[0] = 1;
        arr2[1] = 1;
        int count = 0;
        int i = 2;
        while (i <= numbInput) {
            int count2 = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count2++;
                }
            }
            if (count2 == 2) {
                arr[count] = i;
                count++;
            }
            i++;
        }
        int k = 2;
        while (arr2[k - 1] + arr2[k - 2] <= numbInput) {

            arr2[k] = (arr2[k - 1] + arr2[k - 2]);
            k++;
        }
        for (int a = 0; a < arr.length; a++) {
            for (int b = 0; b < arr2.length; b++) {
                if (arr[a] == arr2[b] && arr[a] != 0) {
                    System.out.println(arr[a]);
                }

            }
        }
    }
}









