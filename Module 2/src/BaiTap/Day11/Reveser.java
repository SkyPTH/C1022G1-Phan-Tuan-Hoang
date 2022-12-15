package BaiTap.Day11;

import java.util.Scanner;
import java.util.Stack;

public class Reveser {
    public static void main(String[] args) {
        System.out.println("Nhập N phần tử: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Stack<Number> a1 = new Stack<>();
        int[] a2 = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập phần tử thứ " + i);
            a2[i] = scanner.nextInt();
            a1.push(a2[i]);
        }
        for (int j = 0; j < n; j++) {
            System.out.print(a1.pop());
        }


    }
}
