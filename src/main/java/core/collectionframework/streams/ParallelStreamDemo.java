package core.collectionframework.streams;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParallelStreamDemo {
    public static void main(String[] args) {
        //normal stream
        long startTime = System.currentTimeMillis();
        List<Long> list1 = Stream.iterate(1L, x -> x + 1).limit(20000).toList();
        List<Long> factorialStream = list1.stream().map(ParallelStreamDemo::factorial).toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with sequential stream: " + (endTime - startTime) + " ms");

        //Parallel stream
        startTime = System.currentTimeMillis();
        factorialStream = list1.parallelStream().map(ParallelStreamDemo::factorial).toList();
        endTime = System.currentTimeMillis();
        System.out.println("Time taken with parallel stream: " + (endTime - startTime) + " ms");

        //Cumulative Sum
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        AtomicInteger sum = new AtomicInteger(0);
        List<Integer> cumulativeSum = numbers.parallelStream().map(sum::addAndGet).toList();
        System.out.println("Expected cumulative sum: [1, 3, 6, 10, 15]");
        System.out.println("Actual result with parallel stream: " + cumulativeSum);


    }

    private static long factorial(long n) {
        long result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
