package CaseStudy.Model.repository.PersonRepository.EmployeeRepository;

import CaseStudy.Model.model.Person.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeeRepository implements IEmployeeRepository {
    private static List<Employee> employeeList=new ArrayList<>();
    static {
        employeeList.add(new Employee("1","Hoang","12/11/1996","Nam",
                "0123456789","0935181282","tuanhoang96dn@gmail.com","Đại học",
                "Sercurity","10000"));
        employeeList.add(new Employee("2","Quan","12/11/1997","Nam",
                "0123456780","0935181287","quanpro@gmail.com","Đại học",
                "CEO","3000"));
        employeeList.add(new Employee("2","Yua Mikami","12/11/2000","Nữ",
                "0123456710","0935181787","@gmail.com","Sau đại học",
                "Secretary","5000"));
    }

}
