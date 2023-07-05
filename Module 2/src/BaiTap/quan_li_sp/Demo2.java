package BaiTap.quan_li_sp;

public class Demo2 implements IDemo2{
    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        demo2.print();  // Đối tượng gọi đc default method mà không cần triển khai lại
//        demo2.display();  // Đối tượng không gọi đc static method
        IDemo2.display(); // gọi static  method thông qua interface
    }
}
