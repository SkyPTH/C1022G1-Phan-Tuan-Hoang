package BaiTap.Day6.AccessModified2;

public class Student {

    private String name;
    private String classes;

    public Student(String name, String classes) {
        this.name = name;
        this.classes = classes;
    }

    public Student() {
        this("john", "C02");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }


}