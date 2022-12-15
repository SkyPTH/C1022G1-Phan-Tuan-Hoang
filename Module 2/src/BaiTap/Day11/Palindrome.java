package BaiTap.Day11;

import java.util.LinkedList;

import java.util.Scanner;
import java.util.Stack;
public class Palindrome {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            java.util.Queue<String> queue = new LinkedList<>();
            Stack<String> stack = new Stack<>();
            System.out.println("Nhập chuỗi");
            String string = scanner.nextLine().toLowerCase();
            for (int i = 0; i < string.length(); i++) {
                queue.offer(string.charAt(i) + "");
                stack.push(string.charAt(i) + "");
            }
            boolean flag = true;
            for (int i = 0; i < string.length(); i++) {
                String queueChar = queue.poll();
                String stackChar = stack.pop();
                if (!queueChar.equals(stackChar)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Là chuỗi palindrome.");
            } else {
                System.out.println("Không phải chuỗi palindrome.");
            }

        }
    }
