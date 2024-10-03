/*Problem statement

Write a program that takes a character as input and prints either 1, 0, or -1 according to the 
following rules.

1, if the character is an uppercase alphabet (A - Z)
0, if the character is a lowercase alphabet (a - z)
-1, if the character is not an alphabet

Constraints :

Input can be any character.

Constraints :

Input can be any character.

Input format :

The only line of input contains a single character.

Output format :

The only line of output prints eith1, 0 or -1(as applicable).
*/
import java.util.Scanner;
class Solution2 {
	
	public static void main(String args[]) {
		Scanner Sc = new Scanner(System.in);
		char ip = Sc.next().charAt(0);
		if (Character.isUpperCase(ip)){
			System.out.println("1");
		}
		else if (Character.isLowerCase(ip)){
			System.out.println("0");
		}
		else{
			System.out.println("-1");
		}
	// Alternate solution 
    if (ip >= 'A' && ip<= 'Z'){
        System.out.println("1");
    }
    else if (ip >= 'a' && ip<= 'z'){
        System.out.println("0");
    }
    else{
        System.out.println("-1");
    }

	}
}

