package BaiTap.Day19;

import java.util.Scanner;

public class ValidatePhoneNumber {
    public static final String REGEX_PHONENUMBER="^[(][\\d]{2}[)][-][(][0][\\d]{9}[)]$";

    public static void main(String[] args) {
        System.out.println("Nhập số điện thoại");
        Scanner scanner=new Scanner(System.in);
String phone=scanner.nextLine();
        System.out.println(phone.matches(REGEX_PHONENUMBER));
    }

}
