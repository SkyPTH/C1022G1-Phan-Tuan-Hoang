package repository;

import model.Employee;

public interface IRepository {
    void displayList();
    void addNew(Employee employee);
    void findbyName(String str);
}
