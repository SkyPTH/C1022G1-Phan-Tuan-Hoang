package CaseStudy.Controller.CustomController;

import CaseStudy.Controller.FuramaManager;

import java.io.IOException;
import java.util.Scanner;

public class PromotionController {
    public static void main() throws IOException {
        do {
            System.out.println("------Promotion Management-------");
            System.out.println("1.\tDisplay list customers use service");
            System.out.println("2.\tDisplay list customers get voucher");
            System.out.println("3.\tReturn main menu");
            Scanner scanner = new Scanner(System.in);
            int choice5 = Integer.parseInt(scanner.nextLine());
            switch (choice5) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    return;
            }
        } while (true);
    }
}
