package BaiTap.quan_li_sp.Model.repository;

import BaiTap.quan_li_sp.Model.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Repository implements IRepository {
    static final String filePath = "D:\\codegym\\C1022G1-Phan-Tuan-Hoang\\Module 2\\src\\BaiTap\\quan_li_sp\\Model\\repository\\product.dat";
    public static List<Product> productList = new ArrayList<>();

    static {
        Product product1 = new Product(1, "Iphone 4", "Apple", 4000, "Hàng cũ");
        Product product2 = new Product(2, "Iphone 6", "Apple", 6000, "Hàng mới");
        Product product3 = new Product(3, "Poco F3", "Xiaomi", 8000, "Hàng đã qua sửa chữa");
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
    }

    FileOutputStream fos = null;
    ObjectOutputStream oos = null;

    public static void writeProduct(List<BaiTap.quan_li_sp.Model.model.Product> productList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(filePath);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(productList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Product> readProduct() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        List<Product> productList = null;
        try {
            fis = new FileInputStream(filePath);
            ois = new ObjectInputStream(fis);
            productList = (List<Product>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
        Repository.writeProduct(productList);
    }

    public void displayProduct() {
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public void findProduct(String keyword) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equals(keyword)
                    || Integer.toString(productList.get(i).getPrice()).equals(keyword)
                    || Integer.toString(productList.get(i).getId()).equals(keyword)
                    || productList.get(i).getManufactured().equals(keyword)
                    || productList.get(i).getDescription().equals(keyword)) {
                System.out.println(productList.get(i).toString());
            }
        }
    }


}
