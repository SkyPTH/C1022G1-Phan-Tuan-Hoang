package BaiTap.Day14;

import java.util.Arrays;

public class MinhHoa { public static void insertionSort(int[] array){

    for(int i = 1; i < array.length; i++){
        int x = array[i];
        System.out.println("Mảng : "+Arrays.toString(array)+" , x= "+x+ " , i= "+i);
        while(i> 0 && x < array[i-1]){
            array[i] = array[i-1];
            i--;
            System.out.println("Mảng : "+Arrays.toString(array)+" , x= "+x+ " , i= "+i);
        }
        array[i] = x;
        System.out.println("Mảng : "+Arrays.toString(array)+" , x= "+x+ " , i= "+i);
    }
}

    public static void main(String[] args) {
        int [] arr={3,2,1};
        insertionSort(arr);

    }
}
