package BaiTap.Day7.Cylinder;

class Test {
    public static void main(String[] args) {
        Circle circle1= new Circle(5,"blue");
        Cylinder cylinder2=new Cylinder(5,"red",8);
        System.out.println( circle1.toString());
        System.out.println(cylinder2.toString());
        System.out.println("Diện tích circle 1: "+circle1.getArea());
        System.out.println("Thể tích cylynder 1: "+cylinder2.getVolumm());



    }
}