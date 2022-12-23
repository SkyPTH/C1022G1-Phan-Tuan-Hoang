package BaiTap.Day12.Product.Controller;

import BaiTap.Day12.Product.Model.model.Product;
import BaiTap.Day12.Product.Model.service.IProductService;
import BaiTap.Day12.Product.Model.service.ProductService;

import java.util.Scanner;

public class ProductManager {
    private static final IProductService productService = new ProductService();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("-----Quản Lí Sản Phẩm-----");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa thông tin sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Sắp xếp sản phẩm tăng dần");
            System.out.println("7. Sắp xếp sản phẩm giảm dần");
            System.out.println("8. Tìm gần đúng sản phẩm theo tên");
            System.out.println("9. Thoát");
            System.out.println("Chọn số để thực hiện các bước trên");
            int selection = Integer.parseInt(scanner.nextLine());
            switch (selection) {
                case 1:
                    System.out.print("Nhâp id sản phẩm: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nhập tên sản phẩm: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập giá sản phẩm: ");
                    int price = Integer.parseInt(scanner.nextLine());
                    productService.addProduct(new Product(id, name, price));
                    break;
                case 2:
                    System.out.print("Nhập id sản phẩm cần sửa: ");
                    int fixId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nhập id mới của sản phẩm: ");
                    id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nhập tên mới của sản phẩm: ");
                    name = scanner.nextLine();
                    System.out.print("Nhập giá mới của sản phẩm: ");
                    price = Integer.parseInt(scanner.nextLine());
                    productService.updateProduct(fixId, new Product(id, name, price));
                    break;
                case 3:
                    System.out.print("Nhập id sản phẩm: ");
                    id = Integer.parseInt(scanner.nextLine());
                    productService.removeProduct(id);
                    break;
                case 4:
                    productService.displayProduct();
                    System.out.println("_______________________");
                    productService.displayProduct();
                    break;
                case 5:
                    System.out.println("Nhập tên sản phẩm: ");
                    name = scanner.nextLine();
                    productService.searchProduct(name);
                    break;
                case 6:
                    productService.sortAscending();
                    break;
                case 7:
                    productService.sortDescending();
                    break;
                case 8:
                    System.out.println("Nhập chuỗi ký tự trong tên sản phẩm cần tìm");
                    String charSequence=scanner.nextLine();
                    productService.containSearch(charSequence);
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Mời bạn nhập lại");
            }
        } while (true);
    }
}