package BaiTap.quan_li_sp.Model.repository;

import BaiTap.quan_li_sp.Model.model.Product;
import BaiTap.quan_li_sp.Model.repository.IRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Repository implements IRepository {
    public static List<Product> productList = new ArrayList<>();
    static final String filePath="D:\\codegym\\C1022G1-Phan-Tuan-Hoang\\Module 2\\src\\BaiTap\\quan_li_sp\\Model\\repository\\product.dat";
    public static void writeProduct(List<BaiTap.quan_li_sp.Model.model.Product> productList){
        try{
            FileOutputStream fileOutputStream=new FileOutputStream(filePath);
            ObjectOutputStream objectOutputStreamn=new ObjectOutputStream(fileOutputStream);
            objectOutputStreamn.writeObject(productList);
            objectOutputStreamn.close();
        } catch (FileNotFoundException e){e.printStackTrace();} catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Product> readProduct(){
        try {
            FileInputStream fileInputStream=new FileInputStream(filePath);
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            List<Product> productList1= (List<Product>)objectInputStream.readObject();
            return productList1;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    static {
        Product product1 = new Product(1, "Iphone 4", "Apple", 4000, "Hàng cũ");
        Product product2 = new Product(2, "Iphone 6", "Apple", 6000, "Hàng mới");
        Product product3 = new Product(3, "Poco F3", "Xiaomi", 8000, "Hàng đã qua sửa chữa");
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
    }

    public void addProduct(Product product) {
        productList.add(product);
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
                    || productList.get(i).getDescription().equals(keyword))
            {

                System.out.println(productList.get(i).toString());
            }
        }
    }


}
