package BaiTap.quan_li_sp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates2 {
    public static int[] removeDuplicates(int[] arr) {
        Set<Integer> uniqueSet = new HashSet<>();
        for (int num : arr) {
            uniqueSet.add(num);
        }

        int[] uniqueArr = new int[uniqueSet.size()];
        int index = 0;
        for (int num : uniqueSet) {
            uniqueArr[index++] = num;
        }

        return uniqueArr;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 4, 4, 5};
        int[] result = removeDuplicates(array);

        for (int num : result) {
            System.out.print(num + " ");  // Output: 1 2 3 4 5
        }
    }
}
