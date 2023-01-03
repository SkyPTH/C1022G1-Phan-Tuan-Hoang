package CaseStudy.Model.repository.PersonRepository.CustomerRepository;

import CaseStudy.Model.model.Person.Customer;
import CaseStudy.Model.repository.IRepository;

import java.io.IOException;

public interface ICustomerRepository extends IRepository {
    void editCustomer(String id, Customer customer) throws IOException;
    Customer findbyID(String id);
}
