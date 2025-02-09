package core.oops.inheritance;

/**
 * Create a Shape class with a method display().
 * Extend it into Circle, Rectangle, and Triangle classes, each having their own specific method.
 * Demonstrate accessing the common and specific methods of all subclasses.
 */

class Shape {
    void display() {
        System.out.println("Shape :");
    }
}

class Circle extends Shape {
    private final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    void display() {
        System.out.println("---------------");
        System.out.println("Circle :");
        System.out.println("Radius : " + radius);
        System.out.println("Area : " + getArea());
    }
}

class Rectangle extends Shape {
    private final int length;
    private final int breath;

    Rectangle(int length, int breath) {
        this.breath = breath;
        this.length = length;
    }

    public int getArea() {
        return length * breath;
    }

    @Override
    void display() {
        System.out.println("---------------");
        System.out.println("Rectangle :");
        System.out.println("Length : " + length);
        System.out.println("Breath : " + breath);
        System.out.println("Area : " + getArea());
    }
}

public class Inherit4 {
    public static void main(String[] args) {
        Rectangle rec = new Rectangle(23, 10);
        Circle cr = new Circle(12);
        Shape rec2 = new Shape();
        rec2.display();
        rec.display();
        cr.display();

    }
}
