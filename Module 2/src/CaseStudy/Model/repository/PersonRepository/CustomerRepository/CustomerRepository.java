package CaseStudy.Model.repository.PersonRepository.CustomerRepository;

import CaseStudy.Model.model.Person.Customer;
import CaseStudy.utils.ReadFile.CustomerReadFile;
import CaseStudy.utils.WriteFile.CustomerWriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {

    private static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer("1", "trọng", "12/1/1999",
                "Nam", "01111111111", "0914131441", "trongpro@gmail.com", "Diamond", "Da Nang"));
        customerList.add(new Customer("2", "Ngân", "12/1/1998",
                "Nữ", "0333333333", "0914131448", "ngan@gmail.com", "Member", "Nha Trang"));
        customerList.add(new Customer("3", "Thăng", "12/1/1992",
                "Nam", "0222222222", "0914131445", "thang@gmail.com", "Gold", "Hà Nội"));

    }

    @Override
    public void addNew(Object obj) throws IOException {
        Customer customer1 = (Customer) obj;
        customerList = CustomerReadFile.customerReadFile();
        boolean flag = true;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId().equals((customer1).getId())) {
                System.out.println("Id khách hàng này đã có");
                flag = false;
                break;
            }
        }
        if (flag) {
            customerList.add(customer1);
        }
        CustomerWriteFile.customerWrite(customerList);
    }

    @Override
    public void displayList() throws IOException {
        customerList = CustomerReadFile.customerReadFile();
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }

    @Override
    public void editCustomer(String id, Customer customer) throws IOException {
        customerList = CustomerReadFile.customerReadFile();
        boolean flag = false;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId().equals(id)) {
                customerList.set(i, customer);
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Không có khách hàng có id này");
        }
        CustomerWriteFile.customerWrite(customerList);
    }


}
