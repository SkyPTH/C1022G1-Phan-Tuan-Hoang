package CaseStudy.Controller.CustomController;

import CaseStudy.Controller.FuramaManager;
import CaseStudy.Service.Customer.CustomerServiceImpl;
import CaseStudy.Service.Customer.ICustomerService;

import java.util.Scanner;

public class CustomerController { public static final ICustomerService customer=new CustomerServiceImpl();
    public static void main() {
        do {
            System.out.println("------Customer Management-------");
            System.out.println("1.\tDisplay list customers");
            System.out.println("2.\tAdd new customer");
            System.out.println("3.\tEdit customer");
            System.out.println("4.\tReturn main menu");
            Scanner scanner = new Scanner(System.in);
            int choice2 = Integer.parseInt(scanner.nextLine());
            switch (choice2) {
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
