package BaiTap.Day19;

import java.util.Scanner;

public class ValidateClassName {
    public static final String REGEX_CLASSNAME="^(C|A|P)+[\\d]{4}+(G|H|I|K|L|M)$";

    public static void main(String[] args) {
        System.out.println("Nhập tên lớp học");
        Scanner scanner=new Scanner(System.in);
        String name= scanner.nextLine();
        System.out.println(name.matches(REGEX_CLASSNAME));
    }
}
