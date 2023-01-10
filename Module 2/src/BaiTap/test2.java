package BaiTap;

import java.util.Stack;

public class test2 {
    public static void main(String[] args) {
        String str = "abc b aaa a zz";
        String[] arr = str.split(" ");
        Stack<String> stack = new Stack<>();
        int max = arr[0].length();
        String flag = arr[0];
        int flag2=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[j].length()==0){break;}
                if (arr[j].length() > max) {
                    max = arr[j].length();
                    flag=arr[j];
                    flag2=j;
                }

            } stack.push(flag);
            arr[flag2]="";

        }
        System.out.println(stack);
    }
}



