package BaiTap.quan_li_sp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
//Comparable override phương thức compareTo
// áp dụng cho 1 tiêu chí
// xác định quy tắc so sánh mặc định
// được triển khai trong lớp đối tượng
    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }
}
// Comparable override phương thức compareTo
// tạo ra một bộ quy tắc so sánh riêng.
// áp dụng cho nhiều tiêu chí
// là một interface độc lập
class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        // Sắp xếp theo tên
        int nameComparison = s1.getName().compareTo(s2.getName());
        if (nameComparison != 0) {
            return nameComparison;
        }

        // Nếu tên bằng nhau, sắp xếp theo tuổi tăng dần
        return Integer.compare(s1.getAge(), s2.getAge());
    }
}


