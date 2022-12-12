package BaiTap.Day8.Colorable;

public class Square extends Shape implements Colorable {
    private double x;

    public Square(double x) {
        this.x = x;
    }

    public Square() { getArea();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public Square(boolean isFilled, double x) {
        super(isFilled);
        this.x = x;
    }


    public void getArea() {
        System.out.println("Diện tích hình vuông là: "+ Math.pow(this.getX(), 2));
    }

    @Override
    public void howtoColour() {
        super.howtoColour();
        if (this.isFilled()==true){
            System.out.println("Colour all 4 side");
    }
}}
