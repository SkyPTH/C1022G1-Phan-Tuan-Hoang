package BaiTap.quan_li_sp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicates3 {
    public static void main(String[] args) {
        String[] list = {"a", "a", "b", "c", "c", "c", "c"};
        List<String> stringList = new ArrayList<>(Arrays.asList(list));
        for (int i = 0; i < stringList.size(); i++) {
            for (int j = i + 1; j < stringList.size(); j++) {
                if (stringList.get(i).equals(stringList.get(j))) {
                    stringList.remove(j);
                    j--;
                }
            }
        }
        for (int i=0; i<stringList.size(); i++){
            System.out.print(stringList.get(i));
        }
    }
}
