package BaiTap;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        String str = "abbbdcef";
        String str2 = "";
        int count = 1;
        for (int i = 0; i < str.length(); ) {
            for (int j = 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    str = str.substring(0, j) + str.substring(j + 1);
                    count++;
                }
            }
            if (count > 1) {
                str2 += str.charAt(i);
            }
            count = 1;
            str = str.substring(1);
            if (str.length() <= 1) {
                break;
            }
        }
        String []arr=str2.split("");
        System.out.println(Arrays.toString(arr));
    }
}