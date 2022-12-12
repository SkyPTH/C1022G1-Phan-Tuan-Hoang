package BaiTap.Day8.Colorable;

public class Shape implements Colorable {
    private boolean isFilled;

    public Shape() {
    }

    public Shape(boolean isFilled) {
        this.isFilled = isFilled;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void getArea() {

    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "isFilled=" + isFilled +
                '}';
    }

    @Override
    public void howtoColour() {

    }



}
