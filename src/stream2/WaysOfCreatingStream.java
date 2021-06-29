package stream2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class WaysOfCreatingStream {

    public static void main( String[] args ) {
        //Ways of creating stream in java

        //Stream from collection
        List<String> stringList = Arrays.asList("this", "is", "an", "stream", "practice", "project");
        Stream<String> stream1 = stringList.stream();
        stream1.forEach(System.out::println);

        //Stream from specified values
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        stream2.forEach(System.out::println);

        //Stream from arrays
        String[] strings = new String[]{"a", "b", "c"};
        Stream<String> stream3 = Arrays.stream(strings);
        stream3.forEach(System.out::println);

        //Empty stream
        Stream<String> stream4 = Stream.empty();
        stream4.forEach(System.out::println);

        //Stream using stream builder
        Stream.Builder<String> builder = Stream.builder();

        Stream<String> stream5 = builder
                .add("a")
                .add("b")
                .add("c")
                .add("d")
                .build();

        stream5.forEach(System.out::println);

        //Infinite stream using Stream.iterate()
        int seedValue1 = 2;
        int limitTerms1 = 5;
        Stream<Integer> stream6 = Stream.iterate(seedValue1, integer -> integer + 2)
                .limit(limitTerms1);
        stream6.forEach(System.out::println);

        //Create unordered stream
        int limitTerms2 = 5;
        Stream<Double> stream7 = Stream.generate(Math::random)
                .limit(limitTerms2);
        stream7.forEach(System.out::println);


        //Stream from pattern using predicate
        List<String> list
                = Arrays
                .asList("Geeks",
                        "For",
                        "Geek",
                        "GeeksForGeeks",
                        "A Computer Portal");

        Pattern p = Pattern.compile("^G");
        Stream<String> stream8 = list.stream().filter(p.asPredicate());
        stream8.forEach(System.out::println);

    }
}
