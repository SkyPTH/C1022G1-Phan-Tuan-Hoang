package BaiTap.Day18.readName.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class ReadNameCountry {
    public static void readNameCountryTest(String readPath) {
        try {
            File readFile = new File(readPath);
            BufferedReader br = new BufferedReader(new FileReader(readFile));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                System.out.println(arr[2]);
            }
        } catch (Exception e) {
            System.out.println("Lỗi");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        readNameCountryTest(str);
    }
}
