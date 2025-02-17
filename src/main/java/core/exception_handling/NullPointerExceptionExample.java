package core.exception_handling;

public class NullPointerExceptionExample {
    public static void main(String[] args) {
        String str = null; // Simulating a null value

        try {
            printStringLength(str);
        } catch (NullPointerException e) {
            System.out.println("Exception caught: String is null.");
        }
    }

    public static void printStringLength(String str) {
        if (str == null) {
            throw new NullPointerException("String is null");
        }
        System.out.println("Length of the string: " + str.length());
    }
}
