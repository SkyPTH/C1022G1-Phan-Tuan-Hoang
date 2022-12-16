package BaiTap.Day12;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class TreeMap {
    public static void main(String[] args) {
        System.out.println("Nhập chuỗi");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().toLowerCase();
        String[] strArr = str.split(" ");
        System.out.println(Arrays.toString(strArr));
        Map<String, Integer> myMap = new java.util.TreeMap<>();
        for (int i = 0; i < strArr.length; i++) {
            int count = 0;
            for (int j = 0; j < strArr.length; j++) {
                if (strArr[i].equals(strArr[j])) {
                    count = count + 1;
                    myMap.put(strArr[i], count);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : myMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}