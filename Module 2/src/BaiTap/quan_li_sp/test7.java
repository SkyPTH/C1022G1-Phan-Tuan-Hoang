package BaiTap.quan_li_sp;

import java.util.Scanner;

public class test7 {
    public static boolean checkName(String n, String f) {
        String a=n.substring(0,1);
        switch (f.toLowerCase()){
            case "class": return (!a.toLowerCase().equals(a) && !n.contains("_"));
            case "package": return (n.toLowerCase().equals(n) || n.contains("_")&&n.toLowerCase().equals(n) );
            case "field":
            case "method": return (a.toLowerCase().equals(a) && !n.contains("_"));
            default:
                return false;
        }

    }
    public static void main(String[] args) {
        String a="a_A";
        System.out.println(a.toLowerCase().equals(a));
        System.out.println(a.contains("_"));
        System.out.println(a.toLowerCase().equals(a) || a.contains("_"));
        System.out.println(a.toLowerCase().equals(a) && a.contains("_"));
        System.out.println(checkName("a_A","package"));
    }
}
//

