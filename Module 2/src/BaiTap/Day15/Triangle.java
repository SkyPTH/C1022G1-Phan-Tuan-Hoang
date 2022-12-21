package BaiTap.Day15;

import java.util.Scanner;

public class Triangle {
    public static void inputTriangle(double a, double b, double c) throws IllegalTriangleException {
        if (a < 0 || b < 0 || c < 0 || a + b < c || b + c < a || c + a < b) {
            throw new IllegalTriangleException("Không phải cạnh tam giác");
        } else {
            System.out.println("Là cạnh tam giác");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập cạnh thứ nhất của tam giác : ");
        double a = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập cạnh thứ 2 của tam giác: ");
        double b = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập cạnh thứ 3 của tam giác: ");
        double c = Integer.parseInt(sc.nextLine());
        try {
            inputTriangle(a, b, c);
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }
    }
}
