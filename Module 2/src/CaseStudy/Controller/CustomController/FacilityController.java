package CaseStudy.Controller.CustomController;

import CaseStudy.Controller.FuramaManager;
import CaseStudy.Model.model.Facility.Room;
import CaseStudy.Model.model.Facility.Villa;
import CaseStudy.Service.Facility.FacilityServiceImpl;
import CaseStudy.Service.Facility.IFacilityService;

import java.util.Scanner;

public class FacilityController {
    public static void main() {
        IFacilityService facilityService = new FacilityServiceImpl();
        do {
            System.out.println("------Facility Management-------");
            System.out.println("1\tDisplay list facility");
            System.out.println("2\tAdd new facility");
            System.out.println("3\tDisplay list facility maintenance");
            System.out.println("4\tReturn main menu");
            Scanner scanner = new Scanner(System.in);
            int choice3 = Integer.parseInt(scanner.nextLine());
            switch (choice3) {
                case 1:
                    facilityService.displayList();
                    break;
                case 2:
                    do {
                        System.out.println("1.\tAdd New Villa");
                        System.out.println("2.\tAdd New Room");
                        System.out.println("3.\tBack to menu");
                        int choice4 = Integer.parseInt(scanner.nextLine());
                        switch (choice4) {
                            case 1:
                                System.out.println("Nhập số căn");
                                String name = scanner.nextLine();
                                System.out.println("Nhập diện tích sử dụng");
                                String area = scanner.nextLine();
                                System.out.println("Nhập chi phí thuê");
                                String price = scanner.nextLine();
                                System.out.println("Nhập số lượng người tối đa");
                                String maxPeople = scanner.nextLine();
                                System.out.println("Nhập kiểu thuê");
                                String type = scanner.nextLine();
                                System.out.println("Nhập tiêu chuẩn phòng");
                                String quality = scanner.nextLine();
                                System.out.println("Nhập diện tích hồ bơi");
                                String poolArea = scanner.nextLine();
                                System.out.println("Nhập số tầng");
                                String floorNumber = scanner.nextLine();
                                Villa villa = new Villa(name, area, maxPeople, type, quality, poolArea, floorNumber, price);
                                facilityService.addVilla(villa);
                            case 2:

                                System.out.println("Nhập số căn");
                                String name1 = scanner.nextLine();
                                System.out.println("Nhập diện tích sử dụng");
                                String area1 = scanner.nextLine();
                                System.out.println("Nhập chi phí thuê");
                                String price1 = scanner.nextLine();
                                System.out.println("Nhập số lượng người tối đa");
                                String maxPeople1 = scanner.nextLine();
                                System.out.println("Nhập kiểu thuê");
                                String type1 = scanner.nextLine();
                                System.out.println("Nhập dịch vụ miễn phí");
                                String freeService = scanner.nextLine();
                                Room room = new Room(name1, area1, maxPeople1, type1, freeService, price1);
                                facilityService.addRoom(room);
                            case 3:
                                FuramaManager.displayMainMenu();
                        }
                    } while (true);

                case 3:
                    facilityService.displayMaintenanceList();
                    break;
                case 4:
                    FuramaManager.displayMainMenu();
                    break;
            }
        } while (true);
    }
}
