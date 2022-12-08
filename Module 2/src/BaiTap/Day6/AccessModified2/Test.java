package BaiTap.Day6.AccessModified2;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();

        student.setClasses("C10");
        System.out.println(student.getClasses());
        student.setName("Hoang");
        System.out.println(student.getName());
    }
}
