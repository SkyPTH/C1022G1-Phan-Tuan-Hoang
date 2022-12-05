package BaiTap.day_1;

import java.util.Scanner;

public class Hello
{
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("BaiTap.day_1.Hello: " + name);
    }
}