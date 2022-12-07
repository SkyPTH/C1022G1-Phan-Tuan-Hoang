package BaiTap.Day4;

import javax.swing.text.AttributeSet;
import java.util.Scanner;

public class CountChar {
    public static void main(String[] args) {
        System.out.println("Nhập chuỗi: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("Nhập ký tự cần tìm: ");
        char a = scanner.nextLine().charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == a) {
                count += 1;
            }
        }
        System.out.println(count);
    }
}
