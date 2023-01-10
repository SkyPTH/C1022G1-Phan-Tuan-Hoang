package service;

import model.Employee;
import repository.IRepository;
import repository.Repository;

public class Service implements IService {
    private static IRepository repository = new Repository();

    @Override
    public void displayList() {
        repository.displayList();

    }

    @Override
    public void addNew(Employee employee) {
        repository.addNew(employee);

    }

    @Override
    public void findbyName(String str) {
        repository.findbyName(str);
    }
}
