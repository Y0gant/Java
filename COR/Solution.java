/*Write a program to calculate the total salary of a person. The user has to enter 
the basic salary (an integer) and the grade (an uppercase character),
 and depending upon which the total salary is calculated as -

totalSalary = basic + hra + da + allow – pf

where :

hra   = 20% of basic
da    = 50% of basic
allow = 1700 if grade = ‘A’
allow = 1500 if grade = ‘B’
allow = 1300 if grade = ‘C' or any other character
pf    = 11% of basic.

Round off the total salary to the nearest integer and then print the integral part only.

Note: Try finding out a function on the internet to do so

*/
import java.util.* ;
class Solution {
	
	public static void main(String args[]) {
		Scanner Sc = new Scanner(System.in);
		int BS= Sc.nextInt();
		char grade = Sc.next().charAt(0);
		float hra = 0.2f * BS;
		float da = 0.5f * BS;
		float pf = 0.11f * BS;
if (grade>='A' && grade<='Z') {
	int allow = switch(grade){
	case('A'):
	yield 1700;
	case ('B'):
	yield 1500;
	default:
	yield 1300;
	};
float totalSalary = BS + hra + da + allow - pf;
long integralSalary = Math.round(totalSalary);
System.out.println(integralSalary);

} 
		
		
	}
}