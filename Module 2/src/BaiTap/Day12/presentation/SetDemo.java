package BaiTap.Day12.presentation;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> mySet = new HashSet<>();

        // Thêm phần tử vào tập hợp

        mySet.add("B2");
        mySet.add("C3");
        mySet.add("C3");
        mySet.add("A1");
        mySet.add("A1");
        // Lặp qua tập hợp
        for (String element : mySet) {
            System.out.println(element);
        }
        //LinkedHashSet
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add("B3");
        linkedHashSet.add("C2");
        linkedHashSet.add("A4");
        linkedHashSet.add("C2");
        linkedHashSet.add("A4");

        System.out.println(linkedHashSet);
        //TreeSet
        TreeSet<String> treeSet=new TreeSet<>();
        treeSet.add("B3");
        treeSet.add("C2");
        treeSet.add("A4");
        treeSet.add("C2");
        treeSet.add("A4");
        System.out.println(treeSet);
    }
}
