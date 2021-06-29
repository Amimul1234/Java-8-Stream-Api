package stream2;

import java.util.Arrays;
import java.util.List;

public class FindElements {
    public static void main( String[] args ) {
        List<Integer> list = Arrays.asList(1, 2, 3, 2, 1, 5);

        list.stream().findFirst().ifPresent(System.out::println);
        list.stream().findAny().ifPresent(System.out::println);
    }
}
