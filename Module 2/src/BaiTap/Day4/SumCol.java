package BaiTap.Day4;

import java.util.Scanner;

public class SumCol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chiều rộng ma trận: ");
        int m = scanner.nextInt();
        System.out.println("Nhập chiều dài ma trận: ");
        int n = scanner.nextInt();
        float[][] array = new float[m][n];
        System.out.println("Nhập cột cần tính tổng : ");
        int col = scanner.nextInt();
        float sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Nhập phần tử ma trận tại hàng " +i  + " cột " + j + ": ");
                array[i][j] = scanner.nextFloat();
                if(j==col){sum=sum+array[i][j];
            }
        }

          System.out.println(sum);
    }
}}
