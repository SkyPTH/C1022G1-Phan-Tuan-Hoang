package CaseStudy.Service.Employee;

import CaseStudy.Model.model.Person.Employee;
import CaseStudy.Service.IService;

public interface IEmployeeService extends IService {
    void deleteEmployee(String id);
    void editEmployee(String id, Employee employee);


}
