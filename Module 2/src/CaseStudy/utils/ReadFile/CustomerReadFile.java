package CaseStudy.utils.ReadFile;

import CaseStudy.Model.model.Person.Customer;
import CaseStudy.Model.model.Person.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerReadFile {
    public static List<Employee> customerReadFile() throws IOException {
        List<Customer> customerList = new ArrayList<>();
        FileReader fileReader = new FileReader("src/CaseStudy/utils/data/customer.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        String[] temp;
        Customer customer;
        while ((line = bufferedReader.readLine()) != null) {
            temp = line.split(",");
            String id = temp[0];
            String name = temp[1];
            String birth = temp[2];
            String sex = temp[3];
            String cmndNumber = temp[4];
            String phoneNumber = temp[5];
            String eMail = temp[6];
            String type = temp[7];
            String address = temp[8];
            customer = new Customer(id, name, birth, sex, cmndNumber, phoneNumber, eMail, type,address);
            customerList.add(customer);
        }
        bufferedReader.close();
        return customerReadFile();
    }
}
