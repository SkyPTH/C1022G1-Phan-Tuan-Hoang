package BaiTap.quan_li_sp;

import java.util.Scanner;

public class test4 {
    public static void main(String[] args) {
        System.out.println("nhập n");
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j >= (n - k) || j < k) {
                    System.out.print("   ");
                } else {
                    System.out.print(" * ");
                }
            }
            if (i < (n / 2) - 1) {
                k++;
            }
            if (i > (n / 2) - 1) {
                k--;
            }
            System.out.println();
        }
    }
}
