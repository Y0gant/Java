package core.oops;

enum Colors {
    Red(10), Green(20), Blue(30), Yellow(40), Violet(50), Black(60);
    int n;

    Colors(int n) {
        this.n = n;
    }

    public int getValue() {
        return n;
    }
}

public class Enums3 {
    public static void main(String[] args) {
        Colors[] cc = Colors.values();
        for (Colors n : cc) System.out.println(n + " : " + n.getValue());
    }
}
