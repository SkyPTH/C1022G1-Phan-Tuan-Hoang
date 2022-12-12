package BaiTap.Day8.Resiable;

public class Square extends Shape implements Resiable {
    private double x;

    public Square() {
    }

    public Square(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double resize(double percent) {
        super.resize(percent);
        double area = Math.pow(this.getX(), 2) + Math.pow(this.getX(), 2) * percent / 100;
        return area;
    }

    @Override
    public String toString() {
        return "Square{" +
                "x=" + x +
                '}';
    }
}
