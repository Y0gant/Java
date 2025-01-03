package src.array;

/**
 * This is an example of array-
 * Declaration  *  types
 * Initialization * types
 * Changing Elements
 * Getting array length
 * printing elements
 */
public class ArrayDemo {
    public static void main(String[] args) {
        int[] arr;  //Declaration of array "arr"
        arr = new int[5]; //Initialize with length 5 //allocating memory


        //combining both statements
        int[] arr2 = new int[8]; //initialized array with length 8


        //static initialization
        int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};//inline initialization with length of array=9
        int[] arr4 = new int[]{1, 2, 3, 4, 5}; //initialize array using new keyword


        //changing elements in array
        arr4[0] = 11;//changed the value of index 0 to 11
        arr4[2] = 13;//changed the value of index 2 to 13


        //getting array length
        int l = arr3.length;
        System.out.println("length of array arr3 is: " + l);

        //printing elements
        //using index of array
        System.out.println(arr3[0]);
        System.out.println(arr3[1]);
        System.out.println(arr3[2]);

        //using for loop to print all elements of an array
        //enhanced for loop
        // doesn't provide direct access to index of array
        for(int i:arr4)
            System.out.println(i);
        //normal for loop
         for( int y=0;y< arr3.length;y++)
             System.out.println("Element at index "+y+" is:" +arr3[y]);
         


    }
}
