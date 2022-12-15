package BaiTap.Day11;

import java.util.Scanner;
import java.util.Stack;

public class Binary {public static void main(String[] args) {
    Stack<Integer> element = new Stack<>();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter number ");
    int number = scanner.nextInt();
    int surPlus;
    while (number > 0) {
        surPlus = number % 2;
        element.push(surPlus);
        number = number / 2;
    }
    while (!element.empty()) {
        System.out.print(element.pop());
    }
}
}
