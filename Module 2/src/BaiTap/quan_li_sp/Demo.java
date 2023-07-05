package BaiTap.quan_li_sp;

public class Demo {
    //Cho phép 1 lớp định nghĩa ra nhiều phương thức cùng tên nhưng khác tham số truyền vào
    //Xảy ra trong cùng 1 class
    //Đa hình tại compile time
    //Ứng dụng khi phương thức có thể đc truyền các tham số có số lượng và kiểu dữ liệu khác nhau

    public void sum(int a, int b){
        System.out.println(a+b);
    }
    public void sum(int a, int b, int c){ //khác số lượng tham số
        System.out.println(a+b+c);
    } //khác số lượng tham số
    public void sum(double a, double b){ //khác kiểu dữ liệu tham số
        System.out.println(a+b);;
    }

    public static void main(String[] args) {
        Demo demo=new Demo();
        // Lựa chọn phương thức xảy ra tại thời điểm biên dịch dựa trên số lượng và kiểu đối số được truyền vào khi gọi phương thức
        demo.sum(1.1,2);
        demo.sum(1,3);
        demo.sum(1,2,3);
    }
}
