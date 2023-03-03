package BaiTap.quan_li_sp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class test3 {
    int[] solution ( int[][] arr){
        Set<Integer> s = new TreeSet<>();
        int count;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                count = 0;
                for (int k = 1; k < arr[i][j]; k++) {
                    if (arr[i][j] % k == 0) {
                        count++;
                    }
                }
                if (count == 1) {
                    s.add(arr[i][j]);
                }
            }
        }
        int[] a2 = new int[s.size()];
        int i = 0;
        for (int a : s) {
            a2[i++] = a;
        }
        return a2;
    }
    }
