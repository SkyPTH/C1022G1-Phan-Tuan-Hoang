package CaseStudy.Controller.CustomController;

import CaseStudy.Controller.FuramaManager;

import java.util.Scanner;

public class BookingController {
    public static void main() {
        do {
            System.out.println("------Booking Management-------");
            System.out.println("1.\tAdd new booking");
            System.out.println("2.\tDisplay list booking");
            System.out.println("3.\tReturn main menu");
            Scanner scanner = new Scanner(System.in);
            int choice4 = Integer.parseInt(scanner.nextLine());
            switch (choice4) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    FuramaManager.displayMainMenu();
                    break;
            }

        } while (true);
    }
}
