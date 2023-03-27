package BaiTap.quan_li_sp;

import java.util.Scanner;

public class test7 {
    public static void main(String[] args) {
        int rows = 5; // số dòng của tam giác
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*"); // in ra ký tự sao (*)
                if (j < i) {
                    System.out.print(" "); // in ra khoảng trắng (space) nếu không phải dòng cuối cùng
                }
            }
            System.out.println(); // xuống dòng để in tiếp dòng mới
        }
    }
}
//        System.out.println("nhap n");
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = 1;
//        for (int i = 1; i < 2 * n; ) {
//            for (int j = 1; j <= i; j++) {
//                if (j == 1 || j == m) {
//                    System.out.print("*");
//                } else {
//                    System.out.print(" ");
//                }
//                if (j == m) {
//                    System.out.println();
//                }
//                if (i <= n) {
//                    m++;
//                } else {
//                    m--;
//                }
//            }
//            i++;
//        }

