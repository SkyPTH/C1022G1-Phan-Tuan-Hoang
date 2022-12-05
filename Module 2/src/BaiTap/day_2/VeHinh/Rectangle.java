package BaiTap.day_2.VeHinh;

import java.util.Scanner;

public class Rectangle {public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Nhập chiều dài: ");
    int numb1 = scanner.nextInt();
    System.out.println("Nhập chiều rộng: ");
    int numb2 = scanner.nextInt();
    for (int i = 1; i <= numb1; i++) {
        for (int j = 1; j <= numb2; j++) {
                System.out.print("*");
            }
        System.out.println();
        }

    }
}

