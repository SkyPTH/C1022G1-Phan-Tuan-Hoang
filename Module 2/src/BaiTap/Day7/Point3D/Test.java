package BaiTap.Day7.Point3D;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Point2D point2D=new Point2D(3,5);
        Point3d point3d=new Point3d(3,5,7);
        System.out.println(point2D.toString());
        System.out.println(Arrays.toString(point2D.setXY()));
        System.out.println(point3d.toString());
        System.out.println(Arrays.toString(point3d.setXYZ()));
    }
}
