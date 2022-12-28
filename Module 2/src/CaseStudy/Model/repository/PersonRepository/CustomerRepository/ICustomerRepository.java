package CaseStudy.Model.repository.PersonRepository.CustomerRepository;

import CaseStudy.Model.model.Person.Customer;
import CaseStudy.Model.repository.IRepository;

public interface ICustomerRepository extends IRepository {
    void editCustomer(String id, Customer customer);
}
