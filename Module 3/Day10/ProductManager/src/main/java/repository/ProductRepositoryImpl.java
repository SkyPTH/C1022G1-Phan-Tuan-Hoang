package repository;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IRepository {
    private static final List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Xe đạp", 1000, "Hàng mới", "Vingroup"));
        productList.add(new Product(2, "Xe máy", 2000, "Hàng cũ", "Honda"));
    }

    @Override
    public List<Product> displayList() {
        return productList;
    }

    @Override
    public void create(Product product) {
        product.setId(productList.size() + 1);
        productList.add(product);
    }

    @Override
    public void update(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if(product.getId()==productList.get(i).getId()){
                productList.set(i,product);
            }
        }

    }

    @Override
    public void delete(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if(product.getId()==productList.get(i).getId()){
                productList.remove(i);
            }
        }
    }
    @Override
    public Product findbyID(int id) {
        for (Product product : productList
        ) {
            if (product.getId() == id) {
                return product;
            }

        }
        return null;

    }

}