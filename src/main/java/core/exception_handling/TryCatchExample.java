package core.exception_handling;

public class TryCatchExample {
    public static void main(String[] args) {
        int[] num = {10, 20, 30, 40, 50};
        int[] den = {2, 3, 0, 6, 5};

        for (int i = 0; i < num.length; i++) {
            try {
                System.out.println(divideNumbers(num[i], den[i]));
            } catch (ArithmeticException e) {
                System.out.println("Arithmetic Exception : cannot divide by zero at index " + i);
            }
        }
    }

    public static int divideNumbers(int a, int b) {
        return a / b;
    }
}
