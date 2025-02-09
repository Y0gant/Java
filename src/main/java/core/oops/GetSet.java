package core.oops;

public class GetSet {
    int a;
    int b;

    public static void main(String[] args) {
        GetSet Obj1 = new GetSet();
        Obj1.set(12, 13);
        System.out.println(Obj1.getSum());
    }

    //setter method for setting value
    public void set(int a, int b) {
        this.a = a;
        this.b = b;
    }

    //Getter method for getting that value
    public int getSum() {

        return a + b;
    }
}
