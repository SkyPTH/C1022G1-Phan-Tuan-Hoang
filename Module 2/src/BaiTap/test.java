package BaiTap;

import java.sql.Array;

public class test {
    public static void main(String[] args) {
        String s1 = "Abcdef";
        String s2 = "Adghjklbc";
        String s3 = "";
        for(int i=0;i<s1.length();){
            for (int j = 0; j <s2.length() ; j++) {
                if(s1.charAt(i)==s2.charAt(j)) {
                    s3 += s1.charAt(i);
                    i++;
                }
            }
        }
        System.out.println(s3);
    }}
