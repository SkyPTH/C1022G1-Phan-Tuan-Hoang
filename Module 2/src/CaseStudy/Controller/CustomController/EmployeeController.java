package CaseStudy.Controller.CustomController;

import BaiTap.quan_li_sp.Model.repository.Repository;
import CaseStudy.Controller.FuramaManager;
import CaseStudy.Model.model.Person.Employee;
import CaseStudy.Service.Employee.EmployeeServiceImpl;
import CaseStudy.Service.Employee.IEmployeeService;

import java.util.Scanner;

public class EmployeeController {
    public static final IEmployeeService employee=new EmployeeServiceImpl();
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
                    employee.displayList();
                    break;
                case 2:
                    System.out.println("Nhập mã nhân viên");
                    String id=scanner.nextLine();
                    System.out.println("Nhập tên");
                    String name=scanner.nextLine();
                    System.out.println("Nhập ngày tháng năm sinh");
                    String birth=scanner.nextLine();
                    System.out.println("Nhập giới tính");
                    String sex=scanner.nextLine();
                    System.out.println("Nhập số CMND");
                    String cmndNumber=scanner.nextLine();
                    System.out.println("Nhập sđt");
                    String phoneNumber=scanner.nextLine();
                    System.out.println("Nhập email");
                    String eMail=scanner.nextLine();
                    System.out.println("Nhập trình độ");
                    String level=scanner.nextLine();
                    System.out.println("Nhập vị trí");
                    String position=scanner.nextLine();
                    System.out.println("Nhập lương");
                    String wage=scanner.nextLine();
                    Employee employee1=new Employee(id,name,birth,sex,cmndNumber,phoneNumber,eMail,level,position,wage);
                    employee.addNew(employee1);
                    break;
                case 3:
                    System.out.println("Nhập ID của nhân viên cần xóa");
                    String idRemove=scanner.nextLine();
                    employee.deleteEmployee(idRemove);
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
