package BaiTap.Day6.AccessModified;

public class TestCirle {
    public TestCirle() {
    }

    public static void main(String[] args) {
        Circle circle = new Circle(5.0, "red");
        System.out.println(circle.getRadius());
        System.out.println(circle.getArea());
    }
}

