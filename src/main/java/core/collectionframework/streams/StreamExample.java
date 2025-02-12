package core.collectionframework.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {


        //Creating streams using different methods

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        //Collection (list) to stream
        Stream<Integer> stream1 = list.stream();

        String[] array = {"a", "c", "v", "n"};
        //Converting array to stream
        Stream<String> stream2 = Arrays.stream(array);

        //using method Stream.of
        Stream<String> stream3 = Stream.of("abc", "def", "ghi");

        //infinite streams
        Stream<Integer> stream4 = Stream.generate(() -> 1);
        Stream<Integer> stream5 = Stream.iterate(0, (x) -> x + 1);
        Stream<Integer> stream6 = Stream.generate(() -> 1).limit(100);
        Stream<Integer> stream7 = Stream.iterate(1, (x) -> x * 2).limit(30);

        //printing streams
        stream1.forEach(System.out::print);
        System.out.println();
        stream2.forEach(System.out::print);
        System.out.println();
        stream3.forEach(System.out::print);
        System.out.println();
        // stream4.forEach(System.out::print);
        // System.out.println();
        // stream5.forEach(System.out::print);
        // System.out.println();
        stream6.forEach(System.out::print);
        System.out.println();
        stream7.forEach(x -> System.out.print(x + " "));
        System.out.println();


    }
}