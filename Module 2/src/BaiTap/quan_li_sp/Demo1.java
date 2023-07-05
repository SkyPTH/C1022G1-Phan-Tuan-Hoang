package BaiTap.quan_li_sp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Demo1 {



    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        //for each
        for (String element : list) {
            System.out.print(element);
        }
        //for i
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
        //iterator
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
        //stream
        list.stream().forEach(element -> {
            System.out.print(element);
        });
    }
    }
