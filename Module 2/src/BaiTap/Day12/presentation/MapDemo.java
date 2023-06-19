package BaiTap.Day12.presentation;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        // HashMap
        Map<String, Integer> hashMap = new HashMap<>();

        hashMap.put("b3", 2);
        hashMap.put("d2", 4);
        hashMap.put("a4", 1);
        hashMap.put("c1", 3);

        System.out.println("HashMap: " + hashMap);

        // LinkedHashMap
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("c", 3);
        linkedHashMap.put("a", 1);
        linkedHashMap.put("b", 2);
        linkedHashMap.put("d", 4);
        System.out.println("LinkedHashMap: " + linkedHashMap);

        // TreeMap
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("c", 3);
        treeMap.put("a", 1);
        treeMap.put("b", 2);
        treeMap.put("d", 4);
        System.out.println("TreeMap: " + treeMap);
    }
}

