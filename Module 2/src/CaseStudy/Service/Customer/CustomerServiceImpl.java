package CaseStudy.Service.Customer;

import CaseStudy.Model.model.Person.Customer;
import CaseStudy.Model.repository.PersonRepository.CustomerRepository.CustomerRepository;
import CaseStudy.Model.repository.PersonRepository.CustomerRepository.ICustomerRepository;

public class CustomerServiceImpl implements ICustomerService {
    private static final ICustomerRepository customerRepository=new CustomerRepository();
    @Override
    public void editCustomer(String id,Customer customer) {customerRepository.editCustomer(id, customer);

    }

    @Override
    public void displayList() {customerRepository.displayList();

    }

    @Override
    public void addNew(Object obj) {customerRepository.addNew(obj);

    }
}
