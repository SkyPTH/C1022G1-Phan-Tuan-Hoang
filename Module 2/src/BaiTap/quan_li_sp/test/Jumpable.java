package BaiTap.quan_li_sp.test;

public interface Jumpable {
    // Abstract method
    void jump();
    //Thuộc tính phải là hằng số
    public String a="";

    // Java 8 hỗ trợ default method có nội dung trong interface
    default void run() {
        System.out.println("Running...");
    }
    //không tạo đc constructor
}
