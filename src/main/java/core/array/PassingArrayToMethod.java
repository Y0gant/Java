package core.array;

public class PassingArrayToMethod {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 2, 7, 2, 5};
        sum(arr);
    }

    public static void sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }

}
