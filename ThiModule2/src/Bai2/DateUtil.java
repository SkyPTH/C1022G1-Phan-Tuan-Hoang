package Bai2;

import java.util.Scanner;

public class DateUtil {
    public boolean isValidDate(String str) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập ngày");
        String date=scanner.nextLine();
        final String REGEX_QUALITY  ="^[0-2][0-9]/[0-1][0-9]/[0-9]{4}$";
//if(date.matches(REGEX_QUALITY)){throw InvalidFormatDateException;}
        return true;
    }
}
