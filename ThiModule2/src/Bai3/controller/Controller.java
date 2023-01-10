package controller;

import Bai3.model.Model.SoTietKiem;
import Bai3.model.Regex;
import Bai3.service.IService;
import Bai3.service.Service;

import java.io.IOException;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) throws IOException {
        IService service = new Service();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("---Sổ tiết kiệm----\n" +
                    "1)Đăng ký sổ tiết kiệm\n" +
                    "2)Thoát");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    String idSTK = null;
                    String soTien = null;
                    String kyHan = null;
                    String laiSuat = null;
                    String idKH = null;
                    do {
                        System.out.println("Nhập mã sổ tiết kiệm");
                        idSTK = scanner.nextLine();
                    } while (!idSTK.matches(Regex.REGEX_IDSTK));

                    do {
                        System.out.println("Nhập số tiền");
                        soTien = scanner.nextLine();
                    } while (!soTien.matches(Regex.REGEX_SOTIEN));
                    do {
                        System.out.println("Nhập kỳ hạn");
                        kyHan = scanner.nextLine();
                    } while (!kyHan.matches(Regex.REGEX_KYHAN));
                    do {
                        System.out.println("Nhập lãi suất");
                        laiSuat = scanner.nextLine();
                    } while (!laiSuat.matches(Regex.REGEX_LAISUAT));
                    System.out.println("Nhập mã khách hàng");
                    idKH = scanner.nextLine();
                    SoTietKiem soTietKiem = new SoTietKiem(idSTK, soTien, kyHan, laiSuat, idKH);
                    service.dangkySTK(soTietKiem);

                    break;
                case 2:
                    System.exit(0);
            }
        } while (true);
    }
}
