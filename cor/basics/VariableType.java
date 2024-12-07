public class VariableType {
    public int A; 
    public static Double D;

public static void main(String[] args) {
    long l = 1234566;
    VariableType.D = 123.56;
    VariableType Obj = new VariableType();
    Obj.A = 10;
    System.out.println(Obj.A + " this is an instance variable");
    System.out.println(l + " this is a local variable ");
    System.out.println(D + " this is a static variable");
}
}
