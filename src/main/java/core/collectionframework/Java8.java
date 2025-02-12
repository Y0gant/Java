package core.collectionframework;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Java8 {
    public static void main(String[] args) {

        // Predicate Examples
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println(isEven.test(46));

        Predicate<String> isWordStartingFromA = x -> x.toLowerCase().startsWith("a");
        Predicate<String> isEndingWithD = x -> x.toLowerCase().endsWith("d");
        Predicate<String> and = isWordStartingFromA.and(isEndingWithD);
        System.out.println(and.test("Asgard"));

        //Function
        Function<Integer, Integer> doubleIt = x -> 2 * x;
        Function<Integer, Integer> tripleIt = x -> 3 * x;
        System.out.println(doubleIt.andThen(tripleIt).apply(10));
        System.out.println(doubleIt.compose(tripleIt).apply(10));
        System.out.println(doubleIt.apply(200));
        System.out.println(tripleIt.apply(100));
        Function<Integer, Integer> identityFcn = Function.identity();
        System.out.println(identityFcn.apply(5));

        //Consumer
        Consumer<Integer> print = x -> System.out.println(x);
        print.accept(2345);
        List<Integer> list = Arrays.asList(1, 3, 4, 53, 56, 2, 9, 63, 24, 6, 3, 3, 75);
        Consumer<List<Integer>> printList = x -> {
            for (int i : x) {
                System.out.print(i + " ");
            }
        };
        printList.accept(list);//one-liner method to print a list.

        // BiPredicate, BiConsumer, BiFunction

        BiPredicate<Integer, Integer> isSumEven = (x, y) -> (x + y) % 2 == 0;
        System.out.println(isSumEven.test(5, 5));
        BiConsumer<Integer, String> biConsumer = (x, y) -> {
            System.out.println(x);
            System.out.println(y);
        };
        BiFunction<String, String, Integer> biFunction = (x, y) -> (x + y).length();
        System.out.println(biFunction.apply("dhh", "sdhgas"));

        // UnaryOperator, BinaryOperator
        UnaryOperator<Integer> a = x -> 2 * x;
        BinaryOperator<Integer> b = (x, y) -> x + y;

        // Method reference --> use method without invoking & in place of lambda expression
        List<String> students = Arrays.asList("Rhodes", "Happy", "Pepper");
        students.forEach(x -> System.out.println(x));
        students.forEach(System.out::println);


    }
}
