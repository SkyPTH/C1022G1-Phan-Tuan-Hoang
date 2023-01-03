package CaseStudy.Controller.CustomController;

import CaseStudy.Model.model.Person.Customer;
import CaseStudy.Service.Customer.CustomerServiceImpl;
import CaseStudy.Service.Customer.ICustomerService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CustomerController {
    public static final ICustomerService customer = new CustomerServiceImpl();

    public static void main() throws IOException {
        do {
            System.out.println("------Customer Management-------");
            System.out.println("1.\tDisplay list customers");
            System.out.println("2.\tAdd new customer");
            System.out.println("3.\tEdit customer");
            System.out.println("4.\tReturn main menu");
            Scanner scanner = new Scanner(System.in);
            try{
                int choice2 = Integer.parseInt(scanner.nextLine());
            switch (choice2) {
                case 1:
                    customer.displayList();
                    break;
                case 2:
                    System.out.println("Enter customer id");
                    String id = scanner.nextLine();
                    if (customer.findbyID(id) == null) {
                        System.out.println("Enter name");
                        String name = scanner.nextLine();
                        System.out.println("Enter birthday");
                        String birth = scanner.nextLine();
                        System.out.println("Enter gender");
                        String gender = scanner.nextLine();
                        System.out.println("Enter citizen identification number");
                        String cmndNumber = scanner.nextLine();
                        System.out.println("Enter phone number");
                        String phoneNumber = scanner.nextLine();
                        System.out.println("Enter email");
                        String eMail = scanner.nextLine();
                        System.out.println("Enter type of customer");
                        String type = scanner.nextLine();
                        System.out.println("Enter address");
                        String address = scanner.nextLine();
                        Customer customer1 = new Customer(id, name, birth, gender, cmndNumber, phoneNumber, eMail, type, address);
                        customer.addNew(customer1);
                    } else {
                        System.err.println("Customer ID is already exist");
                        return;
                    }
                    break;
                case 3:
                    System.out.println("Enter customer id need to change");
                    String id1 = scanner.nextLine();
                    if(customer.findbyID(id1)!=null){
                    System.out.println("Enter name");
                    String name1 = scanner.nextLine();
                    System.out.println("Enter birth");
                    String birth1 = scanner.nextLine();
                    System.out.println("Enter gender");
                    String gender1 = scanner.nextLine();
                    System.out.println("Enter citizen identification number");
                    String cmndNumber1 = scanner.nextLine();
                    System.out.println("Enter phone number");
                    String phoneNumber1 = scanner.nextLine();
                    System.out.println("Enter email");
                    String eMail1 = scanner.nextLine();
                    System.out.println("Enter type of customer");
                    String type1 = scanner.nextLine();
                    System.out.println("Enter address");
                    String address1 = scanner.nextLine();
                    Customer customer2 = new Customer(id1, name1, birth1, gender1, cmndNumber1, phoneNumber1, eMail1, type1, address1);
                    customer.editCustomer(id1, customer2);} else {
                        System.err.println("Customer by this ID isnt exist");
                    return;
                    }
                    break;
                case 4:
                    return;
                default:
                    System.err.println("Enter valid number again");
            }} catch (NumberFormatException e){
                System.out.println("Not a number, try again");}
            catch (FileNotFoundException e){
                System.out.println("Problem with data path or file");
            }
        } while (true);
    }
}
