package BaiTap.Day18.readName.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

public class ReadNameCountry {
    public static void readNameCountryTest(String readPath) {
//        List<>
        try {
            File readFile = new File(readPath);
            BufferedReader br = new BufferedReader(new FileReader(readFile));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");

                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("Lỗi");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập link");
        String str = scanner.nextLine();
        readNameCountryTest(str);
    }
}
