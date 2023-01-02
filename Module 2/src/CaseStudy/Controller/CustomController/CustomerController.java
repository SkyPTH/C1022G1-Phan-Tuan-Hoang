package CaseStudy.Controller.CustomController;

import CaseStudy.Controller.FuramaManager;
import CaseStudy.Model.model.Person.Customer;
import CaseStudy.Model.repository.PersonRepository.CustomerRepository.CustomerRepository;
import CaseStudy.Service.Customer.CustomerServiceImpl;
import CaseStudy.Service.Customer.ICustomerService;

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
            int choice2 = Integer.parseInt(scanner.nextLine());
            switch (choice2) {
                case 1:
                    customer.displayList();
                    break;
                case 2:
                    System.out.println("Nhập mã khách hàng");
                    String id=scanner.nextLine();
                    System.out.println("Nhập tên");
                    String name=scanner.nextLine();
                    System.out.println("Nhập ngày tháng năm sinh");
                    String birth=scanner.nextLine();
                    System.out.println("Nhập giới tính");
                    String gender=scanner.nextLine();
                    System.out.println("Nhập số CMND");
                    String cmndNumber=scanner.nextLine();
                    System.out.println("Nhập sđt");
                    String phoneNumber=scanner.nextLine();
                    System.out.println("Nhập email");
                    String eMail=scanner.nextLine();
                    System.out.println("Nhập loại khách");
                    String type=scanner.nextLine();
                    System.out.println("Nhập địa chỉ");
                    String address=scanner.nextLine();
                    Customer customer1=new Customer(id,name,birth,gender,cmndNumber,phoneNumber,eMail,type,address);
                    customer.addNew(customer1);
                    break;
                case 3:
                    System.out.println("Nhập ID khách hàng cần sửa");
                    String id1=scanner.nextLine();
                    System.out.println("Nhập tên");
                    String name1=scanner.nextLine();
                    System.out.println("Nhập ngày tháng năm sinh");
                    String birth1=scanner.nextLine();
                    System.out.println("Nhập giới tính");
                    String gender1=scanner.nextLine();
                    System.out.println("Nhập số CMND");
                    String cmndNumber1=scanner.nextLine();
                    System.out.println("Nhập sđt");
                    String phoneNumber1=scanner.nextLine();
                    System.out.println("Nhập email");
                    String eMail1=scanner.nextLine();
                    System.out.println("Nhập loại khách");
                    String type1=scanner.nextLine();
                    System.out.println("Nhập địa chỉ");
                    String address1=scanner.nextLine();
                    Customer customer2=new Customer(id1,name1,birth1,gender1,cmndNumber1,phoneNumber1,eMail1,type1,address1);
                    customer.editCustomer(id1,customer2);
                    break;
                case 4:
                    FuramaManager.displayMainMenu();
                    break;
            }
        } while (true);
    }
}
