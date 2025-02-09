package core.oops.polymorphism;

@FunctionalInterface
interface Show {
    void show();
}

@FunctionalInterface
interface Add {
    void add(int a, int b);
}

@FunctionalInterface
interface Multiply {
    int multiply(int c, int d);
}

public class Interf1 {
    public static void main(String[] args) {
        Show sh = () -> System.out.println("Accessing Show method inside of a funtional interface using lambda expression");
        sh.show();

        Add ad = (a, b) -> System.out.println("Addition of a and b vars inside functional interface :" + (a + b));
        ad.add(23, 45);

        Multiply mp = (c, d) -> c * d;
        System.out.println("Multiplicaton :" + mp.multiply(24, 2));
    }
}
