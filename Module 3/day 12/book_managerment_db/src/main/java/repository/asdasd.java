package repository;

import java.util.Arrays;

public class asdasd {
    public static void main(String[] args) {
        int []n = {0};
        Arrays.sort(n);
        int a=0;
        for (int i = 0; i <n.length ; i++) {
            if(n[i]!=i){
                a=i;
                break;
            }else {
                a = n[n.length-1]+1;
            }
        }
        if(n[0]==0&&n.length==1){
            a=1;
        }
        System.out.println(a);
    }
}
