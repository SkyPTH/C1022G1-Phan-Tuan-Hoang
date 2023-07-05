package BaiTap.Day12.presentation;

public class Person {
    String name;
    int age;

    // Constructor phải trùng tên với class,
    // có thể không tham số (constructor mặc định đc tạo ra khi không có bất kỳ constructor nào đc định nghĩa)
    // và không có kiểu trả về
    public Person() {
        name = "John Doe";
        age = 30;
    }

    // Constructor với tham số
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
// overload khi phương thức constructor trùng tên nhưng khác tham số
    public Person(int age) {
        this.age = age;
    }
// Constructor được gọi tự động khi một đối tượng mới của lớp được tạo ra bằng từ khóa "new"
    public static void main(String[] args) {
        Person person=new Person();
    }
}
