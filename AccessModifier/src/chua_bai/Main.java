package chua_bai;

public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle( 5.65);
        Circle circle02 = new Circle( 3);
        Circle circle03 = new Circle(3.4);
        Circle c4 = new Circle(2);
        System.out.println(circle.getId());
        System.out.println("S1: " + circle.getS() + ", C1: " + circle.getC());
        System.out.println(circle02.getId());
        System.out.println("S2: " + circle02.getS() + ", C2: " + circle02.getC());
        System.out.println(circle03.getId());
        System.out.println(c4.getId());
        System.out.println("Max radius: " + Circle.maxRadius);
        Circle c6 = new Circle(6);
        System.out.println("Max radius: " + Circle.maxRadius);
        System.out.println("Total S: " + circle.totalS);
    }
}
