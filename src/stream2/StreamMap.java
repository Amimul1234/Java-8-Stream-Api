package stream2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMap {
    public static void main( String[] args ) {

        List<String> alpha = Arrays.asList("a", "b", "c", "d");

        //Make them upper case using map
        alpha.stream().map(String::toUpperCase).collect(Collectors.toList())
                .forEach(System.out::println);

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        //Multiply every element using 4
        integerList.stream().map(n -> n * 4)
                .collect(Collectors.toList()).forEach(System.out::println);
    }
}
