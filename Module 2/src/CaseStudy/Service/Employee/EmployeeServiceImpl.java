package CaseStudy.Service.Employee;

import CaseStudy.Model.model.Person.Employee;
import CaseStudy.Model.model.Person.Person;
import CaseStudy.Model.repository.PersonRepository.EmployeeRepository.EmployeeeRepository;
import CaseStudy.Model.repository.PersonRepository.EmployeeRepository.IEmployeeRepository;

public class EmployeeServiceImpl implements IEmployeeService {
    private IEmployeeRepository employeeService=new EmployeeeRepository();

    @Override
    public void deleteEmployee(String id) {employeeService.deleteEmployee(id);
    }

    @Override
    public void editEmployee(String id,Employee employee) {employeeService.editEmployee(id,employee);

    }

    @Override
    public void displayList() {employeeService.displayList();

    }



    @Override
    public void addNew(Object obj){



    }


}
