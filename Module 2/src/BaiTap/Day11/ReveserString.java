package BaiTap.Day11;

import java.util.Scanner;
import java.util.Stack;

public class ReveserString {
    public static void main(String[] args) {
        Stack<String> myStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi bất kỳ: ");
        String str = scanner.nextLine();
        for (int i = 0; i < str.length(); i++) {
            myStack.push(str.charAt(i)+"");
        }
        System.out.print("Chuỗi đảo ngược là: ");
        for (int i = 0; i < str.length(); i++) {
            System.out.print(myStack.pop());
        }
    }
}