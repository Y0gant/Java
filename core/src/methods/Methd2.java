package src.methods;

public class Methd2 {
    public static int count = 0;

    Methd2() {
        count++;
    }

    int getCount() {
        return count;
    }

    public int m1() {
        System.out.println("Inside method m1");
        m2();
        return 1;
    }

    public void m2() {
        System.out.println("m2 called inside of m1");
    }

    public static void main(String[] args) {
        Methd2 obj1 = new Methd2();
        System.out.println("Before method m1 is called");
        int i = obj1.m1();
        System.out.println("Control returns to m1:" + i);

        int s = obj1.getCount();
        System.out.println("Number of instances created of this class"+s);
        
    }
}
