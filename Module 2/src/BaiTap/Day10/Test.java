package BaiTap.Day10;

public class Test {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Nguyễn Văn A");
        Student student2 = new Student(2, "Nguyễn Văn B");
        Student student3 = new Student(3, "Nguyễn Văn C");
        Student student4 = new Student(4, "Nguyễn Văn D");
        Student student5 = new Student(5, "Nguyễn Văn E");
        Student student6 = new Student(6, "Nguyễn Văn F");

        MyList<Student> studentMyArrayList = new MyList<>();
        MyList<Student> newMyArrayList = new MyList<>();

        studentMyArrayList.add(student1);
        studentMyArrayList.add(student2);
        studentMyArrayList.add(student3);
        studentMyArrayList.add(student4);
        studentMyArrayList.add(student5);
        studentMyArrayList.add(student6, 2);
        studentMyArrayList.clear();
        System.out.println(studentMyArrayList.size());
    }

    public static class Student {
        private int id;
        private String name;

        public Student() {
        }

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

