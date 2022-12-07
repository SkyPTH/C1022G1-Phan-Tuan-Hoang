package BaiTap.Day5;

import java.util.Scanner;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getA() {
        return a;
    }
    public void setA(double a) {
        this.a = a;
    }
    public double getB() {
        return b;
    }
    public void setB(double b) {
        this.b = b;
    }
    public double getC() {
        return c;
    }
    public void setC(double c) {
        this.c = c;
    }
    public double getDiscriminant() {
        return getB() * getB() - 4 * getA() * getC();
    }
    public double getRoot1() {
        return (-getB() + Math.sqrt(getB() * getB() - 4 * getA() * getC())) / (2 * getA());
    }
    public double getRoot2() {
        return (-getB() - Math.sqrt(getB() * getB() - 4 * getA() * getC())) / (2 * getA());
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập a");
        double a = scanner.nextDouble();
        System.out.println("Nhập b");
        double b = scanner.nextDouble();
        System.out.println("Nhập c");
        double c = scanner.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        if (quadraticEquation.getDiscriminant() >= 0) {
            System.out.println("Nghiệm thứ nhất là: " + quadraticEquation.getRoot1());
            System.out.println("Nghiệm thứ hai là: " + quadraticEquation.getRoot2());
        } else {
            if (quadraticEquation.getDiscriminant() == 0) {
                System.out.println("Nghiệm kép là: " + quadraticEquation.getRoot1());
            } else {
                System.out.println("Pt vô nghiệm");
            }
        }
    }
}

