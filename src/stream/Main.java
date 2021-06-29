package stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static stream.Gender.FEMALE;
import static stream.Gender.MALE;


//Stream is functional. Doesn't modify source
//Few methods in stream Api:

//Filter
//Sort

//All match -> Every single element in the list must match condition
//Any match -> At least one element in the list must match condition
//None Match -> None should match it

//Max -> Return max element based on comparator
//Min -> Return min element based on comparator

//Group -> Group elements by field


public class Main {

    public static void main( String[] args ) {

        List<Person> personList = getPeople();

        List<Person> people = personList.stream()
                .filter(person -> person.gender().equals(FEMALE))
                .collect(Collectors.toList());

        List<Person> sorted = personList.stream()
                .sorted(Comparator.comparing(Person::age).thenComparing(Person::gender).reversed())
                .collect(Collectors.toList());

        System.out.println(personList.stream()
                .allMatch(person -> person.age() > 8));

        System.out.println(personList.stream()
                .anyMatch(person -> person.age() > 8));

        System.out.println(personList.stream()
                .noneMatch(person -> person.name().equals("Antonio")));

        personList.stream().max(Comparator.comparing(Person::age))
                .ifPresent(System.out::println);


        personList.stream().min(Comparator.comparing(Person::age))
                .ifPresent(System.out::println);

        Map<Gender, List<Person>> groupByGender = personList.stream()
                .collect(Collectors.groupingBy(Person::gender));

        groupByGender.forEach((( gender, people1 ) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
        }));

        Optional<String> oldestFemale = personList.stream()
                .filter(person -> person.gender().equals(FEMALE))
                .max(Comparator.comparing(Person::age))
                .map(Person::name);

        oldestFemale.ifPresent(System.out::println);

    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("James Bond", 20, MALE),
                new Person("Alina Smith", 33, FEMALE),
                new Person("Helen White", 57, FEMALE),
                new Person("Alex Boz", 14, MALE),
                new Person("Jamie Goa", 99, MALE),
                new Person("Anna Cook", 7, FEMALE),
                new Person("Zelda Brown", 120, FEMALE)
        );
    }
}
