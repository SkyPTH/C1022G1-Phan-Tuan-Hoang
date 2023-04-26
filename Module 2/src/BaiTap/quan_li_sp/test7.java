package BaiTap.quan_li_sp;

import java.util.Scanner;

public class test7 {
    public static void main(String[] args) {
        int n = 5;
        int m = 1;
        for (int i = 1; i < 2 * n ; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == m) {
                    System.out.print(" * ");
                } else {
                    System.out.print("   ");
                }
            }
            if(i<n){
                m++;
            } else if (i>=n) { m--;}
            System.out.println();
        }
    }
}
//

