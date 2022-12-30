package CaseStudy.Controller;

import CaseStudy.Controller.CustomController.*;

import java.util.Scanner;
import java.util.regex.Pattern;

public class FuramaManager {
    public static void displayMainMenu() {

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("-------Furama Management--------");
            System.out.println("1.\tEmployee Management");
            System.out.println("2.\tCustomer Management");
            System.out.println("3.\tFacility Management ");
            System.out.println("4.\tBooking Management");
            System.out.println("5.\tPromotion Management");
            System.out.println("6.\tExit");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    EmployeeController.main();
                    break;
                case 2:
                    CustomerController.main();
                    break;
                case 3:
                    FacilityController.main();
                    break;
                case 4:
                    BookingController.main();
                    break;
                case 5:
                    PromotionController.main();
                    break;
                case 6:
                    System.exit(0);
            }
        } while (true);
    }

    public static void main(String[] args) {

        FuramaManager.displayMainMenu();
    }
}
