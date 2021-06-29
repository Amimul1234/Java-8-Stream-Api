package stream2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class CountMinMax {
    public static void main( String[] args ) {

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 10, 2, 7, 52);

        System.out.println(integerList.stream().count());

        integerList.stream().max(Comparator.naturalOrder())
                .ifPresent(System.out::println);

        integerList.stream().min(Comparator.naturalOrder())
                .ifPresent(System.out::println);
    }
}
