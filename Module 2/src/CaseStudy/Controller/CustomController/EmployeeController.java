package CaseStudy.Controller.CustomController;

import CaseStudy.Controller.FuramaManager;

import java.util.Scanner;

public class EmployeeController {
    public static void main() {
        do {
            System.out.println("------Employee Management-------");
            System.out.println("1\tDisplay list employees");
            System.out.println("2\tAdd new employee");
            System.out.println("3\tDelete employee");
            System.out.println("4.\tBooking Management");
            System.out.println("5.\tPromotion Management");
            System.out.println("6.\tExit");
            Scanner scanner = new Scanner(System.in);
            int choice1 = Integer.parseInt(scanner.nextLine());
            switch (choice1) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    FuramaManager.displayMainMenu();
                    break;
            }
        } while(true) ;
    }
}
