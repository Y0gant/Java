package src.methods;


public class Methd3 {
    public int Addn1(int a ,int b){
        int c = a+b;
        return c;
    }
    public static int Addn2(int d, int f){
        int g= (d + f )* 2;
       return g;
    }

    public static void main(String[] args) {
        Methd3 Md = new Methd3();
       int s = Md.Addn1(50,80);
         int e= Methd3.Addn2(2,4);
         System.out.println(s);
        System.out.println(e);


    }
}
