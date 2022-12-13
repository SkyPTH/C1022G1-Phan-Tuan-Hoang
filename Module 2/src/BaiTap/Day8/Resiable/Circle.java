package BaiTap.Day8.Resiable;

public class Circle extends Shape  {
    private double r;

    public Circle() {
    }

    public Circle(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

//    public void resize(){
//        Random random=new Random();
//        r=this.r*(random.nextInt(100)+1);
//    }

    @Override
    public double resize(double percent) {
        super.resize(percent);
        double area = Math.pow(this.getR(), 2) * Math.PI + Math.pow(this.getR(), 2) * Math.PI * percent / 100;
        return area;

    }

    @Override
    public String toString() {
        return "Circle{" +
                "r=" + r +
                '}';
    }
}
