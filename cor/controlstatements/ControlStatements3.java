/*Jump statements
*continue 
*break 
*return keyword  
 */

public class ControlStatements3 {
    public static void main (String args []){
        // Continue statement inside for loop
        for (int i=0;i<=15;i++){
            //skips no 10 & 12 
            if(i==10 || i==12){
            continue;
        }
            System.out.print(i+ " ");
        }
System.out.println(" ");
// Continue Statement inside while loop
int count = 20;
while (count>=0) { 
   
  
    if (count==10 || count==15) {
        count--;
        //if 10 & 15 iteration encountered count is
        // decremented and control goes to starting of loop
        continue;
    }
   
    System.out.print(count+" ");
    count--;
}

// continue statement inside do-while loop
System.out.println("");
int f=0;
do{
if (f==10||f==12||f==16) {
    f+=2;
    continue;
}
System.out.print(f+" ");
f+=2;
}
while (f<=20);
System.out.println("");
// continue statement inside nested for loop

for (int g = 1; g <= 4; g++) {
    for (int h = 1; h <= 5; h++) {
        if (h==2||g==3) {
            continue;
        }
        System.out.println(g+"*"+h);
    }
    
}
//Break Statement
for (int g = 1; g <= 7; g++) {
if (g==5){
break;   }
System.out.println(g);

}

//break statement inside while loop
int wh=0;
while ( wh<=10){
    System.out.println(wh);
    wh++;
    if (wh==8) {
        break;
    }
}

//break statement in do while
int dw=0;
do {
    System.out.println(dw);
    dw++;
    if(dw==7){
        break;
    }
} while (dw<=10);

//break in switch case
int snum= 10;
switch (snum) {
    case 8 :
        System.out.println("eight");
        break;
        case 10: 
        System.out.println("ten");
        break;
    default:
   System.out.println("infinite");
}

//break statement inside label statement
for (int lnum=1;lnum<3; lnum++){
first:
{
second:
{
    System.out.println("before third");
    third:
    if(lnum==2){
    break second;
    
    }
    System.out.println("before second");
}
System.out.println("first");

}
}
//return statements

// this statement returns the value of the function/method RR
// by calling the object 
System.out.println(new ControlStatements3().RR(6.5,7.5));

//calling the method demoSum with two parameters

new ControlStatements3().demoSum(14, 8);
//no return key word used
//Return statement not required (but can be used) for methods with return type void.
// We can use “return;” which means not return anything. 

    }
    //Outside main method 
    //method 1 
    //RR method that has a data type double so it should return double
    // it returns the double sumR thats holds the value of the sum of two double values
    double RR( double a, double b){
        double sumR = a+b;
        return sumR;
   }
//method 2 
// has void return type so return keyword is not used 
void demoSum(int a, int b)
{
    int sum = 0;
    sum = (a + b) / 10;
    System.out.println(sum);

    // No return statement in this method
}
   
}