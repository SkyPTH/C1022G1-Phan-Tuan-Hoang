package CaseStudy.utils.WriteFile;

import CaseStudy.Model.model.Person.Customer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CustomerWriteFile {
    public static void customerWrite(List<Customer> customerList) throws IOException {
        FileWriter fileWriter = new FileWriter("src/CaseStudy/utils/data/customer.csv", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Customer customer : customerList) {
            bufferedWriter.write(customer.getId() + "," + customer.getName() + "," + customer.getBirth() + "," + customer.getBirth() + ","
                    + customer.getGender() + "," + customer.getCmndNumber() + "," + customer.getPhoneNumber() + "," + customer.geteMail() + ","
                    + customer.getType() + "," + customer.getAddress() + "\n");
        }
        bufferedWriter.close();
    }
}
