package BaiTap.Day7.Point3D;

import java.util.Arrays;

public class Point2D {
    private float x;
    private float y;
    public  Point2D(){}

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }


    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y+"}"
                ;};

    public float[] setXY(){
        float arr2d[]={this.x,this.y};
        return arr2d;
    };
}
