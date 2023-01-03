package CaseStudy.Controller.CustomController;

import CaseStudy.Model.model.Person.Employee;
import CaseStudy.Service.Employee.EmployeeServiceImpl;
import CaseStudy.Service.Employee.IEmployeeService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class EmployeeController {
    public static final IEmployeeService employee = new EmployeeServiceImpl();

    public static void main() throws IOException {
        do {
            System.out.println("------Employee Management-------");
            System.out.println("1\tDisplay list employees");
            System.out.println("2\tAdd new employee");
            System.out.println("3\tDelete employee");
            System.out.println("4.\tExit");
            Scanner scanner = new Scanner(System.in);
            try {
            int choice1 = Integer.parseInt(scanner.nextLine());
            switch (choice1) {
                case 1:
                    employee.displayList();
                    break;
                case 2:
                    System.out.println("Enter employee id");
                    String id = scanner.nextLine();
                    if (employee.findbyId(id) == null) {
                        System.out.println("Enter name");
                        String name = scanner.nextLine();
                        System.out.println("Enter birthday");
                        String birth = scanner.nextLine();
                        System.out.println("Enter gender");
                        String gender = scanner.nextLine();
                        System.out.println("Enter citizen identification number ");
                        String cmndNumber = scanner.nextLine();
                        System.out.println("Enter phone number");
                        String phoneNumber = scanner.nextLine();
                        System.out.println("Enter email");
                        String eMail = scanner.nextLine();
                        System.out.println("Enter level");
                        String level = scanner.nextLine();
                        System.out.println("Enter position");
                        String position = scanner.nextLine();
                        System.out.println("Enter salary");
                        String salary = scanner.nextLine();
                        Employee employee1 = new Employee(id, name, birth, gender, cmndNumber, phoneNumber, eMail, level, position, salary);
                        employee.addNew(employee1);
                    } else {
                        System.err.println("Employee ID is already exist");
                        return;
                    }
                    break;
                case 3:
                    System.out.println("Enter ID number of employee need to remove");
                    String idRemove = scanner.nextLine();
                    if (employee.findbyId(idRemove) != null) {
                        employee.deleteEmployee(idRemove);
                    } else {
                        System.err.println("This ID isnt exist");
                        return;
                    }
                    break;
                case 4:
                    return;
                default:
                    System.err.println("Valid number is 1 to 4");
            }
            } catch (NumberFormatException e){
                System.err.println("Not a number, try again");
            }
            catch (FileNotFoundException e){
                System.out.println("Problem with data path or file");}
        } while (true);
    }
}
