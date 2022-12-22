package BaiTap.Day18.CopyFile;

import java.io.*;
import java.util.Scanner;

public class CopyFile {
    public static void copyReadTest(String fileReadPath, String fileWritePath) {
        try {
            File fileRead = new File(fileReadPath);
            File fileWriter = new File(fileWritePath);
            BufferedReader br = new BufferedReader(new FileReader(fileRead));
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileWriter));
            String line = "";
            int count = 0;
            while ((line = br.readLine()) != null) {
                bw.append(line + "\n");
                count += line.length();
            }
            System.out.println("số ký tự trong file là " + count);
            br.close();
            bw.close();
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi file đọc không tìm thấy");
        } catch (IOException e) {
            System.out.println("File ghi k tồn tại");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập đường dẫn file đọc");
        String readPath = scanner.nextLine();
        System.out.println("Nhập đường dẫn file ghi");
        String writePath = scanner.nextLine();
        CopyFile.copyReadTest(readPath, writePath);

    }
}
