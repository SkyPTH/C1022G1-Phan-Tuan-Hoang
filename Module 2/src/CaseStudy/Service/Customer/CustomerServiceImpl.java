package CaseStudy.Service.Customer;

import CaseStudy.Model.model.Person.Customer;
import CaseStudy.Model.repository.PersonRepository.CustomerRepository.CustomerRepository;
import CaseStudy.Model.repository.PersonRepository.CustomerRepository.ICustomerRepository;

import java.io.IOException;

public class CustomerServiceImpl implements ICustomerService {
    private static final ICustomerRepository customerRepository=new CustomerRepository();
    @Override
    public void editCustomer(String id,Customer customer) throws IOException {customerRepository.editCustomer(id, customer);

    }

    @Override
    public Customer findbyID(String id) {
        return customerRepository.findbyID(id);
    }

    @Override
    public void displayList() throws IOException {customerRepository.displayList();

    }

    @Override
    public void addNew(Object obj) throws IOException {customerRepository.addNew(obj);

    }
}
