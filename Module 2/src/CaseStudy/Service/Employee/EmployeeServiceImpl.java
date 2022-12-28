package CaseStudy.Service.Employee;

import CaseStudy.Model.model.Person.Employee;
import CaseStudy.Model.model.Person.Person;
import CaseStudy.Model.repository.PersonRepository.EmployeeRepository.EmployeeeRepository;
import CaseStudy.Model.repository.PersonRepository.EmployeeRepository.IEmployeeRepository;

public class EmployeeServiceImpl implements IEmployeeService {
    private IEmployeeRepository employeeRepository=new EmployeeeRepository();

    @Override
    public void deleteEmployee(String id) {employeeRepository.deleteEmployee(id);
    }

    @Override
    public void editEmployee(String id,Employee employee) {employeeRepository.editEmployee(id,employee);

    }

    @Override
    public void displayList() {employeeRepository.displayList();

    }



    @Override
    public void addNew(Object obj){employeeRepository.addNew(obj);



    }


}
