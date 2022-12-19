package BaiTap.Day12.Product.Model.repositoty;

import BaiTap.Day12.Product.Model.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductRepository implements IProductRepository{
    private static List<Product> productList = new ArrayList<>();
    static {
        Product product1 = new Product(1, "IphoneX", 5000000);
        Product product3 = new Product(3, "Iphone12", 12000000);
        Product product2 = new Product(2, "Iphone11", 8000000);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
    }


    public ProductRepository(){

    }

    @Override
    public void addProduct(Product product) {
        productList.add(product);
    }

    @Override
    public void displayProduct() {
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    @Override
    public void updateProduct(int id, Product product) {
        for (int i=0; i<productList.size();i++){
            if(productList.get(i).getId()==id){
                productList.set(i, product);
                break;
            }
        }
    }

    @Override
    public void removeProduct(int id) {
        for (int i=0;i<productList.size();i++){
            if(productList.get(i).getId()==id){
                productList.remove(productList.get(i));
            }
        }
    }

    @Override
    public void searchProduct(String name) {
        for (Product product : productList) {
            if(product.getName().equals(name)){
                System.out.println(product);
            }
        }
    }

    @Override
    public void sortAscending() {
        Collections.sort(productList);
    }

    @Override
    public void sortDescending() {
        Collections.sort(productList);
        Collections.reverse(Collections.singletonList(productList));

    }
    public void containSearch(String charSequence){
        for(Product product: productList){if(product.getName().contains(charSequence)==true){
            System.out.println("Sản phẩm bạn cần tìm là " +  product);
    }
}}}
