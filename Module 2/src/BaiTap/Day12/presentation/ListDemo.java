package BaiTap.Day12.presentation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();

        // Thêm phần tử vào danh sách
        myList.add("B");
        myList.add("A");
        myList.add("C");

        // Truy cập phần tử trong danh sách
        String firstElement = myList.get(0);
        System.out.println("First element: " + firstElement);

        // Lặp qua danh sách
        for (String element : myList) {
            System.out.println(element);
        }
        // Sắp xếp theo thứ tự tăng dần
        Collections.sort(myList);

        System.out.println("Các phần tử trong ArrayList sau khi sắp xếp:");
        for (String str : myList) {
            System.out.println(str);
        }

        // Sắp xếp theo thứ tự giảm dần sử dụng Comparator
        Collections.sort(myList, Comparator.reverseOrder());

        System.out.println("Các phần tử trong ArrayList sau khi sắp xếp giảm dần:");
        for (String str : myList) {
            System.out.println(str);
        }
        //Kiểm tra phần tử có tồn tại trong list không
        if(myList.contains("A")){
            System.out.println("Có chữ A");
        };
    }
}

