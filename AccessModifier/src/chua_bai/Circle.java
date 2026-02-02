package chua_bai;

public class Circle {
    private  int id;
    private double radius;
    private static int flag = 1;
    private static double PI = 3.14;
    public static double maxRadius = 0;
    public static double totalS = 0;

    public Circle(double radius) {
        this.id = flag;
        this.radius = radius;
        if(radius > maxRadius) {
            maxRadius = radius;
        }
        flag++;
        double s = this.getS();
        totalS += s;
    }

    public double getS(){
        double s = this.radius * this.radius * Circle.PI;
        return s;
    }

    public double getC() {
        double c = this.radius * 1/2 * Circle.PI;
        return c;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

}
