package BaiTap.Day8.Resiable;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Shape[] shape = new Shape[3];
        shape[0] = new Circle(10);
        shape[1] = new Rectangle(2, 6);
        shape[2] = new Square(5);
        System.out.println(Arrays.toString(shape));
        System.out.println("Diện tích hình tròn trước khi thay đổi là: " + shape[0].resize(0));
        System.out.println("Diện tích hình tròn sau khi thay đổi là: " + shape[0].resize(Math.random() * 100 + 1));
        System.out.println("Diện tích hình chữ nhật trước khi thay đổi là: " + shape[1].resize(0));
        System.out.println("Diện tích hình chữ nhật sau khi thay đổi là: " + shape[1].resize(Math.random() * 100 + 1));
        System.out.println("Diện tích hình vuông trước khi thay đổi là: " + shape[2].resize(0));
        System.out.println("Diện tích hình vuông sau khi thay đổi là: " + shape[2].resize(Math.random() * 100 + 1));
    }
}
