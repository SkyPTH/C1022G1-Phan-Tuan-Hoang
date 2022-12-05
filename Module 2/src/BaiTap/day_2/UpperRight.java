package BaiTap.day_2;

import java.util.Scanner;

public class UpperRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chiều dài: ");
        int numb1 = scanner.nextInt();
        for (int i = 1; i <= numb1; i++) {
            for (int j = 1; j <= numb1; j++) {
                if (j >= i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
