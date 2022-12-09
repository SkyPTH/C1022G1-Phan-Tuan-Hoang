package BaiTap.Day7.Point3D;

import java.util.Arrays;

public class Point3d extends Point2D{
    private float z;

    public Point3d() {
    }

    public Point3d(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public float [] setXYZ() {
        float arr3d[] = {this.getX(), this.getY(), z};
        return arr3d;
    }

    @Override
    public String toString() {
        return "Point3d{"  +
                "x=" + this.getX() +
                ", y=" + this.getX() +
                ", z=" + z+ "} "
                ;}
    }


