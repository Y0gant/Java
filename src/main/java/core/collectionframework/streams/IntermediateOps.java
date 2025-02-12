package core.collectionframework.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class IntermediateOps {
    public static void main(String[] args) {
        @SuppressWarnings("SpellCheckingInspection")
        List<String> mythologicalEntities = Arrays.asList(
                "Zeus", "Poseidon", "Hades", "Hera", "Athena", "Apollo",
                "Artemis", "Ares", "Aphrodite", "Hermes", "Hephaestus",
                "Demeter", "Dionysus", "Hestia", "Persephone", "Eros",
                "Nike", "Hypnos", "Thanatos", "Nemesis", "Tyche",
                "Jupiter", "Neptune", "Pluto", "Juno", "Minerva", "Apollo",
                "Diana", "Mars", "Venus", "Mercury", "Vulcan", "Ceres",
                "Bacchus", "Vesta", "Proserpina", "Cupid", "Victoria",
                "Somnus", "Mors", "Nemesis", "Fortuna",
                "Odin", "Thor", "Loki", "Baldur", "Tyr", "Heimdall",
                "Freyja", "Freyr", "Njord", "Frigg", "Sif", "Bragi",
                "Hodr", "Vidar", "Vali", "Ullr", "Forseti", "Ran", "Hel"
        );

        Stream<String> stream = mythologicalEntities.stream();
        //Filter operation
        Stream<String> filteredStream = stream.filter(x -> x.startsWith("A"));//No filtering at this point
        filteredStream.forEach(System.out::println);//filtering happens here as terminal operation invoked
        //Mapping operation
        Stream<String> mappedStream = mythologicalEntities.stream().map(String::toUpperCase);
        mappedStream.forEach(x -> System.out.print(x + " "));
        System.out.println();
        //Sorting operation
        Stream<String> sortedStream = mythologicalEntities.stream().sorted();
        Stream<String> sortedStreamUsingComparator = mythologicalEntities.stream().sorted((a, b) -> a.length() - b.length());
        sortedStream.forEach(x -> System.out.print(x + " "));
        System.out.println();
        sortedStreamUsingComparator.forEach(x -> System.out.print(x + " "));
        System.out.println();
        //Distinct operation
        Stream<String> distinctStream = mythologicalEntities.stream().distinct();
        distinctStream.forEach(x -> System.out.print(x + " "));
        System.out.println();
        //Limit operation
        Stream<String> limitedStream = mythologicalEntities.stream().limit(10);
        limitedStream.forEach(x -> System.out.print(x + " "));
        System.out.println();
        //Skip operation
        Stream<String> skippedStream = mythologicalEntities.stream().skip(5).limit(10);
        skippedStream.forEach(x -> System.out.print(x + " "));
        System.out.println();

    }

}
