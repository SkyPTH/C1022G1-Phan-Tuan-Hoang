package BaiTap.quan_li_sp;

public class Demo3 {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World";
        //Dùng toán tử +  không chỉ trên các đối tượng String
        // mà còn trên các đối tượng khác như char và các đối tượng được chuyển đổi thành chuỗi.
        //tham số có thể null
        String result = str1 + " " + str2;
        // dùng phương thức concat()chỉ hoạt động trên các đối tượng String không null.
        // Nó tạo ra một chuỗi mới và không làm thay đổi các chuỗi gốc.
        String result2 = str1.concat(" ").concat(str2);
        // dùng phương thức format() của lớp String:
        //tham số không null dưới dạng String
        String result3 = String.format("%s %s", str1, str2);
        // dùng phương thức join() của lớp String (Java 8+) tham số dưới dạng CharSequence, không đc phép null:
        String result4 = String.join(" ", str1, str2);
        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }
}
