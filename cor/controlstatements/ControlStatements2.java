public class ControlStatements2 {
   
    public static void main(String[] args) {
        //For loop
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        // Java program to illustrate for loop.

		int sum = 0;

		// for loop begins
		// and runs till y <= 20
		for (int y = 1; y <= 20; y++) {
			sum = sum + y;
         }
         //then prints value of sum 
        System.out.println("Sum: " + sum);



// Java Program to implement
// Nested for loop
// Printing a 1 to 5 (5 times)
		// first loop
		for (int i = 1; i <= 5; i++) {
			// second loop
			for (int j = 1; j <= 5; j++) {
				System.out.print(j + " ");
			}
            // this act as s break that add a line for previous loop
			System.out.println(); 
		}

		// while loop
//initialization of a variable as counter
		int w =1;
//conditional statement in while loop 
		while (w<6) { 
			System.out.println("hello world");
		// updation expression that increments the counter variable
			w++;

			}
			

			int y = 1;
 sum=0;
			// Exit when y becomes greater than 10
			
		
	while (y <= 10) {
				// summing up y
				sum = sum + y;
				
				// Increment the value of y for
				// next iteration
				y++;
		}
		System.out.println("Summation: " + sum);
y=1;


// do while loop
do {
	//statement
	System.out.println(y);
	//updation
	y++;
}
//condition
while(y<=10);

// 2nd do while loop
int x = 1; sum=0;
System.out.println("2nd do while");
do {
	x = sum+x;
	sum++;
	
	System.out.println(x);
} while (sum<=20);

}
}