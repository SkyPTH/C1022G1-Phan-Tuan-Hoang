package CaseStudy.Service.Customer;

import CaseStudy.Model.model.Person.Customer;
import CaseStudy.Service.IService;

public interface ICustomerService extends IService {
    void editCustomer(String id, Customer customer);
}
