public class ControlStatements2 {
   
    public static void main(String[] args) {
        //For loop
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        // Java program to illustrate for loop.

		int sum = 0;

		// for loop begins
		// and runs till x <= 20
		for (int x = 1; x <= 20; x++) {
			sum = sum + x;
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
	}
}


	