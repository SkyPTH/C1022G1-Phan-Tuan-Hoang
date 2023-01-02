package CaseStudy.Service.Employee;

import CaseStudy.Model.model.Person.Employee;
import CaseStudy.Model.model.Person.Person;
import CaseStudy.Model.repository.PersonRepository.EmployeeRepository.EmployeeeRepository;
import CaseStudy.Model.repository.PersonRepository.EmployeeRepository.IEmployeeRepository;

import java.io.IOException;

public class EmployeeServiceImpl implements IEmployeeService {
    private IEmployeeRepository employeeRepository=new EmployeeeRepository();

    @Override
    public void deleteEmployee(String id) throws IOException {employeeRepository.deleteEmployee(id);
    }

    @Override
    public void editEmployee(String id,Employee employee) throws IOException {employeeRepository.editEmployee(id,employee);

    }

    @Override
    public void displayList() throws IOException {employeeRepository.displayList();

    }



    @Override
    public void addNew(Object obj) throws IOException {employeeRepository.addNew(obj);



    }


}
