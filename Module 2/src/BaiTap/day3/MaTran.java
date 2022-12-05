package BaiTap.day3;


import java.util.Scanner;

public class MaTran {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chiều rộng ma trận: ");
        int m = scanner.nextInt();
        System.out.println("Nhập chiều dài ma trận: ");
        int n = scanner.nextInt();
        float[][] Array = new float[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Nhập phần tử ma trận tại hàng " + (i + 1) + " cột " + (j + 1) + ": ");
                Array[i][j] = scanner.nextFloat();
            }
        }
        float max = Array[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (Array[i][j] > max) {
                    max = Array[i][j];
                }

            }
        } System.out.println(max);
    }
}
