package controller;

import model.Employee;
import service.IService;
import service.Service;

import java.util.Scanner;

public class EmployeeController {
    private static final IService service = new Service();

    public static void main(String[] args) {
        do {
            System.out.println("----Quản lý công nhân------\n" +
                    "1)Hiển thị danh sách công nhân\n" +
                    "2)Thêm mới công nhân\n" +
                    "3)Tìm gần đúng theo tên");
            Scanner scanner = new Scanner(System.in);
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    service.displayList();
                    break;
                case 2:
                    System.out.println("Nhập id");
                    String id = scanner.nextLine();
                    System.out.println("Nhập tên");
                    String name = scanner.nextLine();
                    System.out.println("Nhập email");
                    String eMail = scanner.nextLine();
                    System.out.println("Nhập address");
                    String address = scanner.nextLine();
                    service.addNew(new Employee(id, name, eMail, address));
                 break;
                case 3:
                    System.out.println("Nhập từ có trong tên công nhân");
                    String str=scanner.nextLine();
                    service.findbyName(str);
            }

        } while (true);
    }
}
