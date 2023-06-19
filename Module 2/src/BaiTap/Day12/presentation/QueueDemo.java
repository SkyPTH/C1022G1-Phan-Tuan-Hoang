package BaiTap.Day12.presentation;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> myQueue = new LinkedList<>();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);

        // Lấy ra và xóa từng phần tử của queue
        while (!myQueue.isEmpty()) {
            int element = myQueue.poll();
            System.out.println("Popped element: " + element);
        }
    }
}

