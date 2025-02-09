package core.oops;

//Main class
public class ClsAndObjs {
    private int a;
    private int b;

    public static void main(String[] args) {
        // Object creation
        //Object (obj) will have its own values
        ClsAndObjs obj = new ClsAndObjs();
        obj.a = 24;
        obj.b = 12;
        obj.sum();
        obj.sub();


        //obj2 will have its own different values
        ClsAndObjs obj2 = new ClsAndObjs();
        obj2.a = 45;
        obj2.b = 17;
        obj2.sum();
        obj2.sub();


    }

    //Method 1
    public void sum() {
        System.out.println("Addition :" + (a + b));
    }

    //Method 2
    public void sub() {
        System.out.println("Subtraction :" + (a - b));
    }
}
