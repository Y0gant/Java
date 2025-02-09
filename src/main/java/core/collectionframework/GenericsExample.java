package core.collectionframework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 5. Generic Interface
interface GenericInterface<T> {
    void display(T data);
}

// 1. Generic Class
class Box<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

// 2. Generic Method
class GenericMethodExample {
    // Generic method to print array
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

// 3. Bounded Type Parameters
class MathUtil<T extends Number> { // T must be a subclass of Number
    private final T num;

    public MathUtil(T num) {
        this.num = num;
    }

    public double square() {
        return num.doubleValue() * num.doubleValue();
    }
}

// 4. Wildcards in Generics
class WildcardExample {
    // Unbounded Wildcard method
    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    // Upper Bounded Wildcard method
    public static double sum(List<? extends Number> list) {
        double total = 0;
        for (Number num : list) {
            total += num.doubleValue();
        }
        return total;
    }

    // Lower Bounded Wildcard method
    public static void addNumbers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
    }
}

// Implementing the GenericInterface
class StringPrinter implements GenericInterface<String> {
    public void display(String data) {
        System.out.println("Data: " + data);
    }
}

// Main class to execute all the examples
public class GenericsExample {
    public static void main(String[] args) {
        // 1. Generic Class Example
        Box<Integer> intBox = new Box<>();
        intBox.setValue(10);
        System.out.println("Box contains: " + intBox.getValue());

        Box<String> strBox = new Box<>();
        strBox.setValue("Hello Generics");
        System.out.println("Box contains: " + strBox.getValue());

        // 2. Generic Method Example
        Integer[] intArr = {1, 2, 3, 4};
        String[] strArr = {"A", "B", "C"};

        GenericMethodExample.printArray(intArr);
        GenericMethodExample.printArray(strArr);

        // 3. Bounded Type Parameters Example
        MathUtil<Integer> intUtil = new MathUtil<>(5);
        System.out.println("Square of 5: " + intUtil.square());

        MathUtil<Double> doubleUtil = new MathUtil<>(4.5);
        System.out.println("Square of 4.5: " + doubleUtil.square());

        // 4. Wildcards in Generics
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);
        List<Number> numList = new ArrayList<>();

        // Unbounded Wildcard
        WildcardExample.printList(intList);
        WildcardExample.printList(doubleList);

        // Upper Bounded Wildcard
        System.out.println("Sum of intList: " + WildcardExample.sum(intList));
        System.out.println("Sum of doubleList: " + WildcardExample.sum(doubleList));

        // Lower Bounded Wildcard
        WildcardExample.addNumbers(numList);
        System.out.println("Numbers added to numList: " + numList);


        // 5. Generic Interface
        GenericInterface<String> stringPrinter = new StringPrinter();
        stringPrinter.display("Hello from Generic Interface!");
    }
}

