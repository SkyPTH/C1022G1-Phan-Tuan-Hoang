package BaiTap.Day12;

import java.util.ArrayList;
import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5}; //Khai báo array, kích thước cố định, mảng là 1 cấu trúc dữ liệu cơ bản trong java
        System.out.println(arr.length); //Chỉ có thuộc tính length
        System.out.println(arr[1]); //nhanh hơn vì truy cập trực tiếp bằng index
        //Khai báo arraylist với kích thước không cố định, là 1 lớp trong java, implement interface List của collection
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2); // 1 số phương thức hỗ trợ của arraylist
        if(arrayList.contains(2)){
            System.out.println("Có số 2");
        };
        System.out.println(arrayList.get(0)); //chậm hơn vì còn cần phải thông qua phương thức get
        String a="asd";


        char [] arr1=a.toCharArray();
        System.out.println(arr1);
    }


}
