package core.oops.abstraction;

interface Shape2 {
    void calculateArea();
}

class ICircle implements Shape2 {
    private final double iRadius;

    public ICircle(double iRadius) {
        this.iRadius = iRadius;
    }

    @Override
    public void calculateArea() {
        double iArea = Math.PI * Math.pow(iRadius, 2);
        System.out.printf("The area of circle is %.2f %n", iArea);
    }
}

class IRectangle implements Shape2 {
    private final int length;
    private final int breath;

    public IRectangle(int length, int breath) {
        this.breath = breath;
        this.length = length;
    }

    @Override
    public void calculateArea() {
        int iArea = length * breath;
        System.out.println("The area of rectangle is :" + iArea);
    }

}

public class Abst5 {
    public static void main(String[] args) {
        IRectangle r = new IRectangle(31, 12);
        ICircle cr = new ICircle(8);
        r.calculateArea();
        cr.calculateArea();
    }
}


