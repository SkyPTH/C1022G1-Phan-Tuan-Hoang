package BaiTap.Day8.Colorable;

public class Test {
    public static void main(String[] args) {
        Shape [] shapes=new Shape[3];

        shapes[0]=new Square(true,5);
        shapes[1]=new Rectangle(true, 10,5);
        shapes[0].getArea();
        shapes[0].howtoColour();
        shapes[1].getArea();
        shapes[1].howtoColour();

    }
}
