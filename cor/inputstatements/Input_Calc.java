
import java.util.Scanner;
public class Input_Calc {
public static void main(String[] args) {
    /*calculator using nested if else statement */
    Scanner sc = new Scanner(System.in);
    System.out.println("enter1:");
    double a =sc.nextDouble();
    System.out.println("enter no2 :");
    double b=sc.nextDouble();
    System.out.println("choose operator:");
    String c =sc.next();
                        if ("+".equals(c) ) {
                double d = a+b ;
                System.out.println("sum of a and b is :"+d);
            
                 } else if ("-".equals(c)) {
                         double d = a-b ;
                            System.out.println("diff of a and b is :"+d);
                 }
    else if ("*".equals(c)) {
            double d = a*b ;
                            System.out.println("multiple of a and b is :"+d);
        }
         else  if ("/".equals(c)) {
               double d = a/b ;
                System.out.println("division of a and b is :"+d);

            } else {
                System.out.println("invalid operator");
            }
            sc.close();
        }
    }
                
    

        
    
    
