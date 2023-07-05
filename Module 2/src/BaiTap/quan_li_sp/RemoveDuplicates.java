package BaiTap.quan_li_sp;

import java.util.Arrays;

public class RemoveDuplicates {
    public static int[] removeDuplicates(int[] arr) {
        int length = arr.length;
        int[] uniqueArr = new int[length];
        int uniqueCount = 0;
        System.out.println(Arrays.toString(uniqueArr));
        for (int i = 0; i < length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < uniqueCount; j++) {
                if (arr[i] == uniqueArr[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                uniqueArr[uniqueCount++] = arr[i];
            }
        }
        System.out.println(uniqueCount);
        System.out.println(Arrays.toString(uniqueArr));

        return Arrays.copyOf(uniqueArr, uniqueCount);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 4, 4, 5};
        int[] result = removeDuplicates(array);

        for (int num : result) {
            System.out.print(num + " ");  // Output: 1 2 3 4 5
        }
    }
}
