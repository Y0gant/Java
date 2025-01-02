package src.methods;

/**
 * example of methods with different access modifiers
 * 1. Default
 * 2. public
 * 3. Protected
 * 4. Private
 */
public class Methd4 {
    void Number1() {
        System.out.println("this is a method with default access modifier");
    }

    public void Number2() {
        System.out.println("this is a method with public access modifier");
    }

    protected void Number3() {
        System.out.println("this is a method with Protected access modifier");
    }

    private void Number4() {
        System.out.println("this is a method with Private access modifier");
    }

    public static void main(String[] args) {
        Methd4 obj1 = new Methd4();
        obj1.Number1();
        obj1.Number2();
        obj1.Number3();
        obj1.Number4();

    }
}
