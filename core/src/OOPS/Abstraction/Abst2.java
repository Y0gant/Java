package src.OOPS.Abstraction;

abstract class Shape {
    String color;

    Shape(String color) {
        System.out.println("Shape constructor called ");
        this.color = color;
    }

    //Abstract methods
    public abstract String toString();

    abstract double area();

    public String getColor() {
        return color;
    }
}

class Circle extends Shape {
    double radius;

    Circle(double radius, String Color) {
        super(Color);
        System.out.println("Circle constructor called");
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "The color of circle is " + super.getColor() + " and Area is :" + area();
    }

    @Override
    double area() {
        return Math.PI * Math.pow(radius, 2);
    }
}

class Rectangle extends Shape {
    double length;
    double breath;

    Rectangle(double length, double breath, String color) {
        super(color);
        this.length = length;
        this.breath = breath;
        System.out.println("Rectangle constructor called");
    }

    @Override
    public String toString() {
        return "The color of Rectangle is " + getColor() + " and area is :" + area();
    }

    @Override
    double area() {
        return length * breath;
    }
}

public class Abst2 {
    public static void main(String[] args) {
        Shape obj = new Circle(5, "Blue");
        Shape obj2 = new Rectangle(23, 12, "crimson");
        System.out.println(obj);
        System.out.println(obj2);
        obj.area();
    }
}
