package BaiTap.Day4;

import java.util.Scanner;

public class DiagonalLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chiều dài cạnh vuông ma trận: ");
        int n = scanner.nextInt();
        int sum = 0;
        float[][] array = new float[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Nhập phần tử ma trận tại hàng " + i + " cột " + j + ": ");
                array[i][j] = scanner.nextFloat();
                if (i == j) {
                    sum += array[i][j];
                }
            }
        }
        System.out.println(sum);
    }
}
