package BaiTap.Day8.Colorable;

public class Rectangle extends Shape implements Colorable {
    private double length;
    private double width;

    public Rectangle() { getArea();
    }

    public Rectangle(double a, double b) {
        this.length = a;
        this.width = b;
    }

    public Rectangle(boolean isFilled, double length, double width) {
        super(isFilled);
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    public void getArea(){
        System.out.println("Diện tích hình chữ nhật là: "+ this.width*this.length);}

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }

    @Override
    public void howtoColour() {
        super.howtoColour();
        if (isFilled()==true){
        System.out.println("Rectangle is colourable ");}
    }
}
