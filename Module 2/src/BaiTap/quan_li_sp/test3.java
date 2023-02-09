package BaiTap.quan_li_sp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class test3 {
    public static void main(String[] args) {
        int[][] arr = {{2,3,9,8},
                {7,33,2,2},
                {18,51,5,11}};
        Set<Integer> set = new TreeSet<>();
        int count;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[1].length; j++) {
                count = 0;
                for (int k = 1; k < arr[i][j]; k++) {
                    if (arr[i][j] % k == 0) {
                        count++;
                    }
                }
                if (count == 1) {
                    set.add(arr[i][j]);
                }
            }
            System.out.println(set);
        }

        int[] arr2 = new int[set.size()];
        int i = 0;
        for (int a : set) {
            arr2[i++] = a;
        }

        System.out.println(Arrays.toString(arr2));
        System.out.println(arr.length);
    }
}
