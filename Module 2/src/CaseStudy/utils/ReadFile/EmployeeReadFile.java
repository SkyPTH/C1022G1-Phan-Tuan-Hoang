package CaseStudy.utils.ReadFile;

import CaseStudy.Model.model.Person.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeReadFile {
    public static List<Employee> employeeReadFile() throws IOException {
        List<Employee> employeeList = new ArrayList<>();
        FileReader fileReader = new FileReader("src/CaseStudy/utils/data/employee.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        String[] temp;
        Employee employee;
        while ((line = bufferedReader.readLine()) != null) {
            temp = line.split(",");
            String id = temp[0];
            String name = temp[1];
            String birth = temp[2];
            String gender = temp[3];
            String cmndNumber = temp[4];
            String phoneNumber = temp[5];
            String eMail = temp[6];
            String level = temp[7];
            String position = temp[8];
            String wage = temp[9];
            employee = new Employee(id, name, birth, gender, cmndNumber, phoneNumber, eMail, level, position, wage);
            employeeList.add(employee);
        }
        bufferedReader.close();
        return employeeReadFile();
    }
}
