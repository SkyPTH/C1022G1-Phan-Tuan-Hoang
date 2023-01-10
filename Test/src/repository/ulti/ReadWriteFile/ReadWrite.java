package repository.ulti.ReadWriteFile;

import model.Employee;

import java.io.*;

public class ReadWrite {
     void readFile() throws IOException {
    FileReader fileReader=new FileReader("D:\\codegym\\C1022G1-Phan-Tuan-Hoang\\Test\\src\\repository\\ulti\\data\\Employee.csv");
    BufferedReader bufferedReader=new BufferedReader(fileReader);
    String[] temp;
    int line;
    Employee employee;
    while (bufferedReader.readLine()!=null){

    }
    bufferedReader.close();


    }
    void writeFIle() throws IOException {
         FileWriter fileWriter=new FileWriter("D:\\codegym\\C1022G1-Phan-Tuan-Hoang\\Test\\src\\repository\\ulti\\data\\Employee.csv");
         BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);

    }
}
