package BaiTap.Day8.Resiable;

public class Rectangle extends Shape implements Resiable {
    private double a;
    private double b;
    double area = this.getA() * this.getB();

    public Rectangle() {
    }

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double resize(double percent) {
        super.resize(percent);
        double area = this.getA() * this.getB() + this.getA() * this.getB() * percent / 100;
        return area;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }


    @Override
    public String toString() {
        return "Rectangle{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    public double area() {
        return this.getA() * this.getB();
    }

//    public void resize(){
//        Random random=new Random();
//        a=this.a*(random.nextInt(100)+1);
//        b=this.b*(random.nextInt(100)+1);

}

