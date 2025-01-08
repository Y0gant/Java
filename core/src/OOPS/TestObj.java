package src.OOPS;
//object creation and class instantiated using Class.forName() Method

public class TestObj {
    public static void main(String[] args) {
        try {
            TestObj Obj = (TestObj) Class.forName("src.OOPS.TestObj").newInstance();
            Obj.Print();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    public void Print() {
        System.out.println("Object created using Class.forName()method");
    }
}

