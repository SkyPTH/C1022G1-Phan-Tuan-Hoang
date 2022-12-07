package BaiTap.Day5;

 public class Fan {
    final int slow = 1;
    final int medium = 2;
    final int fast = 3;
    private int speed;
    private boolean on;
    private double radius;
    private String color;
    public Fan(int speed,boolean on, double radius, String color){
         this.speed = speed;
         this.on = on;
         this.radius = radius;
         this.color = color;
    }
    public Fan(){
        this(1, false,5,"blue");
    }

     public int getSlow() {
         return slow;
     }
     public int getMedium() {
         return medium;
     }
     public int getFast() {
         return fast;
     }
     public int getSpeed() {
         return speed;
     }

     public boolean isOn() {
         return on;
     }
     public double getRadius() {
         return radius;
     }
     public String getColor() {
         return color;
     }
     public void setSpeed(int speed) {
         this.speed = speed;
     }
     public void setOn(boolean on) {
         this.on = on;
     }
     public void setRadius(double radius) {
         this.radius = radius;
     }
     public void setColor(String color) {
         this.color = color;
     }
     public String toString() {
         String str = "";
         if (this.isOn()==true) {
             str += "Fan is on" + "\n";
             str += "Speed: " + this.speed + "\n";
         }
         else {
             str += "Fan is off" + "\n";
         }
         str += "Radius: " + this.radius + "\n";
         str += "Color: " + this.color + "\n";
         return str;
     }

     public static void main(String[] args) {
         Fan fan1 = new Fan();
         fan1.setSpeed(fan1.getFast());
         fan1.setRadius(10);
         fan1.setColor("yellow");
         fan1.setOn(true);
         System.out.println(fan1.toString());
         Fan fan2 = new Fan();
         fan2.setSpeed(fan1.getMedium());
         fan2.setRadius(fan2.getRadius());
         fan2.setColor(fan2.getColor());
         fan2.setOn(false);
         System.out.println(fan2.toString());
     }

}
