package BaiTap.day_1;

import java.util.Scanner;
public class Chuyentien {
    public static void main(String[] args) {
        double usd;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số tiền USD: ");
        usd = sc.nextDouble();
        System.out.println("Giá trị VND là: " + (usd * 23000) );
    }
}

