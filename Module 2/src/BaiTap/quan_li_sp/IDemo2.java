package BaiTap.quan_li_sp;

public interface IDemo2 {
    default void print() {
        System.out.println("Hello");
    }

    static void display() {
        System.out.println("Chào");
    }
}
