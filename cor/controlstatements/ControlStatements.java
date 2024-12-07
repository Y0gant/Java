import java.util.Scanner;

public class ControlStatements {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        int a = Sc.nextInt();


        // If statement
        if (a>10){
            System.out.println("true");
        }
        
        
        // If else statement
        if (a>=100) {
            System.out.println("true");
        } else {
            System.out.println("False");
        }


        //nested if statement
if (a <=20){
System.out.println("a smaller than 20.");
if (a<= 10) {
    System.out.println("also smaller than 10.");
    
}
}


// if else if ladder
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
   
   
//Switch case statement
switch (a) {
    case 12 : 
    System.out.println("12");    
        break;
    case 13:
    System.out.println("13");    
        break;
    default: System.out.println("none");


// enhanced switch case / rule switch
switch (a) {
    case 14-> System.out.println("14");
    case 15-> System.out.println("15");
    case 16-> System.out.println("16");
    case 17,18,19,20,21-> {System.out.println("17");
    System.out.println("18");
    System.out.println("19");
    System.out.println("20");
    System.out.println("21");

}
    default -> System.out.println("n");
        
} 
       
}

/*  switch case with yeild (It returns values from a switch branch only. 
We don’t need a break after yield as it automatically terminates the switch expression.)*/ 


int itemCode = Sc.nextInt();
/*here we can see that the yeild values are allocated to variable "text"
where if value of variable itemcode is 001 it assign the respective yeild value to 
variable text.*/

@SuppressWarnings("resource")
String text = switch (itemCode) {
    case 001 : 
        yield "It's a laptop!";
    case 002 :
        yield "It's a desktop!";        
    case 003 :
        yield "It's a mobile phone!";
    default :
        throw new IllegalArgumentException(itemCode + "is an unknown device!");
}; 
  System.out.println(text);
        Sc.close();
    }

}
