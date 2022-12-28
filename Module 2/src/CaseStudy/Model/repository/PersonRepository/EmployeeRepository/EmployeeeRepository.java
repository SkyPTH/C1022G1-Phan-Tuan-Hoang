package CaseStudy.Model.repository.PersonRepository.EmployeeRepository;

import CaseStudy.Model.model.Person.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeeRepository implements IEmployeeRepository {

    private static final List<Employee> employeeList = new ArrayList<>();

    static {
        employeeList.add(new Employee("1", "Hoang", "12/11/1996", "Nam",
                "0123456789", "0935181282", "tuanhoang96dn@gmail.com", "Đại học",
                "Sercurity", "10000"));
        employeeList.add(new Employee("2", "Quan", "12/11/1997", "Nam",
                "0123456780", "0935181287", "quanpro@gmail.com", "Đại học",
                "CEO", "3000"));
        employeeList.add(new Employee("2", "Yua Mikami", "12/11/2000", "Nữ",
                "0123456710", "0935181787", "@gmail.com", "Sau đại học",
                "Secretary", "5000"));
    }


    @Override
    public void displayList() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

    }


    @Override
    public void addNew(Object obj) {
        Employee employee = (Employee) obj;
        employeeList.add(employee);

    }

    @Override
    public void deleteEmployee(String id) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(id)) {
                employeeList.remove(i);
            }
        }

    }

    @Override
    public void editEmployee(String id, Employee employee) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(id)) {
                employeeList.set(i, employee);
            }
        }

    }


}
