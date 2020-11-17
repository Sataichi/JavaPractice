package tasks.task1;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {
    public static void main(String[] args) {
        Collection<Person> persons = Stream.of(new Person("Vladimir", Period.of(24, 5, 1)),
            new Person("Dimitry", Period.of(28, 6, 4)),
            new Person("Aliaksandr", Period.of(22, 3, 8)))
            .collect(Collectors.toList());
        Comparator<Person> personNameComparator = (Person p1, Person p2) -> p1.getName().compareTo(p2.getName());
        Comparator<Person> peronAgeComparator =
            (Person p1, Person p2) -> LocalDate.now().plus(p1.getAge()).compareTo(LocalDate.now().plus(p2.getAge()));

        persons.stream()
            .sorted(personNameComparator)
            .peek(System.out::println)
            .sorted(peronAgeComparator)
            .forEach(System.out::println);
    }
}
