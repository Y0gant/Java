/*Problem statement

You have been given a number 'N'. Your task is to find the sum of all even numbers from 1 to 'N' (both inclusive).

Example :

Given 'N' : 6
Sum of all even numbers till 'N' will be : 2 + 4 + 6 = 12
*/

import java.util.* ;

public class Solution3 {

    public static void main(String args[])

    {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long sum = evenSumTillN(N);

        System.out.println(sum);
sc.close();
    }

    public static long evenSumTillN(int n) 

    {   long sum=0;

        // Write your code here.

        for( int i=2 ;i<=n ;i++ ){

            if(i%2!=0){

                continue;

            }

            sum = sum+i;

        }

        return sum;

    }
   
}
