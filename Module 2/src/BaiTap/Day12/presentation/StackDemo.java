package BaiTap.Day12.presentation;
import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        // Lấy ra và xóa từng phần tử của stack
        while (!myStack.isEmpty()) {
            int element = myStack.pop();
            System.out.println("Popped element: " + element);
        }
    }
}

