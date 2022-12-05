package BaiTap.day_2;

import java.util.Scanner;

public class SoNguyenTo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng số nguyên tố cần in ra: ");
        int num = scanner.nextInt();
        int count = 0;

        short i = 2;
        while (count <= num) {
            int count2 = 0;
            for (short j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count2++;
                }
            }
                if (count2 == 2) {
                    System.out.println(i);
                    count++;

                }
            i++;
            }

        }
    }

