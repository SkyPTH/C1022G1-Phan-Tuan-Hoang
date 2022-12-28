package CaseStudy.Model.repository.PersonRepository.EmployeeRepository;

import CaseStudy.Model.model.Person.Employee;
import CaseStudy.Model.repository.IRepository;

public interface IEmployeeRepository extends IRepository {

    void deleteEmployee(String id);
    void editEmployee(String id,Employee employee);
}
