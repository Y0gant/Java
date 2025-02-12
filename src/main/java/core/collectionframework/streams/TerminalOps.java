package core.collectionframework.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TerminalOps {
    public static void main(String[] args) {
        List<Integer> randomNumbers = Arrays.asList(
                IntStream.generate(() -> new Random().nextInt(40) + 1)
                        .limit(50)
                        .boxed()
                        .toArray(Integer[]::new)
        );

        //Collect operation
        @SuppressWarnings("all")
        List<Integer> integerStream = randomNumbers.stream().collect(Collectors.toList());
        System.out.println(integerStream);

        //forEach operation
        Stream<Integer> forEachStream = randomNumbers.stream().filter(x -> x % 2 == 0).limit(20);
        forEachStream.forEach(x -> System.out.print(x + " "));
        System.out.println();

        //Count operation
        System.out.println(randomNumbers.stream().filter(x -> x % 2 == 0).count());

        //anyMatch
        System.out.println(randomNumbers.stream().anyMatch(x -> x % 2 != 0));
        //allMatch
        System.out.println(randomNumbers.stream().allMatch(x -> x % 2 != 0));
        //noneMatch
        System.out.println(randomNumbers.stream().noneMatch(x -> x % 2 != 0));

        //findFirst & findAny
        System.out.println(randomNumbers.stream().findFirst());
        System.out.println(randomNumbers.stream().findAny());

        //toArray()
        Object[] array = Stream.of(1, 2, 3).toArray();

        //min / max
        System.out.println("max: " + Stream.of(2, 44, 69).max((o1, o2) -> o2 - o1));
        System.out.println("min: " + Stream.of(2, 44, 69).min(Comparator.naturalOrder()));


        // 9. forEachOrdered
        List<Integer> numbers0 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Using forEach with parallel stream:");
        numbers0.parallelStream().forEach(System.out::println);
        System.out.println("Using forEachOrdered with parallel stream:");
        numbers0.parallelStream().forEachOrdered(System.out::println);


        // Example: Filtering and Collecting Names
        List<String> names = Arrays.asList("Anna", "Bob", "Charlie", "David");
        System.out.println(names.stream().filter(x -> x.length() > 3).toList());

        // Example: Squaring and Sorting Numbers
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 6);
        System.out.println(numbers.stream().map(x -> x * x).sorted().toList());

        // Example: Summing Values
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(integers.stream()
                .reduce(Integer::sum)
                .get());

        // Example:  Counting Occurrences of a Character
        String sentence = "Hello world";
        System.out.println(sentence.chars().filter(x -> x == 'l').count());

        // Example
        // Streams cannot be reused after a terminal operation has been called
        Stream<String> stream = names.stream();
        stream.forEach(System.out::println);
//        List<String> list1 = stream.map(String::toUpperCase).toList(); // exception
    }
}
