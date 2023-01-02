package CaseStudy.Service.Employee;

import CaseStudy.Model.model.Person.Employee;
import CaseStudy.Service.IService;

import java.io.IOException;

public interface IEmployeeService extends IService {
    void deleteEmployee(String id) throws IOException;
    void editEmployee(String id, Employee employee) throws IOException;


}
