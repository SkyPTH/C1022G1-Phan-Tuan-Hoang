package CaseStudy.Model.repository.PersonRepository.EmployeeRepository;

import CaseStudy.Model.model.Person.Employee;
import CaseStudy.Model.repository.IRepository;

import java.io.IOException;

public interface IEmployeeRepository extends IRepository {

    void deleteEmployee(String id) throws IOException;
    void editEmployee(String id,Employee employee) throws IOException;
}
