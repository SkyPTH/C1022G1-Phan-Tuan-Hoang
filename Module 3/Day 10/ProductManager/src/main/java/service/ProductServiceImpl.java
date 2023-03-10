package service;

import model.Product;
import repository.IRepository;
import repository.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements IService {
    IRepository repository = new ProductRepositoryImpl();

    @Override
    public List<Product> displayList() {
        return repository.displayList();
    }

    @Override
    public void create(Product product) {
        repository.create(product);
    }

    @Override
    public void update(Product product) {
        repository.update(product);
    }

    @Override
    public void delete(Product product) {
        repository.delete(product);
    }

    @Override
    public Product findByID(int id) {
        return repository.findByID(id);
    }
}
