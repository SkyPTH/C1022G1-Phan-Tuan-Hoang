package CaseStudy.utils.WriteFile;

import CaseStudy.Model.model.Person.Employee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EmployeeWriteFile {

    public static final String FILE_PATH = "D:\\codegym\\C1022G1-Phan-Tuan-Hoang\\Module 2\\src\\CaseStudy\\utils\\data\\employee.csv";

    public static void employeeWriteFile(List<Employee> employeeList) throws IOException {
        FileWriter fileWriter = new FileWriter(FILE_PATH);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Employee employee : employeeList) {
            bufferedWriter.write(employee.getId() + "," + employee.getName() + "," + employee.getBirth() + ","
                    + employee.getGender() + "," + employee.getCmndNumber() + "," + employee.getPhoneNumber() + ","
                    + employee.geteMail() + "," + employee.getLevel() + "," + employee.getPosition() + "," + employee.getWage());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}
