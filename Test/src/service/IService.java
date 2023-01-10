package service;

import model.Employee;

public interface IService {
     void displayList();
     void addNew(Employee employee);
     void findbyName(String str);
}
