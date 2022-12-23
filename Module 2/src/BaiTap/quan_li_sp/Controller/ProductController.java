package BaiTap.quan_li_sp.Controller;

import BaiTap.Day12.Product.Model.repositoty.IProductRepository;
import BaiTap.Day12.Product.Model.repositoty.ProductRepository;
import BaiTap.quan_li_sp.Model.model.Product;
import BaiTap.quan_li_sp.Model.repository.Repository;
import BaiTap.quan_li_sp.service.IService;
import BaiTap.quan_li_sp.service.Service;

import java.util.Scanner;

public class ProductController {
public static Service repository=new Service();

    public static void main(String[] args) {
        do {
            System.out.println("-----------Quản lí sản phẩm---------\n" +
                    "1)Thêm sản phẩm \n" +
                    "2)Hiển thị danh sách sản phẩm\n" +
                    "3)Tìm sản phẩm bằng từ khóa\n"
            );
            Scanner scanner = new Scanner(System.in);
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.println("Nhập id");
                    int id=Integer.parseInt(scanner.nextLine());
                    System.out.println("Nhập tên sản phẩm");
                    String name=scanner.nextLine();
                    System.out.println("Nhập hãng sản xuất");
                    String manufactured=scanner.nextLine();
                    System.out.println("Nhập giá");
                    int price=Integer.parseInt(scanner.nextLine());
                    System.out.println("Nhập mô tả");
                    String description=scanner.nextLine();
                    Product product=new Product(id,name,manufactured,price,description);
                    repository.addProduct(product);
                    break;
                case 2:
                    repository.displayProduct();
                    break;
                case 3:
                    System.out.println("Nhập từ khóa có liên quan đến sản phẩm");
                    String keyword=scanner.nextLine();
                    repository.findProduct(keyword);
                    break;
            }

        } while (true);
    }

}
