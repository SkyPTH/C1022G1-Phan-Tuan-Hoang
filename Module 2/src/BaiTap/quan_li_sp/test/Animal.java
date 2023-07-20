package BaiTap.quan_li_sp.test;

// Abstract Class
abstract class Animal {
    //thuộc tính như class bình thường
    public int a;
    // phương thức Abstract
    public abstract void sound();

    // phương thức thường
    public void sleep() {
        System.out.println("Sleeping...");
    }
    //tạo đc constructor
    public Animal() {
    }
}
