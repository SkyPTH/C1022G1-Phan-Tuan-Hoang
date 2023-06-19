package BaiTap.Day12.presentation;
import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();

        // Thêm phần tử vào danh sách
        myList.add("A");
        myList.add("B");
        myList.add("C");

        // Truy cập phần tử trong danh sách
        String firstElement = myList.get(0);
        System.out.println("First element: " + firstElement);

        // Lặp qua danh sách
        for (String element : myList) {
            System.out.println(element);
        }
    }
}

