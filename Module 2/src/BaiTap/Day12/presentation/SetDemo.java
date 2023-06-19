package BaiTap.Day12.presentation;
import java.util.HashSet;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> mySet = new HashSet<>();

        // Thêm phần tử vào tập hợp
        mySet.add("A");
        mySet.add("A");
        mySet.add("B");
        mySet.add("C");
        mySet.add("C");

        // Lặp qua tập hợp
        for (String element : mySet) {
            System.out.println(element);
        }
    }
}
