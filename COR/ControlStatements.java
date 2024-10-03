import java.util.Scanner;

public class ControlStatements {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        int a = Sc.nextInt();

        if (a>10){
            System.out.println("true");
        }
        if (a>=100) {
            System.out.println("true");
        } else {
            System.out.println("False");
        }
if (a <=20){
System.out.println("a smaller than 20.");
if (a<= 10) {
    System.out.println("also smaller than 10.");
    
}
}
if (a<=20) {
    System.out.println("under 20");
    
} else if(a <= 30 && a>20) {
    System.out.println("under 30");
    
}
else if (a<=40 && a>30){
    System.out.println("under 40");

}
   else{
    System.out.println("more than 40");
   }    
        Sc.close();
    }

}
