package src.OOPS.abstraction;

interface Display {
    void displayData();
}

class Impl implements Display {

    @Override
    public void displayData() {
        System.out.println("Inside Interface method");
    }
}

public class Abst4 {
    public static void main(String[] args) {
        Display s1 = new Impl();
        s1.displayData();
    }
}
