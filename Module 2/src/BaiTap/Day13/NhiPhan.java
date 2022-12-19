package BaiTap.Day13;

import java.util.Arrays;
import java.util.Scanner;

public class NhiPhan {
    public static int binarySearch(int[] array, int left, int right, int value) {
        int middle = (left + right) / 2;
        if(left<=right) {
            if (array[middle] == value) {
                return middle;
            } else {
                if (value > middle) {
                    left = middle + 1;
                }
                if (value < middle) {
                    right = middle - 1;
                }
                return binarySearch(array, left, right, value);
            }
        } else return -1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập độ dài mảng");
        int length = scanner.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.println("Nhập phần tử thứ " + i);
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        System.out.println("Nhập số cần tìm");
        int num=scanner.nextInt();
        System.out.println("Thứ tự của số cần tìm: "+binarySearch(arr,0,length-1,num));

    }
}
