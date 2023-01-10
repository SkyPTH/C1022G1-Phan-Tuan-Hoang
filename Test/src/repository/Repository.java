package repository;

import model.Employee;

import java.util.ArrayList;
import java.util.List;

public class Repository implements IRepository {
    private static List<Employee> employeeList = new ArrayList<>();
    static {
        Employee employee=new Employee("1","hoang","asd","asd");
        Employee employee1=new Employee("2","quan","asd","asd");
employeeList.add(employee);
employeeList.add(employee1);
    }

    @Override
    public void displayList() {
        for (int i = 0; i < employeeList.size(); i++) {
            System.out.println(employeeList.get(i));
        }


    }

    @Override
    public void addNew(Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public void findbyName(String str) {
        for (int k = 0; k < employeeList.size(); k++) {
            if (employeeList.get(k).getName().contains(str)){
                System.out.println(employeeList.get(k));
            }
        }
    }
}
