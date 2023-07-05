package BaiTap.Day12.presentation;

import java.util.*;

public class GiaiThuatDemo {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 4, 3, 5, 1, 6, 7, 7, 8};

        Map<Integer, Integer> countMap = new HashMap<>();

        // Đếm số lần xuất hiện của mỗi phần tử trong mảng
        for (int value : array) {
            if (countMap.containsKey(value)) {
                countMap.put(value, countMap.get(value) + 1);
            } else {
                countMap.put(value, 1);
            }
        }

        List<Integer> uniqueValues = new ArrayList<>();

        // Chỉ lấy các phần tử có số lần xuất hiện là 1
        for (int value : array) {
            if (countMap.get(value) == 1) {
                uniqueValues.add(value);
            }
        }

        // In các phần tử có số lần xuất hiện là 1
        for (int value : uniqueValues) {
            System.out.println(value);
        }
    }
}
