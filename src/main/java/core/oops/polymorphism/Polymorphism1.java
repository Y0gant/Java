package core.oops.polymorphism;

//Polymorphism using Method overloading
public class Polymorphism1 {
    public static void main(String[] args) {
        Polymorphism1 obj = new Polymorphism1();
        obj.add(12, 16);
        obj.add(24.24d, 14.57d);
        obj.add(9200000000000000000L, 23372036854775807L);
        System.out.println(Long.MAX_VALUE);

    }

    //method for adding 2 integers
    public void add(int a, int b) {
        System.out.println("Adding " + a + " And " + b + " =" + (a + b));
    }

    //method for adding two doubles'
    public void add(double a, double b) {
        System.out.println("Adding " + a + " And " + b + " =" + (a + b));
    }

    //method for adding two longs'
    public void add(long a, long b) {
        System.out.println("Adding " + a + " And " + b + " =" + (a + b));
    }

}
