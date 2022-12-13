package BaiTap.Day8.Resiable;

public abstract class Shape implements Resiable {
    public Shape() {
    }
    public abstract void getArea();
    @Override
    public double resize(double percent) {
        return percent;
    }
}
