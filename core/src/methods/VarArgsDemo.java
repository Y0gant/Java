package src.methods;

public class VarArgsDemo {
    public static void main(String[] args) {
        VarArgsDemo Obj1 = new VarArgsDemo();
        System.out.println(Obj1.varAdd(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Obj1.showSt("java","spring","docker");
        Obj1.showSt("kubernetes","jenkins");

    }

    public int varAdd(int... n) {
        int sum = 0;
        for (int i : n)
            sum = sum + i;

        return sum;
    }

    public void showSt(String ... m ){
        for ( String l:m)
            System.out.println(l);
    }
}
