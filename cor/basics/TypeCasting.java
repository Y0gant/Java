public class TypeCasting {
    public static void main (String args []){
 //widening / automatic type casting
int i = 2147483647;
long l = i;
 l = l +1;
double d =l;
 System.out.println("value of int "+i);
 System.out.println("value of long "+l);
 System.out.println("value of double "+d);
// narrowing / explicit type casting
double d2= 25.123;
int i2= (int) d2;
byte b= (byte) i2;
System.out.println("value of double "+d2);
 System.out.println("value of integer "+i2);
 System.out.println("value of byte "+b);
}
   

}
