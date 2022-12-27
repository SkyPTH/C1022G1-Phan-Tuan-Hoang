package CaseStudy.Controller.CustomController;

import CaseStudy.Controller.FuramaManager;

import java.util.Scanner;

public class FacilityController {
    public static void main() {
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
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    FuramaManager.displayMainMenu();
                    break;
            }
        } while (true);
    }
}
