package core.methods;

// instance and static method example
public class Methd3 {
    //static method Addn2
    public static int Addn2(int d, int f) {
        int g = (d + f) * 2;
        return g;
    }

    public static void main(String[] args) {
        Methd3 Md = new Methd3();
        int s = Md.Addn1(50, 80);
        int e = Methd3.Addn2(2, 4);
        System.out.println(s);
        System.out.println(e);


    }

    //Instance method Addn1
    public int Addn1(int a, int b) {
        int c = a + b;
        return c;
    }
}
